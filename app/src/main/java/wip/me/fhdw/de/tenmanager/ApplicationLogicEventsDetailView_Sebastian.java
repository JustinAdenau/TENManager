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
    private DatepickerStartEventsDetailView_Sebastian datepickerStart;
    private DatepickerEndEventsDetailView_Sebastian datepickerEnd;
    private TimepickerStartEventsDetailView_Sebastian timepickerStart;
    private TimepickerEndEventsDetailView_Sebastian timepickerEnd;



    public ApplicationLogicEventsDetailView_Sebastian(EventData_Lena data, GuiEventsDetailView_Sebastian gui) {
        mGui = gui;
        mData = data;
        initGui();
        initListener();
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

    public void initListener()
    {
        FloatingActionButtonClickListener_Lena floatingActionButtonClickListener = new FloatingActionButtonClickListener_Lena(this);
        mGui.getFabSave().setOnClickListener(floatingActionButtonClickListener);
    }


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
        if(mGui.getButtonDateStart().getText().toString().matches("\\d{2}.\\d{2}.\\d{4}")) return;
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        month = month+1;

        mGui.getButtonDateStart().setText(String.format("%02d.%02d.%04d", day, month, year));
        mGui.getButtonDateEnd().setText(String.format("%02d.%02d.%04d", day, month, year));
    }

    //todo in if auch  ButtonTimeEnd Befüllung anfragen
    private void initCurrentTime(){
        if(mGui.getButtonTimeStart().getText().toString().matches("\\d{2}:\\d{2}")) return;
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



    public void onFabSaveClicked()
    {
        mData.setEventTitle(mGui.getEditTextTitle().getText().toString());
        mData.setEventDateStart(mGui.getButtonDateStart().getText().toString());
        mData.setEventTimeStart(mGui.getButtonTimeStart().getText().toString());
        mData.setEventDateEnd(mGui.getButtonDateEnd().getText().toString());
        mData.setEventTimeEnd(mGui.getButtonTimeEnd().getText().toString());
        mData.setEventDescription(mGui.getEditTextDescription().getText().toString());
        mData.setEventLocation(mGui.getEditTextLocation().getText().toString());

        mData.createAndSaveNewEvent();

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

    //todo save data bei landscape
}
