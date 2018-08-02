package wip.me.fhdw.de.tenmanager;

import android.support.design.widget.TextInputLayout;

public class UserInputValidationEventsDetailView_Sebastian {

    private static final String TAG = "UserInputVali_Sebastian";

    private GuiEventsDetailView_Sebastian mGui;
    private TextInputLayout mTitleValidation;
    private TextInputLayout mLocationValidation;
    private TextInputLayout mDescriptionValidation;


    public UserInputValidationEventsDetailView_Sebastian(GuiEventsDetailView_Sebastian gui){
        mGui = gui;

        mTitleValidation = mGui.getTextInputLayoutTitle();
        mLocationValidation = mGui.getTextInputLayoutLocation();
        mDescriptionValidation = mGui.getTextInputLayoutDescription();
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

    private boolean validateLocation(){
        String lacationInput;

        lacationInput = mLocationValidation.getEditText().getText().toString().trim();
        if (lacationInput.isEmpty()){
            mLocationValidation.setError("Bitte einen Standort eingeben");
            return false;
        } else {
            mLocationValidation.setError(null);
            return true;
        }
    }

    private boolean validateDescription(){
        String descriptionInput;

        descriptionInput = mDescriptionValidation.getEditText().getText().toString().trim();
        if (descriptionInput.isEmpty()){
            mDescriptionValidation.setError("Bitte eine Beschreibung eingeben");
            return false;
        } else {
            mDescriptionValidation.setError(null);
            return true;
        }
    }




    public boolean confirmInput(){
        if (!validateTitle() | !validateLocation() | !validateDescription()){
            return true;
        } else {
            return false;
        }


        //todo weitermachen hier! https://www.youtube.com/watch?v=veOZTvAdzJ8&t=116s

    }




}
