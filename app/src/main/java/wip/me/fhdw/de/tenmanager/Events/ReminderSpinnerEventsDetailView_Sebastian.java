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

import static android.content.ContentValues.TAG;
//import static wip.me.fhdw.de.tenmanager.Events.ApplicationLogicEventsDetailView_Sebastian.CHANNEL_1_ID;

public class ReminderSpinnerEventsDetailView_Sebastian {

    private GuiEventsDetailView_Sebastian mGui;
    private Activity mActivity;
    private Calendar mCalendar;
    private boolean mNotificationActive = false;





    ////coding flow!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    private NotificationManagerCompat mNotificationManager;
    private NotificationHelperEventsDetailView_Sebastian mNotificationHelper;
    private AlertReceiverEventsDetailView_Sebastian mAlertReceiver;



    public ReminderSpinnerEventsDetailView_Sebastian(GuiEventsDetailView_Sebastian gui, Activity activity){
       mGui = gui;
       mActivity = activity;

       ////codingflow1!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
       mNotificationManager = NotificationManagerCompat.from(mActivity.getApplicationContext());
       mNotificationHelper = new NotificationHelperEventsDetailView_Sebastian(mActivity.getApplication());
       mAlertReceiver = new AlertReceiverEventsDetailView_Sebastian();
    }


   public void buildReminderSpinner(){
        String[] ReminderList = new String[]{"Keine Erinnerung","Erinnere mich zur Startzeit","Erinnere mich 5 Minuten vorher","Erinnere mich 15 Minuten vorher", "Erinnere mich 30 Minuten vorher","Erinnere mich 1 Stunde vorher","Erinnere mich 2 Stunden vorher"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(mActivity.getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, ReminderList);

        Spinner spinner = mGui.getSpinnerReminder();
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                Object item = parent.getItemAtPosition(pos);
                Log.d(TAG, "onItemSelected: Position" + pos);
                if(item.toString()=="Erinnere mich zur Startzeit") {
                    Log.d(TAG, "onItemSelected: Startzeit");

                    mCalendar = createCalendar(0);
                    mNotificationActive = true;

                   // String title = mGui.getEditTextTitle().getText().toString();
                   // String message = "Dein Termin startet jetzt";

                   // NotificationCompat.Builder nb = mNotificationHelper.getChannel1Notification(title, message);
                   // mNotificationHelper.getManager().notify(1, nb.build());

                } if(item.toString()=="Erinnere mich 5 Minuten vorher"){
                    Log.d(TAG, "onItemSelected: vor 5 min");

                    mCalendar = createCalendar(5);
                    mNotificationActive = true;

                    String title = mGui.getEditTextTitle().getText().toString();
                    String message = "Dein Termin startet in 5 Minuten";

                  //  mAlertReceiver.buildAlertMessage(title, message);

                } if(item.toString()=="Erinnere mich 15 Minuten vorher") {
                    Log.d(TAG, "onItemSelected: vor 15 min");

                    mCalendar = createCalendar(15);
                    mNotificationActive = true;

                    String title = mGui.getEditTextTitle().getText().toString();
                    String message = "Dein Termin startet in 15 Minuten";

                    // mAlertReceiver.buildAlertMessage(title, message);

                } if(item.toString()=="Erinnere mich 30 Minuten vorher") {
                    Log.d(TAG, "onItemSelected: vor 30 min");

                    mCalendar = createCalendar(30);
                    mNotificationActive = true;

                    String title = mGui.getEditTextTitle().getText().toString();
                    String message = "Dein Termin startet in 30 Minuten";

                   // mAlertReceiver.buildAlertMessage(title, message);

                } if(item.toString()=="Erinnere mich 1 Stunde vorher") {
                    Log.d(TAG, "onItemSelected: vor 1 h");

                    mCalendar = createCalendar(60);
                    mNotificationActive = true;

                    String title = mGui.getEditTextTitle().getText().toString();
                    String message = "Dein Termin startet in 1 Stunde";

                    // mAlertReceiver.buildAlertMessage(title, message);

                } if(item.toString()=="Erinnere mich 2 Stunden vorher") {
                    Log.d(TAG, "onItemSelected: vor 2 h");

                    mCalendar = createCalendar(120);
                    mNotificationActive = true;

                    String title = mGui.getEditTextTitle().getText().toString();
                    String message = "Dein Termin startet in 2 Stunden";

                    // mAlertReceiver.buildAlertMessage(title, message);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }


    /*public void creatNotification(View v){
        String title = mGui.getEditTextTitle().getText().toString();
        String message = "Startzeit " + mGui.getButtonTimeStart().getText().toString() + " am " + mGui.getButtonDateStart().getText().toString();
        Notification notification = new NotificationCompat.Builder(mActivity, CHANNEL_1_ID)
                .setSmallIcon(R.drawable.ic_event_note_black_24dp)
                .setContentTitle(title)
                .setContentText(message)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
               // .setCategory(NotificationCompat.CATEGORY_EVENT)
                .build();
        Log.d(TAG, "creatNotification: Notification" + title + " " + message);

        mNotificationManager.notify(1,notification);
        //Quelle https://www.youtube.com/watch?v=tTbd1Mfi-Sk&t=0s&list=PLrnPJCHvNZuCN52QwGu7YTSLIMrjCF0gM&index=2
    }*/

//////////////////////////////////    ///////
    public void startAlarm(Calendar calendar){
        AlarmManager alarmManager = (AlarmManager) mActivity.getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(mActivity.getApplicationContext(), AlertReceiverEventsDetailView_Sebastian.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(mActivity.getApplicationContext(), 1, intent, 0);

        alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);
    }

    public void cancelAlarm(Calendar calendar){
        AlarmManager alarmManager = (AlarmManager) mActivity.getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(mActivity.getApplicationContext(), AlertReceiverEventsDetailView_Sebastian.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(mActivity.getApplicationContext(), 1, intent, 0);

        alarmManager.cancel(pendingIntent);
    }

    public Calendar createCalendar(int  mindiff){

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
        calendar.add(Calendar.MINUTE, -mindiff);

        return calendar;
    }

    public Calendar getCalendar() {
        return mCalendar;
    }

    public boolean isNotificationActive() {
        return mNotificationActive;
    }

    //todo Abfangen von Stundenübertritten und Datumsübertritten
    //Quelle http://blog.blundellapps.co.uk/notification-for-a-user-chosen-time/
}
