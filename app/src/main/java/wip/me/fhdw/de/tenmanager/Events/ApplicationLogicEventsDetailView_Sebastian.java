package wip.me.fhdw.de.tenmanager.Events;


import android.app.Activity;
import android.content.Intent;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.Calendar;

import wip.me.fhdw.de.tenmanager.Constants;
import wip.me.fhdw.de.tenmanager.NavigationItemSelectListener;
import wip.me.fhdw.de.tenmanager.R;


public class ApplicationLogicEventsDetailView_Sebastian {

    private static final String TAG = "AppLogic_Sebastian";

    private GuiEventsDetailView_Sebastian mGui;
    private EventData_Lena mData;
    private View mView;
    private DatepickerStartEventsDetailView_Sebastian mDatepickerStart;
    private DatepickerEndEventsDetailView_Sebastian mDatepickerEnd;
    private TimepickerStartEventsDetailView_Sebastian mTimepickerStart;
    private TimepickerEndEventsDetailView_Sebastian mTimepickerEnd;
    private UserInputValidationEventsDetailView_Sebastian mUserInputValidation;
    private ReminderSpinnerEventsDetailView_Sebastian mReminderSpinner;

    private Activity mActivity;


    public ApplicationLogicEventsDetailView_Sebastian(Activity activity, EventData_Lena data, GuiEventsDetailView_Sebastian gui) {
        mActivity = activity;
        mGui = gui;
        mData = data;
        initGui();
       // initNotification();
        initListener();
        initCurrentDate();
        initCurrentTime();
        initDatepickerStart();
        initDatepickerEnd();
        initTimepickerStart();
        initTimepickerEnd();
        initUserInputValidation();
        initReminderSpinner();
    }


    private void initGui() {
        dataToGui();
    }

    /*public void initNotification(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel1 = new NotificationChannel(
                    CHANNEL_1_ID,
                    "Channel1",
                    NotificationManager.IMPORTANCE_HIGH
            );
            channel1.setDescription("This is a Testchannel ändern in AppLogic");

            NotificationManager manager = mActivity.getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel1);
        }
    }*/

    public void initListener() {
        EventFloatingActionButtonClickListener_Lena floatingActionButtonClickListener = new EventFloatingActionButtonClickListener_Lena(this);
        mGui.getFabSave().setOnClickListener(floatingActionButtonClickListener);
        NavigationItemSelectListener navigationItemSelectListener = new NavigationItemSelectListener(this);
        mGui.getNavigationView().setNavigationItemSelectedListener(navigationItemSelectListener);
    }


//todo

    public void dataToGui() {
        mGui.getEditTextTitle().setText(mData.getEventTitle());
        mGui.getButtonDateStart().setText(mData.getEventDateStart());
        mGui.getButtonDateEnd().setText(mData.getEventDateEnd());
        mGui.getButtonTimeStart().setText(mData.getEventTimeStart());
        mGui.getButtonTimeEnd().setText(mData.getEventTimeEnd());
        mGui.getEditTextDescription().setText(mData.getEventDescription());
        mGui.getEditTextLocation().setText(mData.getEventLocation());
        //todo an Datenbank
       // mGui.getSpinnerReminder().setSelection(mData.getEvent());
    }


    /////////////////////////////////////////////
    // AppLogic
    ////////////////////////////////////////////7


    //todo Validierung Enddatum muss nach Startdatum liegen
    //todo in if auch  ButtonDateEnd Befüllung anfragen
    private void initCurrentDate() {
        if (mGui.getButtonDateStart().getText().toString().matches("\\d{2}.\\d{2}.\\d{4}")) return;
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        month = month + 1;

        mGui.getButtonDateStart().setText(String.format("%02d.%02d.%04d", day, month, year));
        mGui.getButtonDateEnd().setText(String.format("%02d.%02d.%04d", day, month, year));
    }

    //todo in if auch  ButtonTimeEnd Befüllung anfragen
    private void initCurrentTime() {
        if (mGui.getButtonTimeStart().getText().toString().matches("\\d{2}:\\d{2}")) return;
        Calendar cal = Calendar.getInstance();
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        int minute;

        hour = hour + 1;
        minute = 00;

        mGui.getButtonTimeStart().setText(String.format("%02d:%02d", hour, minute));
        mGui.getButtonTimeEnd().setText(String.format("%02d:%02d", hour + 1, minute));
    }


