package wip.me.fhdw.de.tenmanager.ToDos;

import android.app.Activity;
import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.Bundle;

import wip.me.fhdw.de.tenmanager.AppDatabase;
import wip.me.fhdw.de.tenmanager.Constants;

public class ToDoData_Mona {

    private Activity mActivity;
    AppDatabase mDb;

    private String mToDoTitle;
    private String mToDoContent;
    private String mToDoDateTime;
    private int mStatus;

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
        b.putString(Constants.KEYNOTETITLE, mToDoTitle);
        b.putString(Constants.KEYNOTECONTENT, mToDoContent);
    }

    public void restoreDataFromBundle(Bundle b){ //Was macht diese Methode?????????????????
        mToDoTitle = b.getString(Constants.KEYNOTETITLE);
        mToDoContent = b.getString(Constants.KEYNOTECONTENT);
    }

    public void createAndSaveNewTodo()
    {
        ToDoOverview_Mona todo = new ToDoOverview_Mona(mToDoTitle, mToDoContent, mToDoDateTime, mStatus);
        mDb.todoDao().insertAll(todo);
    }

    public Activity getActivity () {
        return mActivity;
    }

    public String getToDoTitle() {return mToDoTitle;}
    public String getToDoContent(){return mToDoContent;}
    public String getmToDoDateTime() {return mToDoDateTime;}
    public int getToDoStatus(){return mStatus;}

    public void setToDoTitle(String title){mToDoTitle = title;}
    public void setToDoContent(String content){mToDoContent = content;}
    public void setToDoDateTime(String date){mToDoDateTime = date;}
    public void setToDoStaus(int status){mStatus = status;}
}
