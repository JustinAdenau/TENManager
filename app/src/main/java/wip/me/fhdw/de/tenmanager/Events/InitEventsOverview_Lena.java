package wip.me.fhdw.de.tenmanager.Events;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.migration.Migration;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import wip.me.fhdw.de.tenmanager.AppDatabase;
import wip.me.fhdw.de.tenmanager.R;

public class InitEventsOverview_Lena extends AppCompatActivity {

    private GuiEventsOverview_Lena mGui;
    private ApplicationLogicEventsOverview_Lena mApplicationLogic;
    private EventData_Lena mData;
    private AppDatabase mDb;
    private EventAdapter_Lena mEventAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initDb();
        initData(savedInstanceState);
        initGui();
        initListAdapter();
        initApplicationLogic();
    }

    public void initData(Bundle savedInstanceState)
    {
        mData = new EventData_Lena(savedInstanceState, this);
    }

    public void initDb(){mDb = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "events")


            //.addMigrations(MIGRATION_2_5)
            .allowMainThreadQueries()
            .build();
    }

    //if database table is changed (new version) migration is needed


    /*static final Migration MIGRATION_2_5 = new Migration(2, 5) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {
            database.execSQL("CREATE TABLE IF NOT EXISTS 'note_julius'('note_id' INTEGER PRIMARY KEY NOT NULL, 'note_title' TEXT, 'note_content' TEXT)");
            database.execSQL("ALTER TABLE 'event' RENAME TO 'event_old'");
            database.execSQL("CREATE TABLE 'event' (id INTEGER PRIMARY KEY NOT NULL, event_title TEXT, event_date_start TEXT, " +
                    "event_time_start TEXT, event_date_end TEXT, event_time_end TEXT," +
                    "event_description TEXT, event_location TEXT)");
            database.execSQL("DROP TABLE 'event_old'");
        }

    };*/

    public void initGui(){mGui = new GuiEventsOverview_Lena(this); /*initToolbar()*/;}
    public void initApplicationLogic(){mApplicationLogic = new ApplicationLogicEventsOverview_Lena(this, mData, mGui, mDb, mEventAdapter);}
    public void initListAdapter(){mEventAdapter = new EventAdapter_Lena(getApplicationContext());}

    public void initToolbar()
    {
        /*Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        TextView toolbarTextview = toolbar.findViewById(R.id.toolbar_textview);
        toolbarTextview.setText("Events");*/  }

    @Override
    protected void onSaveInstanceState (Bundle outState) {
        //mData.saveDataInBundle(outState);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // super.onActivityResult(requestCode, resultCode, data);
        mApplicationLogic.onActivityReturned(requestCode, resultCode, data);
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        mApplicationLogic.onBackPressed();
    }

}
