package wip.me.fhdw.de.tenmanager;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Calendar;

public class ApplicationLogicEventsDetailView_Sebastian  {

    private static final String TAG = "AppLogic_Sebastian";

    private GuiEventsDetailView_Sebastian mGui;
    private Data mData;
    private View mView;
    private DatepickerEventsDetailView_Sebastian datepicker;
    private TimepickerEventsDetailView_Sebastian timepicker;
    private SpanpickerEventsDetailView_Sebastian spanpicker;

    private String mTitle;
    private String mDate;
    private String mTime;
    private String mDescription;
    private String mLocation;
    private String mSpan;




    public ApplicationLogicEventsDetailView_Sebastian(Data data, GuiEventsDetailView_Sebastian gui) {
        mGui = gui;
        mData = data;
        initGui();
        //initListener();
        initCurrentDate();
        initCurrentTime();
        initDatepicker();
        initTimepicker();
        initSpanpicker();
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
        mGui.getButtonDate().setText(mData.getEventDate());
        mGui.getButtonTime().setText(mData.getEventTime());
        mGui.getEditTextDescription().setText(mData.getEventDescription());
        mGui.getEditTextLocation().setText(mData.getEventLocation());
        mGui.getButtonSpan().setText(mData.getEventSpan());
    }




    /////////////////////////////////////////////
    // AppLogic
    ////////////////////////////////////////////7





    private void initCurrentDate(){
        if(mGui.getButtonDate().getText() != null /*|| !mGui.getButtonDate().getText().equals("")*/) return;
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        month = month+1;

        mGui.getButtonDate().setText(String.format("%02d/%02d/%04d", day, month, year));
    }


    private void initCurrentTime(){
        if(mGui.getButtonTime().getText() != null /*|| !mGui.getButtonTime().getText().equals("")*/) return;
        Calendar cal = Calendar.getInstance();
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        int minute;

        hour = hour+1;
        minute = 00;

        mGui.getButtonTime().setText(String.format("%02d:%02d", hour, minute));
    }


    private void initDatepicker(){
        datepicker = new DatepickerEventsDetailView_Sebastian(mGui);
        datepicker.buildDatepicker();
        datepicker.setDateToButton();
    }


    private void initTimepicker(){
        timepicker = new TimepickerEventsDetailView_Sebastian(mGui);
        timepicker.bulidTimepicker();
    }


    private void initSpanpicker(){
        spanpicker = new SpanpickerEventsDetailView_Sebastian(mGui);
        spanpicker.BuildSpanpicker();
    }



    /*public void onTextViewTitleChanged(String title){mTitle = title;}

    public void onTextViewDateChanged(String date){mDate = date;}

    public void onTextViewTimeChanged(String time){mTime = time;}

    public void onTextViewDescriptionChanged(String description){mDescription = description;}

    public void onTextViewLocationChanged(String location){mLocation = location;}

    public void onTextViewSpanChanged(String span){mSpan = span;}*/



    public void onFabSaveClicked()
    {
        mTitle = mGui.getEditTextTitle().getText().toString();
        mDate = mGui.getButtonDate().getText().toString();
        mTime = mGui.getButtonTime().getText().toString();
        mDescription = mGui.getEditTextDescription().getText().toString();
        mLocation = mGui.getEditTextLocation().getText().toString();
        mSpan = mGui.getButtonSpan().getText().toString();

        mData.createAndSaveNewEvent(mTitle, mDate, mTime, mDescription, mLocation, mSpan);
    }


    public void onBackPressed()
    {
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


    private void finishActivityResultCancelled()
    {
        Intent intent = new Intent();
        intent.putExtra(Constants.KEYDATABUNDLE, mData.getDataBundle());
        mData.getActivity().setResult(Activity.RESULT_CANCELED, intent);
        Log.d("LOGTAG", "finishActivityResultCancel");
        mData.getActivity().finish();
    }
}
