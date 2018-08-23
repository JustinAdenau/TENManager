package wip.me.fhdw.de.tenmanager.Notes;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.Calendar;

import wip.me.fhdw.de.tenmanager.AppDatabase;
import wip.me.fhdw.de.tenmanager.Constants;
import wip.me.fhdw.de.tenmanager.Events.EventFloatingActionButtonClickListener_Lena;
import wip.me.fhdw.de.tenmanager.NavigationItemSelectListener;
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
        NavigationItemSelectListener navigationItemSelectListener = new NavigationItemSelectListener(this);
        mGui.getNavigationView().setNavigationItemSelectedListener(navigationItemSelectListener);
    }


//todo

    public void dataToGui()
    {
        mGui.getEditTextTitle().setText(mData.getNoteTitle());
        mGui.getEditTextContent().setText(mData.getNoteContent());
    }




    /////////////////////////////////////////////
    // AppLogic
    ////////////////////////////////////////////7


    //todo Methoden einfügen
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
        Bitmap picture = ((BitmapDrawable) mGui.getImageView().getDrawable()).getBitmap();

        if(mData.getDb().noteDao().noteExists(title)!=0) noteExists = true;
        if(!noteExists || mData.getWithData()) {
            mData.setNoteTitle(title);
            mData.setNoteContent(content);
            mData.setNotePicture(picture);
        }
        Log.d("LOGTAG", "withData: "+mData.getWithData());
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

        if (id == R.id.menuNotes) {

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
        Log.d("LOGTAG", "onBackPress called");
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
        Log.d("LOGTAG", "onActivityReturned ...");
        Log.d("LOGTAG", "  resultCode: " + resultCode);
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
        mGui.getImageView().setImageBitmap(bitmap);
    }


    private void finishActivityResultOk()
    {
        Intent intent = new Intent();
        intent.putExtra(Constants.KEYDATABUNDLE, mData.getDataBundle());
        mData.getActivity().setResult(Activity.RESULT_OK, intent);
        Log.d("LOGTAG", "finishActivityResultOk");
        mData.getActivity().finish();
        mData.getActivity().overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right);
    }



    private void finishActivityResultCancelled() {
        Intent intent = new Intent();
        intent.putExtra(Constants.KEYDATABUNDLE, mData.getDataBundle());
        mData.getActivity().setResult(Activity.RESULT_CANCELED, intent);
        Log.d("LOGTAG", "finishActivityResultCancel");
        mData.getActivity().finish();
        mData.getActivity().overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right);
    }
}
