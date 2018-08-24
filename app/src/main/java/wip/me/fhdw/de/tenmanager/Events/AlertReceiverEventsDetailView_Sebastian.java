package wip.me.fhdw.de.tenmanager.Events;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import wip.me.fhdw.de.tenmanager.Constants;

import static android.content.ContentValues.TAG;

public class AlertReceiverEventsDetailView_Sebastian extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String title = intent.getStringExtra(Constants.KEYNOTIFICATIONTITLE);
        String message = intent.getStringExtra(Constants.KEYNOTIFICATIONMESSAGE);
        int eventID = Integer.parseInt(intent.getStringExtra(Constants.KEYNOTIFICATIONID));
        Log.d(TAG, "onReceive: title und message, eventID " + title + " " + message + " " + eventID + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        NotificationHelperEventsDetailView_Sebastian notificationHelper = new NotificationHelperEventsDetailView_Sebastian(context);
        NotificationCompat.Builder nb = notificationHelper.getChannel1Notification(title, message);
        //notificationHelper.getManager().notify(eventID, nb.build());
        notificationHelper.getManager().notify(1, nb.build());
        }
}
