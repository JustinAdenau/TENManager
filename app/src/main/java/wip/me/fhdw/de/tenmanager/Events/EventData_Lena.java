package wip.me.fhdw.de.tenmanager;

import android.app.Activity;
import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class EventData_Lena {

    private Activity mActivity;
    AppDatabase mDb;

    private String mEventTitle;
    private String mEventDateStart;
    private String mEventTimeStart;
    private String mEventDateEnd;
    private String mEventTimeEnd;
    private String mEventDescription;
    private String mEventLocation;



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
        mEventDateStart = b.getString(Constants.KEYEVENTDATESTART);
        mEventTimeStart = b.getString(Constants.KEYEVENTTIMESTART);
        mEventDateEnd = b.getString(Constants.KEYEVENTDATEEND);
        mEventTimeEnd = b.getString(Constants.KEYEVENTTIMEEND);
        mEventDescription = b.getString(Constants.KEYEVENTDESCRIPTION);
        mEventLocation = b.getString(Constants.KEYEVENTLOCATION);
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
        b.putString(Constants.KEYEVENTDATESTART, mEventDateStart);
        b.putString(Constants.KEYEVENTTIMESTART, mEventTimeStart);
        b.putString(Constants.KEYEVENTDATEEND, mEventDateEnd);
        b.putString(Constants.KEYEVENTTIMEEND, mEventTimeEnd);
        b.putString(Constants.KEYEVENTDESCRIPTION, mEventDescription);
        b.putString(Constants.KEYEVENTLOCATION, mEventLocation);
    }

    public void createAndSaveNewEvent()
    {
        Event event = new Event(mEventTitle, mEventDateStart, mEventTimeStart, mEventDateEnd, mEventTimeEnd, mEventDescription, mEventLocation);
        mDb.eventDao().insertAll(event);
    }

    public void updateEvent(String titleOld, String dateStartOld, String timeStartOld)
    {
        Log.d("LOGTAG", "updateEvent called with: "+titleOld +dateStartOld+timeStartOld+mEventTitle+mEventDateStart);
        /*mDb.eventDao().updateEvent(titleOld, dateStartOld, timeStartOld, mEventTitle, mEventDateStart, mEventTimeStart, mEventDateEnd,
                mEventTimeEnd, mEventDescription, mEventLocation);*/
        Event eventOld = mDb.eventDao().getEventByTitleDateTime(titleOld, dateStartOld, timeStartOld);
        if(eventOld != null)
        {
            Log.d("LOGTAG", "eventOld ist nicht null!!!!!!!!!!!!!!");
            mDb.eventDao().deleteEvents(eventOld);
            createAndSaveNewEvent();
        }
    }


    //setter
    public void setEventTitle(String title){mEventTitle = title;}
    public void setEventDateStart(String date){mEventDateStart = date;}
    public void setEventTimeStart(String time){mEventTimeStart = time;}
    public void setEventDateEnd(String date){mEventDateEnd = date;}
    public void setEventTimeEnd(String time){mEventTimeEnd = time;}
    public void setEventDescription(String description){mEventDescription = description;}
    public void setEventLocation(String location){mEventLocation = location;}


    //getter
    public Activity getActivity () {
        return mActivity;
    }
    public AppDatabase getDb() {return mDb;}

    public String getEventTitle(){return mEventTitle;}
    public String getEventDateStart(){return mEventDateStart;}
    public String getEventTimeStart(){return mEventTimeStart;}
    public String getEventDateEnd(){return mEventDateEnd;}
    public String getEventTimeEnd(){return mEventTimeEnd;}
    public String getEventDescription(){return mEventDescription;}
    public String getEventLocation(){return mEventLocation;}


}