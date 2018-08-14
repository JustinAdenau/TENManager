package wip.me.fhdw.de.tenmanager.Notes;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.Calendar;

import wip.me.fhdw.de.tenmanager.AppDatabase;
import wip.me.fhdw.de.tenmanager.Constants;
import wip.me.fhdw.de.tenmanager.Events.EventFloatingActionButtonClickListener_Lena;

public class ApplicationLogicNoteDetailView_Alina {
    private static final String TAG = "AppLogic_Alina";

    private GuiNoteDetailView_Alina mGui;
    private NoteData_Julius mData;
    private View mView;
    private UserInputValidationNoteDetailView_Alina mUserInputValidation;



    public ApplicationLogicNoteDetailView_Alina(NoteData_Julius data, GuiNoteDetailView_Alina gui) {
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
    private void initUserInputValidation(){
        mUserInputValidation = new UserInputValidationNoteDetailView_Alina(mGui);
    }

    public void onFabSaveClicked()
    {
        if(mUserInputValidation.confirmInput()) return;
        String title = mData.getNoteTitle();
        String content = mGui.getEditTextContent().getText().toString();

        if(mData.getWithData())
        {
            mData.updateNote(title, content);
        }
        else
        {
            mData.createAndSaveNewNote();
        }
        finishActivityResultOk();
    }


    public void onBackPressed() {
        Log.d("LOGTAG", "onBackPress called");
        finishActivityResultCancelled();
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
    }


    private void finishActivityResultOk()
    {
        Intent intent = new Intent();
        intent.putExtra(Constants.KEYDATABUNDLE, mData.getDataBundle());
        mData.getActivity().setResult(Activity.RESULT_OK, intent);
        Log.d("LOGTAG", "finishActivityResultOk");
        mData.getActivity().finish();
    }



    private void finishActivityResultCancelled() {
        Intent intent = new Intent();
        intent.putExtra(Constants.KEYDATABUNDLE, mData.getDataBundle());
        mData.getActivity().setResult(Activity.RESULT_CANCELED, intent);
        Log.d("LOGTAG", "finishActivityResultCancel");
        mData.getActivity().finish();
    }
}
