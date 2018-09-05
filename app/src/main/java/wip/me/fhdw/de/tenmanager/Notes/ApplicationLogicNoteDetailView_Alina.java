package wip.me.fhdw.de.tenmanager.Notes;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

import wip.me.fhdw.de.tenmanager.Constants;
import wip.me.fhdw.de.tenmanager.NavigationItemSelectListener_Lena;
import wip.me.fhdw.de.tenmanager.R;

public class ApplicationLogicNoteDetailView_Alina {
    //Variablen Deklaration & Instanziierung
    private static final String TAG = "AppLogic_Alina";

    private GuiNoteDetailView_Alina mGui;
    private NoteData_Julius mData;
    private View mView;
    private UserInputValidationNoteDetailView_Alina mUserInputValidation;
    private Activity mActivity;


    //Konstruktor
    public ApplicationLogicNoteDetailView_Alina(Activity activity, NoteData_Julius data, GuiNoteDetailView_Alina gui) {
        mActivity = activity;
        mGui = gui;
        mData = data;
        initGui();
        initListener();
        initUserInputValidation();
    }


    private void initGui() {
        dataToGui();
    }

    public void initListener()
    {
        NoteFloatingActionButtonClickListener_Julius floatingActionButtonClickListener = new NoteFloatingActionButtonClickListener_Julius(this);
        mGui.getFabSave().setOnClickListener(floatingActionButtonClickListener);
        NavigationItemSelectListener_Lena navigationItemSelectListener = new NavigationItemSelectListener_Lena(this);
        mGui.getNavigationView().setNavigationItemSelectedListener(navigationItemSelectListener);
        mGui.getCameraButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                mActivity.startActivityForResult(intent, 0);

            }
        });
    }

    public void dataToGui()
    {
        mGui.getEditTextTitle().setText(mData.getNoteTitle());
        mGui.getEditTextContent().setText(mData.getNoteContent());

        List<String> StringUriList = new ArrayList<>();


        if(mData.getPictureString() != null){
            StringUriList = getStringUriList(mData.getPictureString());
            if(StringUriList.size() != 0) {
                if (StringUriList.size() > 0 && StringUriList.get(0) != null) {
                    mGui.getImageView1().setImageURI(Uri.parse(StringUriList.get(0)));
                }
                if (StringUriList.size() > 1 && StringUriList.get(1) != null) {
                    mGui.getImageView2().setImageURI(Uri.parse(StringUriList.get(1)));
                }
                if (StringUriList.size() > 2 && StringUriList.get(2) != null) {
                    mGui.getImageView3().setImageURI(Uri.parse(StringUriList.get(2)));
                }
                if (StringUriList.size() > 3 && StringUriList.get(3) != null) {
                    mGui.getImageView4().setImageURI(Uri.parse(StringUriList.get(3)));
                }
                if (StringUriList.size() > 4 && StringUriList.get(4) != null) {
                    mGui.getImageView5().setImageURI(Uri.parse(StringUriList.get(4)));
                }
            }
        }


    }

    //Einbindung der UserInputValidation Java-Class, Instanziierung??
    private void initUserInputValidation(){
        mUserInputValidation = new UserInputValidationNoteDetailView_Alina(mGui);
    }
    //Methode zum Speichern wenn man auf den "Speicher-Button" klickt
    public void onFabSaveClicked()
    {
        boolean noteExists = false;
        if(mUserInputValidation.confirmInput()) return;

        String titleOld = mData.getNoteTitle();
        String contentOld = mData.getNoteContent();

        String title = mGui.getEditTextTitle().getText().toString();
        String content = mGui.getEditTextContent().getText().toString();
        String pictureString = createPictureString();

        if(mData.getDb().noteDao().noteExists(title)!=0) noteExists = true;
        if(!noteExists || mData.getWithData()) {
            mData.setNoteTitle(title);
            mData.setNoteContent(content);
            mData.setNotePictureString(pictureString);
        }
        if(mData.getWithData())
        {
            mData.updateNote(titleOld, contentOld);
        }
        else
        {

            if(noteExists)
            {
                Toast.makeText(mData.getActivity().getApplicationContext(),"Es gibt bereits ein Note mit diesem Titel!", Toast.LENGTH_LONG ).show();

                return;
            }
            mData.createAndSaveNewNote();
        }
        finishActivityResultOk();
    }

    public void onMenuItemSelected(MenuItem item)
    {
        int id = item.getItemId();

        if(id == R.id.menuHome)
        {
            startActivity(Constants.ACTIVITYHOMEPAGECLASS, false);
            mData.getActivity().overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
        }
        else if (id == R.id.menuNotes) {

            startActivity(Constants.ACTIVITYNOTEOVERVIEWCLASS, false);
            mData.getActivity().overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);

        } else if (id == R.id.menuEvent) {

            startActivity(Constants.ACTIVITYEVENTSOVERVIEWCLASS, false);
            mData.getActivity().overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);

        } else if (id == R.id.menuTodo) {

            startActivity(Constants.ACTIVITYTODOOVERVIEWCLASS, false);
            mData.getActivity().overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
        }

        DrawerLayout drawer = (DrawerLayout) mActivity.findViewById(R.id.drawer);
        drawer.closeDrawer(GravityCompat.START);
    }

    public void onBackPressed() {
        finishActivityResultCancelled();

    }


    public void startActivity(Class<?> activityClass, boolean withData) //?: Elementtyp der Klasse ist offen
    {
        Intent intent = new Intent();
        intent.setClass(mData.getActivity(), activityClass);

        if(withData){ intent.putExtra(Constants.KEYDATABUNDLE, mData.getDataBundle());}

        mData.getActivity().startActivityForResult(intent, Constants.REQUESTCODEONE);
    }

    //finish Activities
    public void onActivityReturned(int requestCode, int resultCode, Intent intent) {
        int value;
        if ( resultCode == Activity.RESULT_OK ) {
            switch (requestCode) {
                case Constants.REQUESTCODEONE:
                    mData.readIntentParametersOrSetDefaultValues(intent);
                    dataToGui();
                    break;
            }
        }
        Bitmap bitmap = (Bitmap)intent.getExtras().get("data");
        boolean allreadySet = false;
        if(mGui.getImageView1().getDrawable() == null) {

                mGui.getImageView1().setImageBitmap(bitmap);
                allreadySet = true;
        }
        if(allreadySet == false && mGui.getImageView2().getDrawable() == null) {

            mGui.getImageView2().setImageBitmap(bitmap);
            allreadySet = true;
        }
        if(allreadySet == false && mGui.getImageView3().getDrawable() == null ) {

            mGui.getImageView3().setImageBitmap(bitmap);
            allreadySet = true;
        }
        if(allreadySet == false && mGui.getImageView4().getDrawable() == null) {

            mGui.getImageView4().setImageBitmap(bitmap);
            allreadySet = true;
        }
        if(allreadySet == false && mGui.getImageView5().getDrawable() == null) {

            mGui.getImageView5().setImageBitmap(bitmap);
        }
    }


    private void finishActivityResultOk()
    {
        Intent intent = new Intent();
        intent.putExtra(Constants.KEYDATABUNDLE, mData.getDataBundle());
        mData.getActivity().setResult(Activity.RESULT_OK, intent);
        mData.getActivity().finish();
        mData.getActivity().overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right);
    }



    private void finishActivityResultCancelled() {
        Intent intent = new Intent();
        intent.putExtra(Constants.KEYDATABUNDLE, mData.getDataBundle());
        mData.getActivity().setResult(Activity.RESULT_CANCELED, intent);
        mData.getActivity().finish();
        mData.getActivity().overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right);
    }

    public void restoreInstanceState(Bundle outState)
    {
        mGui.getEditTextTitle().setText(outState.getString("NoteTitel"));
        mData.setNoteContent(outState.getString("NoteContent"));
        mData.setWithData(outState.getBoolean("WithData"));
    }
    private List<String> getStringUriList(String uriString){

        List<String> uriList = new ArrayList<String>();
        int counter = 0;

            for (int i = 0; i < uriString.length(); i++) {
                if (uriString.charAt(i) == ';') {
                    uriList.add(uriString.substring(counter, i));
                    counter = i + 1;
                }
            }

        return uriList;
    }


    private String createPictureString(){

        String pictureString = "";

        if(mGui.getImageView1().getDrawable() != null) {
            if (getImageString(mActivity.getApplicationContext(), ((BitmapDrawable) mGui.getImageView1().getDrawable()).getBitmap()) != null) {
                pictureString = pictureString + getImageString(mActivity.getApplicationContext(), ((BitmapDrawable) mGui.getImageView1().getDrawable()).getBitmap()) + ";";
            }
        }
        if(mGui.getImageView2().getDrawable() != null) {
            if (getImageString(mActivity.getApplicationContext(), ((BitmapDrawable) mGui.getImageView2().getDrawable()).getBitmap()) != null) {
                pictureString = pictureString + getImageString(mActivity.getApplicationContext(), ((BitmapDrawable) mGui.getImageView2().getDrawable()).getBitmap()) + ";";
            }
        }
        if(mGui.getImageView3().getDrawable() != null) {
            if (getImageString(mActivity.getApplicationContext(), ((BitmapDrawable) mGui.getImageView3().getDrawable()).getBitmap()) != null) {
                pictureString = pictureString + getImageString(mActivity.getApplicationContext(), ((BitmapDrawable) mGui.getImageView3().getDrawable()).getBitmap()) + ";";
            }
        }
        if(mGui.getImageView4().getDrawable() != null) {
            if (getImageString(mActivity.getApplicationContext(), ((BitmapDrawable) mGui.getImageView4().getDrawable()).getBitmap()) != null) {
                    pictureString = pictureString + getImageString(mActivity.getApplicationContext(), ((BitmapDrawable) mGui.getImageView4().getDrawable()).getBitmap()) + ";";
            }
        }
        if(mGui.getImageView5().getDrawable() != null) {
            if (getImageString(mActivity.getApplicationContext(), ((BitmapDrawable) mGui.getImageView5().getDrawable()).getBitmap()) != null) {
                        pictureString = pictureString + getImageString(mActivity.getApplicationContext(), ((BitmapDrawable) mGui.getImageView5().getDrawable()).getBitmap()) + ";";
            }
        }

        return pictureString;
    }

    private String getImageString(Context inContext, Bitmap inImage) {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        inImage.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
        String path = MediaStore.Images.Media.insertImage(inContext.getContentResolver(), inImage, "Title", null);
        return path;
    }
}
