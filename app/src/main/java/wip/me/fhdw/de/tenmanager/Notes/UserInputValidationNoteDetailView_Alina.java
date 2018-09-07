package wip.me.fhdw.de.tenmanager.Notes;

import android.support.design.widget.TextInputLayout;

public class UserInputValidationNoteDetailView_Alina {
    private static final String TAG = "UserInputVali_Alina";

    private GuiNoteDetailView_Alina mGui;
    private TextInputLayout mTitleValidation;
    private TextInputLayout mContentValidation;


    public UserInputValidationNoteDetailView_Alina(GuiNoteDetailView_Alina gui){
        mGui = gui;
        mTitleValidation = mGui.getTextInputLayoutTitle();
        mContentValidation = mGui.getTextInputLayoutContent();
    }

    private boolean validateTitle(){
        String titleInput;

        titleInput = mTitleValidation.getEditText().getText().toString().trim();
        if (titleInput.isEmpty()){
            mTitleValidation.setError("Bitte einen Titel eingeben");
            return false;
        } else {
            mTitleValidation.setError(null);
            return true;
        }
    }

    private boolean validateContent(){
        String contentInput;

        contentInput = mContentValidation.getEditText().getText().toString().trim();
        if (contentInput.isEmpty()){
            mContentValidation.setError("Bitte einen Text eingeben");
            return false;
        } else {
            mContentValidation.setError(null);
            return true;
        }
    }




    public boolean confirmInput(){
        if (!validateTitle() | !validateContent()){
            return true;
        } else {
            return false;
        }
    }

}
