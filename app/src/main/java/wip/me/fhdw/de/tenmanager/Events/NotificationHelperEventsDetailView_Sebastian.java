package wip.me.fhdw.de.tenmanager.Events;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.support.v4.app.NotificationCompat;

import wip.me.fhdw.de.tenmanager.R;

public class NotificationHelperEventsDetailView_Sebastian extends ContextWrapper {

    public static final String channel1ID = "channel1ID";


    private NotificationManager mManager;


    public NotificationHelperEventsDetailView_Sebastian(Context base) {
        super(base);
            createChannels();
    }

    //create notification channel for api 26 or higher
    public void createChannels(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel1 = new NotificationChannel(
                    channel1ID,
                    "Channel1",
                    NotificationManager.IMPORTANCE_HIGH
            );
            channel1.setDescription("Notification channel1");

            getManager().createNotificationChannel(channel1);
        }
    }

    //create notification manager
    public NotificationManager getManager(){
        if(mManager == null){
            mManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        }
        return mManager;
    }

    //settings of notifications
    public NotificationCompat.Builder getChannel1Notification(String title, String message){
        return new NotificationCompat.Builder(getApplicationContext(), channel1ID)
                .setContentTitle(title)
                .setContentText(message)
                .setSmallIcon(R.mipmap.ic_launcher_round)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setAutoCancel(true);
    }

}
