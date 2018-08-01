package wip.me.fhdw.de.tenmanager;


import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.View;

import java.util.Calendar;

public class ApplicationLogicEventsDetailView_Sebastian  {

    private static final String TAG = "AppLogic_Sebastian";

    private GuiEventsDetailView_Sebastian mGui;
    private Data mData;
    private View mView;
    private DatepickerStartEventsDetailView_Sebastian datepickerStart;
    private DatepickerEndEventsDetailView_Sebastian datepickerEnd;
    private TimepickerStartEventsDetailView_Sebastian timepickerStart;
    private TimepickerEndEventsDetailView_Sebastian timepickerEnd;


    //todo mDateStart mDateEnd mTimeStart mTimeEnd
    private String mTitle;
    private String mDate;
    private String mTime;
    private String mDescription;
    private String mLocation;





    public ApplicationLogicEventsDetailView_Sebastian(Data data, GuiEventsDetailView_Sebastian gui) {
        mGui = gui;
        mData = data;
        initGui();
        //initListener();
        initCurrentDate();
        initCurrentTime();
        initDatepickerStart();
        initDatepickerEnd();
        initTimepickerStart();
        initTimepickerEnd();
    }


    private void initGui() {
        dataToGui();
    }

    /*public void initListener(){

        mGui.getEditTextTitle().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                onTextViewTitleChanged(mGui.getEditTextTitle().getText().toString());
            }
            @Override
            public void afterTextChanged(Editable editable) { }
        });

        //TODO: überprüfen, ob der Listener beim Button greift
        mGui.getButtonTextDate().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                onTextViewDateChanged(mGui.getButtonTextDate().getText().toString());
            }
            @Override
            public void afterTextChanged(Editable editable) { }
        });

        mGui.getEditTextTime().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                onTextViewTimeChanged(mGui.getEditTextTime().getText().toString());
            }
            @Override
            public void afterTextChanged(Editable editable) { }
        });

        mGui.getEditTextDescription().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                onTextViewDescriptionChanged(mGui.getEditTextDescription().getText().toString());
            }
            @Override
            public void afterTextChanged(Editable editable) {}
        });

        mGui.getEditTextLocation().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                onTextViewLocationChanged(mGui.getEditTextLocation().getText().toString());
            }
            @Override
            public void afterTextChanged(Editable editable) { }
        });

        mGui.getEditTextSpan().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                onTextViewSpanChanged(mGui.getEditTextSpan().getText().toString());
            }
            @Override
            public void afterTextChanged(Editable editable) {}
        });
    }*/


//todo

    public void dataToGui()
    {
        mGui.getEditTextTitle().setText(mData.getEventTitle());
        mGui.getButtonDateStart().setText(mData.getEventDateStart());
        mGui.getButtonDateEnd().setText(mData.getEventDateEnd());
        mGui.getButtonTimeStart().setText(mData.getEventTimeStart());
        mGui.getButtonTimeEnd().setText(mData.getEventTimeEnd());
        mGui.getEditTextDescription().setText(mData.getEventDescription());
        mGui.getEditTextLocation().setText(mData.getEventLocation());
    }




    /////////////////////////////////////////////
    // AppLogic
    ////////////////////////////////////////////7




    //todo in if auch  ButtonDateEnd Befüllung anfragen
    private void initCurrentDate(){
        if(mGui.getButtonDateStart().getText() != null /*|| !mGui.getButtonDate().getText().equals("")*/) return;
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        month = month+1;

        mGui.getButtonDateStart().setText(String.format("%02d/%02d/%04d", day, month, year));
        mGui.getButtonDateEnd().setText(String.format("%02d/%02d/%04d", day, month, year));
    }

    //todo in if auch  ButtonTimeEnd Befüllung anfragen
    private void initCurrentTime(){
        if(mGui.getButtonTimeStart().getText() != null /*|| !mGui.getButtonTime().getText().equals("")*/) return;
        Calendar cal = Calendar.getInstance();
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        int minute;

        hour = hour+1;
        minute = 00;

        mGui.getButtonTimeStart().setText(String.format("%02d:%02d", hour, minute));
        mGui.getButtonTimeEnd().setText(String.format("%02d:%02d", hour+1, minute));
    }


    private void initDatepickerStart(){
        datepickerStart = new DatepickerStartEventsDetailView_Sebastian(mGui);
        datepickerStart.buildDateStartpicker();
        datepickerStart.setDateStartToButton();
    }

    private void initDatepickerEnd(){
        datepickerEnd = new DatepickerEndEventsDetailView_Sebastian(mGui);
        datepickerEnd.buildDateEndpicker();
        datepickerEnd.setDateEndToButton();
    }


    private void initTimepickerStart(){
        timepickerStart = new TimepickerStartEventsDetailView_Sebastian(mGui);
        timepickerStart.bulidTimeStartpicker();
    }

    private void initTimepickerEnd(){
        timepickerEnd = new TimepickerEndEventsDetailView_Sebastian(mGui);
        timepickerEnd.bulidTimeEndpicker();
    }




    /*public void onTextViewTitleChanged(String title){mTitle = title;}

    public void onTextViewDateChanged(String date){mDate = date;}

    public void onTextViewTimeChanged(String time){mTime = time;}

    public void onTextViewDescriptionChanged(String description){mDescription = description;}

    public void onTextViewLocationChanged(String location){mLocation = location;}

    public void onTextViewSpanChanged(String span){mSpan = span;}*/


    //todo Anpassungen an Start und End Time/Date
    public void onFabSaveClicked() {
        mTitle = mGui.getEditTextTitle().getText().toString();
        mDate = mGui.getButtonDateStart().getText().toString();
        mTime = mGui.getButtonTimeStart().getText().toString();
        mDescription = mGui.getEditTextDescription().getText().toString();
        mLocation = mGui.getEditTextLocation().getText().toString();


        //mData.createAndSaveNewEvent(mTitle, mDate, mTime, mDescription, mLocation, mSpan);
       mData.createAndSaveNewEvent(mTitle, mDate, mTime, mDescription, mLocation);
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


    private void finishActivityResultCancelled() {
        Intent intent = new Intent();
        intent.putExtra(Constants.KEYDATABUNDLE, mData.getDataBundle());
        mData.getActivity().setResult(Activity.RESULT_CANCELED, intent);
        Log.d("LOGTAG", "finishActivityResultCancel");
        mData.getActivity().finish();
    }

    //todo save data bei landscape
}