    private void initDatepickerStart() {
        mDatepickerStart = new DatepickerStartEventsDetailView_Sebastian(mGui);
        mDatepickerStart.buildDateStartpicker();
        mDatepickerStart.setDateStartToButton();
    }


    private void initDatepickerEnd() {
        mDatepickerEnd = new DatepickerEndEventsDetailView_Sebastian(mGui);
        mDatepickerEnd.buildDateEndpicker();
        mDatepickerEnd.setDateEndToButton();
    }


    private void initTimepickerStart() {
        mTimepickerStart = new TimepickerStartEventsDetailView_Sebastian(mGui);
        mTimepickerStart.bulidTimeStartpicker();
    }

    private void initTimepickerEnd() {
        mTimepickerEnd = new TimepickerEndEventsDetailView_Sebastian(mGui);
        mTimepickerEnd.buildTimeEndpicker();
    }

    //todo Methoden einfügen
    private void initUserInputValidation() {
        mUserInputValidation = new UserInputValidationEventsDetailView_Sebastian(mGui);
    }

    private void initReminderSpinner(){
        mReminderSpinner= new ReminderSpinnerEventsDetailView_Sebastian(mGui, mActivity);
        mReminderSpinner.buildReminderSpinner();
    }


    public void onFabSaveClicked() {
        if (mUserInputValidation.confirmInput()) return;
        if(mReminderSpinner.isNotificationActive()==true){
            mReminderSpinner.startAlarm(mReminderSpinner.getCalendar());
        } else {
            mReminderSpinner.cancelAlarm(mReminderSpinner.getCalendar());
        }
        boolean eventExists = false;
        String titleOld = mData.getEventTitle();
        String dateStartOld = mData.getEventDateStart();
        String timeStartOld = mData.getEventTimeStart();
        String title = mGui.getEditTextTitle().getText().toString();
        String dateStart = mGui.getButtonDateStart().getText().toString();
        String timeStart = mGui.getButtonTimeStart().getText().toString();
        if (mData.getDb().eventDao().eventExists(title, dateStart, timeStart) != 0)
            eventExists = true;
        if (!eventExists || mData.getWithData()) {
            mData.setEventTitle(mGui.getEditTextTitle().getText().toString());
            mData.setEventDateStart(mGui.getButtonDateStart().getText().toString());
            mData.setEventTimeStart(mGui.getButtonTimeStart().getText().toString());
            mData.setEventDateEnd(mGui.getButtonDateEnd().getText().toString());
            mData.setEventTimeEnd(mGui.getButtonTimeEnd().getText().toString());
            mData.setEventDescription(mGui.getEditTextDescription().getText().toString());
            mData.setEventLocation(mGui.getEditTextLocation().getText().toString());
            //todo Position von adapterview
            //mData.setEventDateEnd(mGui.getSpinnerReminder().getSelectedItemPosition());
        }

        Log.d("LOGTAG", "withData: " + mData.getWithData());

        if (mData.getWithData()) {
            Log.d("LOGTAG", "updating event!!!");
            mData.updateEvent(titleOld, dateStartOld, timeStartOld);
        } else {
            if (eventExists) {
                Log.d("LOGTAG", "event exists!!!");
                Toast.makeText(mData.getActivity().getApplicationContext(), "Es gibt bereits ein Event mit diesem Titel, diesem Startdatum und dieser Startzeit!", Toast.LENGTH_LONG).show();

                return;
            }
            mData.createAndSaveNewEvent();
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


    //finish Activities
    public void onActivityReturned(int requestCode, int resultCode, Intent intent) {
        Log.d("LOGTAG", "onActivityReturned ...");
        Log.d("LOGTAG", "  resultCode: " + resultCode);
        int value;
        if (resultCode == Activity.RESULT_OK) {
            switch (requestCode) {
                case Constants.REQUESTCODEONE:
                    mData.readIntentParametersOrSetDefaultValues(intent);
                    dataToGui();
                    break;
            }
        }
    }

    public void startActivity(Class<?> activityClass, boolean withData) //?: Elementtyp der Klasse ist offen
    {
        Intent intent = new Intent();
        intent.setClass(mData.getActivity(), activityClass);
        if(withData){ intent.putExtra(Constants.KEYDATABUNDLE, mData.getDataBundle());}
        intent.putExtra(Constants.KEYWITHDATA, withData);
        mData.getActivity().startActivityForResult(intent, Constants.REQUESTCODEONE);
    }


    private void finishActivityResultOk() {
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