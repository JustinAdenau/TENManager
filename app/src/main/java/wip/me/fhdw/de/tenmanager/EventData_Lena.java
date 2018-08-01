package wip.me.fhdw.de.tenmanager;

import android.app.Activity;
import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.Bundle;

public class EventData_Lena {

    private Activity mActivity;
    AppDatabase mDb;

    private String mEventTitle;
    private String mEventDate;
    private String mEventTime;
    private String mEventDescription;
    private String mEventLocation;
    private String mEventSpan;


    public EventData_Lena(Bundle savedInstanceState, Activity activity) {
        mActivity = activity;

        mDb = Room.databaseBuilder(activity.getApplicationContext(), AppDatabase.class, "events")
                .allowMainThreadQueries()
                .build();


        if ( savedInstanceState != null ) {        // is there a saved state?
            // restore data from saved state
            restoreDataFromBundle(savedInstanceState);
        }
        else {
            Bundle intentParameters = mActivity.getIntent().getBundleExtra(Constants.KEYDATABUNDLE);
            if ( intentParameters != null ) {     // are there Intent parameters?
                restoreDataFromBundle(intentParameters);
            }
        }
    }

    public void restoreDataFromBundle(Bundle b) {

        mEventTitle = b.getString(Constants.KEYEVENTTITLE);
        mEventDate = b.getString(Constants.KEYEVENTDATE);
        mEventTime = b.getString(Constants.KEYEVENTTIME);
        mEventDescription = b.getString(Constants.KEYEVENTDESCRIPTION);
        mEventLocation = b.getString(Constants.KEYEVENTLOCATION);
        mEventSpan = b.getString(Constants.KEYEVENTSPAN);
    }

    public void readIntentParametersOrSetDefaultValues(Intent intent) {
        Bundle intentParameters = intent.getBundleExtra(Constants.KEYDATABUNDLE);
        if ( intentParameters != null ) {     // are there Intent parameters?
            restoreDataFromBundle(intentParameters);
        }
    }

    public Bundle getDataBundle()
    {
        Bundle bundle = new Bundle();
        saveDataInBundle(bundle);
        return bundle;
    }

    public void saveDataInBundle(Bundle b) {
        b.putString(Constants.KEYEVENTTITLE, mEventTitle);
        b.putString(Constants.KEYEVENTDATE, mEventDate);
        b.putString(Constants.KEYEVENTTIME, mEventTime);
        b.putString(Constants.KEYEVENTDESCRIPTION, mEventDescription);
        b.putString(Constants.KEYEVENTLOCATION, mEventLocation);
        b.putString(Constants.KEYEVENTSPAN, mEventSpan);
    }

    public void createAndSaveNewEvent()
    {
        Event event = new Event(mEventTitle, mEventDate, mEventTime, mEventDescription, mEventLocation, mEventSpan);
        mDb.eventDao().insertAll(event);
    }


    //setter
    public void setEventTitle(String title){mEventTitle = title;}
    public void setEventDate(String date){mEventDate = date;}
    public void setEventTime(String time){mEventTime = time;}
    public void setEventDescription(String description){mEventDescription = description;}
    public void setEventLocation(String location){mEventLocation = location;}
    public void setEventSpan(String span){mEventSpan = span;}

    //getter
    public Activity getActivity () {
        return mActivity;
    }
    public String getEventTitle(){return mEventTitle;}
    public String getEventDate(){return mEventDate;}
    public String getEventTime(){return mEventTime;}
    public String getEventDescription(){return mEventDescription;}
    public String getEventLocation(){return mEventLocation;}
    public String getEventSpan(){return mEventSpan;}

}