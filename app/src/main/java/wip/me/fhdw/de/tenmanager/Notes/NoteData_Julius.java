package wip.me.fhdw.de.tenmanager.Notes;

import android.app.Activity;
import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import wip.me.fhdw.de.tenmanager.AppDatabase;
import wip.me.fhdw.de.tenmanager.Constants;

public class NoteData_Julius {

    private Activity mActivity;
    AppDatabase mDb;

    private String mNoteTitle;
    private String mNoteContent;
    private boolean mWithData;

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
        mWithData = b.getBoolean(Constants.KEYNOTEWITHDATA);
        Log.d("LOGTAG", "withData wird in Data entgegengenommen:"+mWithData);
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
        b.putBoolean(Constants.KEYNOTEWITHDATA, mWithData);
    }

    public void createAndSaveNewNote()
    {
        Note_Julius note = new Note_Julius(mNoteTitle, mNoteContent);
        mDb.noteDao().insertAll(note);
    }

    public void updateNote(String title, String content)
    {
        Note_Julius noteOld = mDb.noteDao().getNoteByTitleContent(title);
        if(noteOld != null) {
            mDb.noteDao().deleteNote(noteOld);
            createAndSaveNewNote();
        }
    }

    public Activity getActivity () {
        return mActivity;
    }
    public String getNoteTitle() {return mNoteTitle;}
    public String getNoteContent(){return mNoteContent;}
    public AppDatabase getDb(){return mDb;}
    public boolean getWithData() {return mWithData;}

    public void setNoteTitle(String title){mNoteTitle = title;}
    public void setNoteContent(String content){mNoteContent = content;}
    public void setWithData (boolean withData) {mWithData = withData;}

}
