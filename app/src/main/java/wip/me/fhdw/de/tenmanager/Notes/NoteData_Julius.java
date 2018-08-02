package wip.me.fhdw.de.tenmanager.Notes;

import android.app.Activity;
import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import wip.me.fhdw.de.tenmanager.AppDatabase;
import wip.me.fhdw.de.tenmanager.Constants;

public class NoteData_Julius {

    private Activity mActivity;
    AppDatabase mDb;

    private String mNoteTitle;
    private String mNoteContent;

    public NoteData_Julius(Bundle savedInstanceState, Activity activity) {
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

    public void restoreDataFromBundle(Bundle b)
    {
        mNoteTitle = b.getString(Constants.KEYNOTETITLE);
        mNoteContent = b.getString(Constants.KEYNOTECONTENT);
    }

    public void readIntentParametersOrSetDefaultValues(Intent intent)
    {
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

    public void saveDataInBundle(Bundle b)
    {
        b.putString(Constants.KEYNOTETITLE, mNoteTitle);
        b.putString(Constants.KEYNOTECONTENT, mNoteContent);
    }

    public void createAndSaveNewNote()
    {
        Note_Julius note = new Note_Julius(mNoteTitle, mNoteContent);
        mDb.noteDao().insertAll(note);
    }

    public Activity getActivity () {
        return mActivity;
    }
    public String getNoteTitle() {return mNoteTitle;}
    public String getNoteContent(){return mNoteContent;}

    public void setNoteTitle(String title){mNoteTitle = title;}
    public void setNoteContent(String content){mNoteContent = content;}

}
