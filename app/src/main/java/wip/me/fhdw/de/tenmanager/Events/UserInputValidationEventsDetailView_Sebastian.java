package wip.me.fhdw.de.tenmanager.Events;

import android.support.design.widget.TextInputLayout;
import android.util.Log;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class UserInputValidationEventsDetailView_Sebastian {

    private static final String TAG = "UserInputVali_Sebastian";


    private GuiEventsDetailView_Sebastian mGui;
    private TextInputLayout mTitleValidation;
    private TextInputLayout mLocationValidation;
    private TextInputLayout mDescriptionValidation;
    private TextView mDateTimeValidation;




    public UserInputValidationEventsDetailView_Sebastian(GuiEventsDetailView_Sebastian gui){
        mGui = gui;

        mTitleValidation = mGui.getTextInputLayoutTitle();
        mLocationValidation = mGui.getTextInputLayoutLocation();
        mDescriptionValidation = mGui.getTextInputLayoutDescription();
        mDateTimeValidation = mGui.getTextViewDateTimeValidation();
    }

    //validation title is not empty
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

    //validation location is not empty
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

    //validation description is not empty
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

    //validation start time is before end time
    private boolean validateDateTime(){

        Calendar calendarStart;
        Calendar calendarEnd;

        calendarStart = Calendar.getInstance();
        calendarEnd = Calendar.getInstance();


        int hourStart = Integer.parseInt(mGui.getButtonTimeStart().getText().toString().substring(0,2));
        int minuteStart = Integer.parseInt(mGui.getButtonTimeStart().getText().toString().substring(3, 5));
        int dayStart = Integer.parseInt(mGui.getButtonDateStart().getText().toString().substring(0,2));
        int monthStart = Integer.parseInt(mGui.getButtonDateStart().getText().toString().substring(3, 5))-1;
        int yearStart = Integer.parseInt(mGui.getButtonDateStart().getText().toString().substring(6,10));

        int hourEnd = Integer.parseInt(mGui.getButtonTimeEnd().getText().toString().substring(0,2));
        int minuteEnd = Integer.parseInt(mGui.getButtonTimeEnd().getText().toString().substring(3, 5));
        int dayEnd = Integer.parseInt(mGui.getButtonDateEnd().getText().toString().substring(0,2));
        int monthEnd = Integer.parseInt(mGui.getButtonDateEnd().getText().toString().substring(3, 5))-1;
        int yearEnd = Integer.parseInt(mGui.getButtonDateEnd().getText().toString().substring(6,10));

        calendarStart.set(Calendar.HOUR_OF_DAY, hourStart );
        calendarStart.set(Calendar.MINUTE, minuteStart);
        calendarStart.set(Calendar.YEAR, yearStart);
        calendarStart.set(Calendar.MONTH, monthStart);
        calendarStart.set(Calendar.DAY_OF_MONTH, dayStart);
        calendarEnd.set(Calendar.HOUR_OF_DAY, hourEnd);
        calendarEnd.set(Calendar.MINUTE, minuteEnd);
        calendarEnd.set(Calendar.YEAR, yearEnd);
        calendarEnd.set(Calendar.MONTH, monthEnd);
        calendarEnd.set(Calendar.DAY_OF_MONTH, dayEnd);

        if(calendarEnd.getTime().getTime() <= calendarStart.getTime().getTime()){
            mDateTimeValidation.setText("Das Startdatum muss vor dem Enddatum liegen");
            return false;
        } else {
            mDateTimeValidation.setText(null);
            return true;
        }
    }

    //proof all validations are true
    public boolean confirmInput(){
        if(!validateTitle() | !validateLocation() | !validateDescription() | !validateDateTime()){
           return true;
        } else {
            return false;
        }


        //todo weitermachen hier! https://www.youtube.com/watch?v=veOZTvAdzJ8&t=116s

    }




}
