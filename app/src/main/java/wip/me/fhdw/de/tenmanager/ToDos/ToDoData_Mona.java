package wip.me.fhdw.de.tenmanager.ToDos;

import android.app.Activity;
import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import wip.me.fhdw.de.tenmanager.AppDatabase;
import wip.me.fhdw.de.tenmanager.Constants;

public class ToDoData_Mona {

    private Activity mActivity;
    AppDatabase mDb;

    private String mToDoTitle;
    private String mToDoContent;
    private String mToDoDuedate;
    private int mStatus;
    private boolean mWithData;


    public ToDoData_Mona(Bundle savedInstanceState, Activity activity) {

        mActivity = activity;

        mDb = Room.databaseBuilder(activity.getApplicationContext(), AppDatabase.class, "todo")
                .allowMainThreadQueries()
                .build();


        //Restore saved Instance if available
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
        b.putString(Constants.KEYTODOTITLE, mToDoTitle);
        b.putString(Constants.KEYTODOCONTENT, mToDoContent);
        b.putString(Constants.KEYTODODUEDATE, mToDoDuedate);
        b.putInt(Constants.KEYTODOSTATUS, mStatus);
        b.putBoolean(Constants.KEYTODOWITHDATA, mWithData);
    }

    public void restoreDataFromBundle(Bundle b){ //Was macht diese Methode?????????????????
        mToDoTitle = b.getString(Constants.KEYTODOTITLE);
        mToDoContent = b.getString(Constants.KEYTODOCONTENT);
        mToDoDuedate = b.getString(Constants.KEYTODODUEDATE);
        mStatus = b.getInt(Constants.KEYTODOSTATUS);
        mWithData = b.getBoolean(Constants.KEYTODOWITHDATA);
    }

    public void createAndSaveNewTodo()
    {
        Log.d("LOGTAG", "neues Todo: "+mToDoTitle+" "+mToDoContent+" "+mToDoDuedate+" "+mStatus+"!!!!!!!!!!!!!!!!!!!!");
        ToDoOverview_Mona todo = new ToDoOverview_Mona(mToDoTitle, mToDoContent, mToDoDuedate, mStatus, "01010");
        mDb.todoDao().insertAll(todo);
    }

    public void updateTodo(String titleOld)
    {
        mDb.todoDao().deleteToDoByTitle(titleOld);
        Log.d("LOGTAG", "Content der gespeichert wird: "+mToDoContent);
        ToDoOverview_Mona newTodo = new ToDoOverview_Mona(mToDoTitle, mToDoContent, mToDoDuedate, mStatus, "01010");
        mDb.todoDao().insertAll(newTodo);
    }

    public Activity getActivity () {
        return mActivity;
    }

    public String getToDoTitle() {return mToDoTitle;}
    public String getToDoContent(){return mToDoContent;}
    public String getToDoDuedate() {return mToDoDuedate;}
    public int getToDoStatus(){return mStatus;}
    public boolean getWithData(){return mWithData;}

    public AppDatabase getDb() {
        return mDb;
    }

    public void setToDoTitle(String title){mToDoTitle = title;}
    public void setToDoContent(String content){mToDoContent = content;}
    public void setToDoDuedate(String date){mToDoDuedate = date;}
    public void setToDoStaus(int status){mStatus = status;}
    public void setWithData(boolean withData){mWithData = withData;}
}
