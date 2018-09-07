package wip.me.fhdw.de.tenmanager.Events;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.Calendar;

import wip.me.fhdw.de.tenmanager.Constants;
import wip.me.fhdw.de.tenmanager.R;


public class ReminderSpinnerEventsDetailView_Sebastian {

    private GuiEventsDetailView_Sebastian mGui;
    private Activity mActivity;
    private boolean mNotification1Active = false;
    private boolean mNotification2Active = false;
    private boolean mNotification3Active = false;

    private int mNotificationNumber = 0;

    private String mTitle;

    private String mSpinner123Position;
    private String mSpinner1Position;
    private String mSpinner2Position;
    private String mSpinner3Position;

    private Spinner mSpinner1;
    private Spinner mSpinner2;
    private Spinner mSpinner3;

    private int mEventID;

    private int mMinDiff1;
    private int mMinDiff2;
    private int mMinDiff3;



    public ReminderSpinnerEventsDetailView_Sebastian(GuiEventsDetailView_Sebastian gui, Activity activity){
       mGui = gui;
       mActivity = activity;
    }

   //initialization and selecation function of spinner 1
   public void buildReminderSpinner1(){
        String[] ReminderList = new String[]{"Keine Erinnerung",
                "Erinnere mich zur Startzeit",
                "Erinnere mich 5 Minuten vorher",
                "Erinnere mich 15 Minuten vorher",
                "Erinnere mich 30 Minuten vorher",
                "Erinnere mich 1 Stunde vorher",
                "Erinnere mich 2 Stunden vorher"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(mActivity.getApplicationContext(), R.layout.spinner_item, ReminderList);

        mSpinner1 = mGui.getSpinnerReminder1();
        mSpinner1.setAdapter(adapter);

        if (mSpinner1 != null && mSpinner1Position != null) {
            mSpinner1.setSelection(Integer.parseInt(mSpinner1Position));
        } else {
            mSpinner1.setSelection(0);
        }

       mSpinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                mSpinner1Position = Integer.toString(pos);
                Object item = parent.getItemAtPosition(pos);
                if(item.toString()=="Erinnere mich zur Startzeit") {
                    mMinDiff1 = 0;
                    mNotification1Active = true;
                    mSpinner2.setVisibility(View.VISIBLE);

                } if(item.toString()=="Erinnere mich 5 Minuten vorher"){
                    mMinDiff1 = 5;
                    mNotification1Active = true;
                    mSpinner2.setVisibility(View.VISIBLE);

                } if(item.toString()=="Erinnere mich 15 Minuten vorher") {
                    mMinDiff1 = 15;
                    mNotification1Active = true;
                    mSpinner2.setVisibility(View.VISIBLE);

                } if(item.toString()=="Erinnere mich 30 Minuten vorher") {
                    mNotification1Active = true;
                    mSpinner2.setVisibility(View.VISIBLE);

                } if(item.toString()=="Erinnere mich 1 Stunde vorher") {
                    mMinDiff1 = 60;
                    mNotification1Active = true;
                    mSpinner2.setVisibility(View.VISIBLE);

                } if(item.toString()=="Erinnere mich 2 Stunden vorher") {
                    mMinDiff1 = 120;
                    mNotification1Active = true;
                    mSpinner2.setVisibility(View.VISIBLE);

                } if(item.toString()=="Keine Erinnerung") {
                    mNotification1Active = false;
                    mSpinner2.setVisibility(View.GONE);
                    mSpinner3.setVisibility(View.GONE);
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }

    //initialization and selecation function of spinner 2
    public void buildReminderSpinner2(){
        String[] ReminderList = new String[]{
                "Keine 2. Erinnerung",
                "Erinnere mich zur Startzeit",
                "Erinnere mich 5 Minuten vorher",
                "Erinnere mich 15 Minuten vorher",
                "Erinnere mich 30 Minuten vorher",
                "Erinnere mich 1 Stunde vorher",
                "Erinnere mich 2 Stunden vorher"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(mActivity.getApplicationContext(), R.layout.spinner_item, ReminderList);

        mSpinner2 = mGui.getSpinnerReminder2();
        mSpinner2.setAdapter(adapter);

        if (mSpinner2 != null && mSpinner2Position != null) {
            mSpinner2.setSelection(Integer.parseInt(mSpinner2Position));
        } else {
            mSpinner2.setSelection(0);
        }

        mTitle = mGui.getEditTextTitle().getText().toString();

        mSpinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                mSpinner2Position = Integer.toString(pos);
                Object item = parent.getItemAtPosition(pos);
                if(item.toString()=="Erinnere mich zur Startzeit") {
                    mMinDiff2 = 0;
                    mNotification2Active = true;
                    mSpinner3.setVisibility(View.VISIBLE);

                } if(item.toString()=="Erinnere mich 5 Minuten vorher"){
                    mMinDiff2 = 5;
                    mNotification2Active = true;
                    mSpinner3.setVisibility(View.VISIBLE);

                } if(item.toString()=="Erinnere mich 15 Minuten vorher") {
                    mMinDiff2 = 15;
                    mNotification2Active = true;
                    mSpinner3.setVisibility(View.VISIBLE);

                } if(item.toString()=="Erinnere mich 30 Minuten vorher") {
                    mMinDiff2 = 30;
                    mNotification2Active = true;
                    mSpinner3.setVisibility(View.VISIBLE);

                } if(item.toString()=="Erinnere mich 1 Stunde vorher") {
                    mMinDiff2 = 60;
                    mNotification2Active = true;
                    mSpinner3.setVisibility(View.VISIBLE);

                } if(item.toString()=="Erinnere mich 2 Stunden vorher") {
                    mMinDiff2 = 120;
                    mNotification2Active = true;
                    mSpinner3.setVisibility(View.VISIBLE);

                } if(item.toString()=="Keine 2. Erinnerung") {
                    mNotification2Active = false;
                    mSpinner3.setVisibility(View.GONE);
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }

    //initialization and selecation function of spinner 3
    public void buildReminderSpinner3(){
        String[] ReminderList = new String[]{
                "Keine 3. Erinnerung",
                "Erinnere mich zur Startzeit",
                "Erinnere mich 5 Minuten vorher",
                "Erinnere mich 15 Minuten vorher",
                "Erinnere mich 30 Minuten vorher",
                "Erinnere mich 1 Stunde vorher",
                "Erinnere mich 2 Stunden vorher"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(mActivity.getApplicationContext(), R.layout.spinner_item, ReminderList);

        mSpinner3 = mGui.getSpinnerReminder3();
        mSpinner3.setAdapter(adapter);

        if (mSpinner3 != null && mSpinner3Position != null) {
            mSpinner3.setSelection(Integer.parseInt(mSpinner3Position));
        } else {
            mSpinner3.setSelection(0);
        }

        mTitle = mGui.getEditTextTitle().getText().toString();

        mSpinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                mSpinner3Position = Integer.toString(pos);
                Object item = parent.getItemAtPosition(pos);
                if(item.toString()=="Erinnere mich zur Startzeit") {
                    mMinDiff3 = 0;
                    mNotification3Active = true;

                } if(item.toString()=="Erinnere mich 5 Minuten vorher"){
                    mMinDiff3 = 5;
                    mNotification3Active = true;

                } if(item.toString()=="Erinnere mich 15 Minuten vorher") {
                    mMinDiff3 = 15;
                    mNotification3Active = true;

                } if(item.toString()=="Erinnere mich 30 Minuten vorher") {
                    mMinDiff3 = 30;
                    mNotification3Active = true;

                } if(item.toString()=="Erinnere mich 1 Stunde vorher") {
                    mMinDiff3 = 60;
                    mNotification3Active = true;

                } if(item.toString()=="Erinnere mich 2 Stunden vorher") {
                    mMinDiff3 = 120;
                    mNotification3Active = true;

                } if(item.toString()=="Keine 3. Erinnerung") {
                    mNotification3Active = false;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }

    //set up to 3 notifications
    public void startAlarm(Calendar calendar1, Calendar calendar2, Calendar calendar3){

        mTitle = mGui.getEditTextTitle().getText().toString();

        AlarmManager alarmManager = (AlarmManager) mActivity.getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(mActivity.getApplicationContext(), AlertReceiverEventsDetailView_Sebastian.class);

        intent.putExtra(Constants.KEYNOTIFICATIONTITLE, mTitle);
        intent.putExtra(Constants.KEYNOTIFICATIONEVENTSTARTTIME, mGui.getButtonTimeStart().getText().toString());
        intent.putExtra(Constants.KEYNOTIFICATIONID, Integer.toString(mEventID));

        if (mNotification1Active == true && mNotification2Active == true && mNotification3Active == true){
            mNotificationNumber = 3;
            intent.putExtra(Constants.KEYNOTIFICATIONNUMBER, Integer.toString(mNotificationNumber));

        } if (mNotification1Active == true && mNotification2Active == true && mNotification3Active == false){
            mNotificationNumber = 2;
            intent.putExtra(Constants.KEYNOTIFICATIONNUMBER, Integer.toString(mNotificationNumber));

        } if (mNotification1Active == true && mNotification2Active == false && mNotification3Active == false){
            mNotificationNumber = 1;
            intent.putExtra(Constants.KEYNOTIFICATIONNUMBER, Integer.toString(mNotificationNumber));

        }

        for (int i = 1; i <= mNotificationNumber; i++){

            int notificationid;
            intent.putExtra(Constants.KEYNOTIFICATIONNUMBER, Integer.toString(i));
            notificationid = mEventID + i * 10000;
            PendingIntent pendingIntent = PendingIntent.getBroadcast(mActivity.getApplicationContext(), notificationid, intent, PendingIntent.FLAG_UPDATE_CURRENT);

            if(i==1){
                alarmManager.set(AlarmManager.RTC_WAKEUP, calendar1.getTimeInMillis(), pendingIntent);

            } if(i==2){
                alarmManager.set(AlarmManager.RTC_WAKEUP, calendar2.getTimeInMillis(), pendingIntent);

            } if(i==3){
                alarmManager.set(AlarmManager.RTC_WAKEUP, calendar3.getTimeInMillis(), pendingIntent);

            }
        }
    }

    //cancel previous set, but now deleted notifications
    public void cancelAlarm(){
        AlarmManager alarmManager = (AlarmManager) mActivity.getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(mActivity.getApplicationContext(), AlertReceiverEventsDetailView_Sebastian.class);

        for (int i = 3; i > mNotificationNumber; i--){
            int notificationid;
            intent.putExtra(Constants.KEYNOTIFICATIONNUMBER, Integer.toString(i));
            notificationid = mEventID + i * 10000;

            PendingIntent pendingIntent = PendingIntent.getBroadcast(mActivity.getApplicationContext(), notificationid, intent, PendingIntent.FLAG_CANCEL_CURRENT);
            alarmManager.cancel(pendingIntent);

        }
    }

    //set time(calendar) to push notification based on user input
    public Calendar createCalendar(int  minDiff){

        int hour = Integer.parseInt(mGui.getButtonTimeStart().getText().toString().substring(0, 2));
        int minute = Integer.parseInt(mGui.getButtonTimeStart().getText().toString().substring(3, 5));
        int day = Integer.parseInt(mGui.getButtonDateStart().getText().toString().substring(0, 2));
        int month = Integer.parseInt(mGui.getButtonDateStart().getText().toString().substring(3, 5)) - 1;
        int year = Integer.parseInt(mGui.getButtonDateStart().getText().toString().substring(6, 10));

        final Calendar calendar = Calendar.getInstance();

        calendar.set(year, month, day);
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, minute);
        calendar.set(Calendar.SECOND, 0);
        calendar.add(Calendar.MINUTE, -minDiff);

        return calendar;
    }

    //restore selected position of spinner 1, 2 & 3 from database
    public void restoreSpinnerPosition(String spinner123Position){
        if(spinner123Position != null && !spinner123Position.isEmpty()){

            mSpinner1Position = spinner123Position.substring(0,1);

            if(spinner123Position.length() < 2) {
                mSpinner2Position = "0";
                mSpinner3Position = "0";
            } if(spinner123Position.length() < 3){
            mSpinner3Position = "0";
            mSpinner2Position = spinner123Position.substring(1,2);
            } else{
            mSpinner2Position = spinner123Position.substring(1,2);
            mSpinner3Position = spinner123Position.substring(2,3);
            }
        }
    }

    //save selected position of spinner 1, 2 & 3 to database
    public String saveSpinner123Position(){
        mSpinner123Position = mSpinner1Position + mSpinner2Position + mSpinner3Position;

        return mSpinner123Position;
    }


    //getter
    public String getSpinner123Position() {
        return mSpinner123Position;
    }

    public int getMinDiff1() {
        return mMinDiff1;
    }

    public int getMinDiff2() {
        return mMinDiff2;
    }

    public int getMinDiff3() {
        return mMinDiff3;
    }

    //setter
    public void setEventID(int EventID) {
        this.mEventID = EventID;
    }

}
