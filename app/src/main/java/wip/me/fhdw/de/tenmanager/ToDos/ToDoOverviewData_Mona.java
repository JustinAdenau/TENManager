package wip.me.fhdw.de.tenmanager.ToDos;

import android.app.Activity;
import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.Bundle;

import wip.me.fhdw.de.tenmanager.AppDatabase;
import wip.me.fhdw.de.tenmanager.Constants;

public class ToDoOverviewData_Mona {

    private Activity mActivity;
    AppDatabase mDb;

    private String mToDoTitle;
    private String mToDoContent;
    private String mToDoDueDate;
    private int mToDoStatus;

    public ToDoOverviewData_Mona(Bundle savedInstanceState, Activity activity) {

        mActivity = activity;

        mDb = Room.databaseBuilder(activity.getApplicationContext(), AppDatabase.class, "events")
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
        b.putString(Constants.KEYNOTETITLE, mToDoTitle);
        b.putString(Constants.KEYNOTECONTENT, mToDoContent);
        b.putString(Constants.KEYTODODUEDATE, mToDoDueDate);
        b.putInt(Constants.KEYTODOSTATUS, mToDoStatus);
    }

    public void restoreDataFromBundle(Bundle b){ //Was macht diese Methode?????????????????
        mToDoTitle = b.getString(Constants.KEYTODOTITLE);
        mToDoContent = b.getString(Constants.KEYTODOCONTENT);
        mToDoDueDate = b.getString(Constants.KEYTODODUEDATE);
        mToDoStatus = b.getInt(Constants.KEYTODOSTATUS);
    }

    public void createAndSaveNewTodo()
    {
        ToDoOverview_Mona todo = new ToDoOverview_Mona(mToDoTitle, mToDoContent, mToDoDueDate, mToDoStatus );
        mDb.todoDao().insertAll(todo);
    }

    public Activity getActivity () {
        return mActivity;
    }

    public String getToDoTitle() {return mToDoTitle;}
    public String getToDoContent(){return mToDoContent;}
    public String getToDoDueDate(){return mToDoDueDate;}
    public int getToDoStatus(){return mToDoStatus;}

    public void setToDoTitle(String title){mToDoTitle = title;}
    public void setToDoContent(String content){mToDoContent = content;}
    public void setToDoDueDate(String dueDate){mToDoDueDate = dueDate;}
    public void setToDoStatus(int status){mToDoStatus = status;}
}
