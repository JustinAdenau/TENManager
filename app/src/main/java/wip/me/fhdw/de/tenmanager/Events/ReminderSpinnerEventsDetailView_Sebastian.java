package wip.me.fhdw.de.tenmanager.Events;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.Calendar;

import wip.me.fhdw.de.tenmanager.Constants;

import static android.content.ContentValues.TAG;

public class ReminderSpinnerEventsDetailView_Sebastian {

    private GuiEventsDetailView_Sebastian mGui;
    private Activity mActivity;
    private Calendar mCalendar;
    private boolean mNotificationActive = false;

    private String mTitle;
    private String mMessage;

    private String mSpinnerPosition;

    //todo löschen!!!!!
    private int mEventID = 1;


  //  private NotificationManagerCompat mNotificationManager;
  //  private NotificationHelperEventsDetailView_Sebastian mNotificationHelper;




    public ReminderSpinnerEventsDetailView_Sebastian(GuiEventsDetailView_Sebastian gui, Activity activity){
       mGui = gui;
       mActivity = activity;

    }


   public void buildReminderSpinner(){
        String[] ReminderList = new String[]{"Keine Erinnerung","Erinnere mich zur Startzeit","Erinnere mich 5 Minuten vorher","Erinnere mich 15 Minuten vorher", "Erinnere mich 30 Minuten vorher","Erinnere mich 1 Stunde vorher","Erinnere mich 2 Stunden vorher"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(mActivity.getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, ReminderList);

        Spinner spinner = mGui.getSpinnerReminder();
        spinner.setAdapter(adapter);

        if (mSpinnerPosition != null) {
            spinner.setSelection(Integer.parseInt(mSpinnerPosition));
        } else {
            spinner.setSelection(0);
        }

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                mSpinnerPosition = Integer.toString(pos);
                Object item = parent.getItemAtPosition(pos);
                Log.d(TAG, "onItemSelected: Position" + pos);
                if(item.toString()=="Erinnere mich zur Startzeit") {
                    Log.d(TAG, "onItemSelected: Startzeit");

                    mCalendar = createCalendar(0);
                    mNotificationActive = true;

                    int minDiff = minutesToEvent();

                    mTitle = mGui.getEditTextTitle().getText().toString();
                    setNotificicationMessage(minDiff);

                } if(item.toString()=="Erinnere mich 5 Minuten vorher"){
                    Log.d(TAG, "onItemSelected: vor 5 min");

                    mCalendar = createCalendar(5);
                    mNotificationActive = true;

                    int minDiff = minutesToEvent();

                    mTitle = mGui.getEditTextTitle().getText().toString();
                    setNotificicationMessage(minDiff);

                } if(item.toString()=="Erinnere mich 15 Minuten vorher") {
                    Log.d(TAG, "onItemSelected: vor 15 min");

                    mCalendar = createCalendar(15);
                    mNotificationActive = true;

                    int minDiff = minutesToEvent();

                    mTitle = mGui.getEditTextTitle().getText().toString();
                    setNotificicationMessage(minDiff);

                } if(item.toString()=="Erinnere mich 30 Minuten vorher") {
                    Log.d(TAG, "onItemSelected: vor 30 min");

                    mCalendar = createCalendar(30);
                    mNotificationActive = true;

                    int minDiff = minutesToEvent();

                    mTitle = mGui.getEditTextTitle().getText().toString();
                    setNotificicationMessage(minDiff);

                } if(item.toString()=="Erinnere mich 1 Stunde vorher") {
                    Log.d(TAG, "onItemSelected: vor 1 h");

                    mCalendar = createCalendar(60);
                    mNotificationActive = true;

                    int minDiff = minutesToEvent();

                    mTitle = mGui.getEditTextTitle().getText().toString();
                    setNotificicationMessage(minDiff);

                } if(item.toString()=="Erinnere mich 2 Stunden vorher") {
                    Log.d(TAG, "onItemSelected: vor 2 h");

                    mCalendar = createCalendar(120);
                    mNotificationActive = true;

                    int minDiff = minutesToEvent();

                    mTitle = mGui.getEditTextTitle().getText().toString();
                    setNotificicationMessage(minDiff);

                } if(item.toString()=="Keine Erinnerung") {
                    mNotificationActive = false;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }


    //todo pendingIntent requestcode mit laufender EventID
    public void startAlarm(Calendar calendar){
        AlarmManager alarmManager = (AlarmManager) mActivity.getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(mActivity.getApplicationContext(), AlertReceiverEventsDetailView_Sebastian.class);
        intent.putExtra(Constants.KEYNOTIFICATIONTITLE, mTitle);
        intent.putExtra(Constants.KEYNOTIFICATIONMESSAGE, mMessage);
        intent.putExtra(Constants.KEYNOTIFICATIONID, Integer.toString(mEventID));
        PendingIntent pendingIntent = PendingIntent.getBroadcast(mActivity.getApplicationContext(), mEventID, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        Log.d(TAG, "startAlarm: " + intent.getStringExtra(Constants.KEYNOTIFICATIONMESSAGE) + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        Log.d(TAG, "startAlarm: !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! Titel: " + mTitle  + " " + mMessage);


        alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);
    }

    public void cancelAlarm(Calendar calendar){
        AlarmManager alarmManager = (AlarmManager) mActivity.getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(mActivity.getApplicationContext(), AlertReceiverEventsDetailView_Sebastian.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(mActivity.getApplicationContext(), mEventID, intent, PendingIntent.FLAG_CANCEL_CURRENT);

        alarmManager.cancel(pendingIntent);
    }

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

    public void setNotificicationMessage(int timeDiff){

        if (timeDiff > 1) {
            mMessage = "Dein Termin startet in " + timeDiff + " Minuten";
        } if(timeDiff < 1) {
            timeDiff = -timeDiff;
            mMessage = "Dein Termin hat vor " + timeDiff + " Minuten begonnen";
        } if(timeDiff == 0) {
            mMessage = "Dein Termin startet jetzt";
        }

    }

    //todo abfangen wenn über ne stunde vergangen ist
    public int minutesToEvent(){
        int minDiff;

        int hour = Integer.parseInt(mGui.getButtonTimeStart().getText().toString().substring(0, 2));
        int minute = Integer.parseInt(mGui.getButtonTimeStart().getText().toString().substring(3, 5));
        int day = Integer.parseInt(mGui.getButtonDateStart().getText().toString().substring(0, 2));
        int month = Integer.parseInt(mGui.getButtonDateStart().getText().toString().substring(3, 5)) - 1;
        int year = Integer.parseInt(mGui.getButtonDateStart().getText().toString().substring(6, 10));

        final Calendar calendar = Calendar.getInstance();
        final Calendar calendarNow = Calendar.getInstance();


        calendar.set(year, month, day);
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, minute);
        calendar.set(Calendar.SECOND, 0);

        minDiff = (int) ((calendar.getTime().getTime() - calendarNow.getTime().getTime())/(1000*60) % 60);

        Log.d(TAG, "minutesToEvent: Die Differenz ist " + minDiff + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");


        return minDiff;
    }

    public Calendar getCalendar() {
        return mCalendar;
    }

    public boolean isNotificationActive() {
        return mNotificationActive;
    }

    public String getSpinnerPosition() {
        return mSpinnerPosition;
    }

    public void setSpinnerPosition(String SpinnerPosition) {
        this.mSpinnerPosition = SpinnerPosition;
    }

    public void setEventID(int EventID) {
        this.mEventID = EventID;
    }

    //Quelle http://blog.blundellapps.co.uk/notification-for-a-user-chosen-time/
}
