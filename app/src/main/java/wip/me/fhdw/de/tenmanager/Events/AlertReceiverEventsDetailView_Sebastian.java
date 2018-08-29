package wip.me.fhdw.de.tenmanager.Events;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import wip.me.fhdw.de.tenmanager.Constants;

import static android.content.ContentValues.TAG;

public class AlertReceiverEventsDetailView_Sebastian extends BroadcastReceiver {

    private int mHour;
    private int mMinute;
    private String mMessage;

    @Override
    public void onReceive(Context context, Intent intent) {
        String title = intent.getStringExtra(Constants.KEYNOTIFICATIONTITLE);
        String message = intent.getStringExtra(Constants.KEYNOTIFICATIONMESSAGE);

        mHour = Integer.parseInt(message.substring(0, 2));
        mMinute = Integer.parseInt(message.substring(3, 5));
        int minDiff = minutesToEvent();
        setNotificicationMessage(minDiff);
        int eventID = Integer.parseInt(intent.getStringExtra(Constants.KEYNOTIFICATIONID));
        Log.d(TAG, "onReceive: title und message, eventID " + title + " " + message + " " + eventID + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        NotificationHelperEventsDetailView_Sebastian notificationHelper = new NotificationHelperEventsDetailView_Sebastian(context);
        NotificationCompat.Builder nb = notificationHelper.getChannel1Notification(title, mMessage);
        //NotificationCompat.Builder nb = notificationHelper.getChannel1Notification(title, message);
        notificationHelper.getManager().notify(eventID, nb.build());
        //notificationHelper.getManager().notify(1, nb.build());
        }


    public int minutesToEvent(){
        int minDiff;



        final Calendar calendar = Calendar.getInstance();
        final Calendar calendarNow = Calendar.getInstance();


        calendar.set(Calendar.HOUR_OF_DAY, mHour);
        calendar.set(Calendar.MINUTE, mMinute);
        calendar.set(Calendar.SECOND, 0);

        minDiff = (int) ((calendar.getTime().getTime() - calendarNow.getTime().getTime())/(1000*60));
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm dd.MM.yyyy");
        Log.d(TAG, "Date von Button: " + mMinute+":"+mHour);
        Log.d("LOGTAG", "EventstartDate:" +sdf.format(calendar.getTime()));
        Log.d("LOGTAG", "Zeit jetzt:" +sdf.format(calendarNow.getTime()));

        Log.d(TAG, "minutesToEvent: Die Differenz ist " + minDiff + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");


        return minDiff;
    }

    public void setNotificicationMessage(int timeDiff){

        if (timeDiff > 1 && timeDiff < 60) {
            mMessage = "Dein Termin beginnt in " + timeDiff + " Minuten";
        } if (timeDiff > 60) {
            timeDiff = timeDiff - 60;
            mMessage = "Dein Termin beginnt in 1 Stunde " + timeDiff + " Minuten";
        } if(timeDiff < 1) {
            timeDiff = -timeDiff;
            mMessage = "Dein Termin hat vor " + timeDiff + " Minuten begonnen";
        } if(timeDiff == 0) {
            mMessage = "Dein Termin beginnt jetzt";
        }

    }
}
