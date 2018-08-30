package wip.me.fhdw.de.tenmanager.Events;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import java.util.Calendar;

import wip.me.fhdw.de.tenmanager.Constants;

import static android.content.ContentValues.TAG;

public class AlertReceiverEventsDetailView_Sebastian extends BroadcastReceiver {

    private String mStartTime;
    private int mHour1;
    private int mMinute1;
    private String mTitle;
    private String mMessage1;

    //push up to 3 notification
    @Override
    public void onReceive(Context context, Intent intent) {
        mTitle = intent.getStringExtra(Constants.KEYNOTIFICATIONTITLE);
        mStartTime = intent.getStringExtra(Constants.KEYNOTIFICATIONEVENTSTARTTIME);
        int eventID = Integer.parseInt(intent.getStringExtra(Constants.KEYNOTIFICATIONID));
        int notificationNumber = Integer.parseInt(intent.getStringExtra(Constants.KEYNOTIFICATIONNUMBER));


        mHour1 = Integer.parseInt(mStartTime.substring(0, 2));
        mMinute1 = Integer.parseInt(mStartTime.substring(3, 5));
        int minDiff = minutesToEvent();
        setNotificicationMessage(minDiff);

        NotificationHelperEventsDetailView_Sebastian notificationHelper = new NotificationHelperEventsDetailView_Sebastian(context);
        NotificationCompat.Builder nb = notificationHelper.getChannel1Notification(mTitle, mMessage1);
        if (notificationNumber == 1){
            eventID = eventID + 10000;
            notificationHelper.getManager().notify(eventID, nb.build());
            Log.d(TAG, "onReceive: noti1");
        } if (notificationNumber == 2){
            eventID = eventID + 20000;
            notificationHelper.getManager().notify(eventID, nb.build());
            Log.d(TAG, "onReceive: noti2");
        } if (notificationNumber == 3){
            eventID = eventID + 30000;
            notificationHelper.getManager().notify(eventID, nb.build());
            Log.d(TAG, "onReceive: noti3");
        }
    }

    //calculate minutes until start time of event
    public int minutesToEvent(){
        int minDiff;
        final Calendar calendar = Calendar.getInstance();
        final Calendar calendarNow = Calendar.getInstance();

        calendar.set(Calendar.HOUR_OF_DAY, mHour1);
        calendar.set(Calendar.MINUTE, mMinute1);
        calendar.set(Calendar.SECOND, 0);

        minDiff = (int) ((calendar.getTime().getTime() - calendarNow.getTime().getTime())/(1000*60));

        return minDiff;
    }

    //set message text to notification
    public void setNotificicationMessage(int timeDiff){

        if (timeDiff >= 1 && timeDiff < 2) {
            mMessage1 = "Dein Termin beginnt in " + timeDiff + " Minute";
        } if (timeDiff >= 2 && timeDiff <= 60) {
            mMessage1 = "Dein Termin beginnt in " + (timeDiff+1) + " Minuten";
        } if (timeDiff > 60) {
            timeDiff = timeDiff - 60;
            mMessage1 = "Dein Termin beginnt in 1 Stunde und " + timeDiff + " Minuten";
        } if(timeDiff < -1 && timeDiff > -2) {
            timeDiff = -timeDiff;
            mMessage1 = "Dein Termin hat vor " + timeDiff + " Minute begonnen";
        } if(timeDiff <= -2 && timeDiff >= -60) {
            timeDiff = -timeDiff;
            mMessage1 = "Dein Termin hat vor " + (timeDiff+1) + " Minuten begonnen";
        } if(timeDiff < -60) {
            mMessage1 = "Dein Termin hat um " + mStartTime + " Uhr begonnen";
        } if(timeDiff == 0) {
            mMessage1 = "Dein Termin beginnt jetzt";
        }

    }
}
