package wip.me.fhdw.de.tenmanager;

import android.app.Activity;
import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.Bundle;

public class Data {

    private Activity mActivity;
    AppDatabase mDb;


    public Data(Bundle savedInstanceState, Activity activity) {
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
        //mTopColorValue = b.getInt(Constants.KEYTOPCOLORVALUE);

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
        //b.putInt(Constants.KEYTOPCOLORVALUE, mTopColorValue);

    }

    public void createAndSaveNewEvent(String title, String date, String time, String description, String location)
    {
        Event event = new Event(title, date, time, description, location);
        mDb.eventDao().insertAll(event);
    }

    //getter
    public Activity getActivity () {
        return mActivity;
    }

}