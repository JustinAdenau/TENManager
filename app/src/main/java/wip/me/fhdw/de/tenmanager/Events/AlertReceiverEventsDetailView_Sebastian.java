package wip.me.fhdw.de.tenmanager.Events;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

public class AlertReceiverEventsDetailView_Sebastian extends BroadcastReceiver {

    private String mTitle;
    private String mMessage;



    @Override
    public void onReceive(Context context, Intent intent) {
        String title = "Erinnerung an deinen Termin";
        String message = "Dein Termin steht steht an";
        NotificationHelperEventsDetailView_Sebastian notificationHelper = new NotificationHelperEventsDetailView_Sebastian(context);
        NotificationCompat.Builder nb = notificationHelper.getChannel1Notification(title, message);
        notificationHelper.getManager().notify(1, nb.build());

    }

    public void buildAlertMessage(String title, String message){
        mTitle = title;
        mMessage = message;
    }
}
