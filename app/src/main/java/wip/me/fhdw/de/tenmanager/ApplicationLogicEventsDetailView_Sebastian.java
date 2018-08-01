package wip.me.fhdw.de.tenmanager;


import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.View;

import java.util.Calendar;

public class ApplicationLogicEventsDetailView_Sebastian  {

    private static final String TAG = "AppLogic_Sebastian";

    private GuiEventsDetailView_Sebastian mGui;
    private EventData_Lena mData;
    private View mView;
    private DatepickerEventsDetailView_Sebastian datepicker;
    private TimepickerEventsDetailView_Sebastian timepicker;
    private SpanpickerEventsDetailView_Sebastian spanpicker;




    public ApplicationLogicEventsDetailView_Sebastian(EventData_Lena data, GuiEventsDetailView_Sebastian gui) {
        mGui = gui;
        mData = data;
        initGui();
        initListener();
        initCurrentDate();
        initCurrentTime();
        initDatepicker();
        initTimepicker();
        initSpanpicker();
    }


    private void initGui() {
        dataToGui();
    }

    public void initListener()
    {
        FloatingActionButtonClickListener_Lena floatingActionButtonClickListener = new FloatingActionButtonClickListener_Lena(this);
        mGui.getFabSave().setOnClickListener(floatingActionButtonClickListener);
    }



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



    public void onFabSaveClicked()
    {
        /*mTitle = mGui.getEditTextTitle().getText().toString();
        mDate = mGui.getButtonDate().getText().toString();
        mTime = mGui.getButtonTime().getText().toString();
        mDescription = mGui.getEditTextDescription().getText().toString();
        mLocation = mGui.getEditTextLocation().getText().toString();
        mSpan = mGui.getButtonSpan().getText().toString();*/

        mData.setEventTitle(mGui.getEditTextTitle().getText().toString());
        mData.setEventDate(mGui.getButtonDate().getText().toString());
        mData.setEventTime(mGui.getButtonTime().getText().toString());
        mData.setEventDescription(mGui.getEditTextDescription().getText().toString());
        mData.setEventLocation(mGui.getEditTextLocation().getText().toString());
        mData.setEventSpan(mGui.getButtonSpan().getText().toString());

        Log.d("LOGTAG", "Titel:"+mData.getEventTitle()+"  Date:"+mData.getEventDate());
        mData.createAndSaveNewEvent();

        finishActivityResultOk();
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

    private void finishActivityResultOk()
    {
        Intent intent = new Intent();
        intent.putExtra(Constants.KEYDATABUNDLE, mData.getDataBundle());
        mData.getActivity().setResult(Activity.RESULT_OK, intent);
        Log.d("LOGTAG", "finishActivityResultOk");
        mData.getActivity().finish();
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
