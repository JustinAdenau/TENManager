package wip.me.fhdw.de.tenmanager.Notes;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.migration.Migration;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.TextView;

import wip.me.fhdw.de.tenmanager.AppDatabase;
import wip.me.fhdw.de.tenmanager.R;

public class InitNoteOverview_Julius extends AppCompatActivity {

    private GuiNoteOverview_Julius mGui;
    private ApplicationLogicNoteOverview_Julius mApplicationLogic;
    private NoteData_Julius mNoteData;
    private AppDatabase mDb;
    private NoteAdapter_Julius mNoteAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        initDb();
        initData(savedInstanceState);
        initGui();
        initListAdapter();
        initApplicationLogic();
    }

    public void initData(Bundle savedInstanceState)
    {
        mNoteData = new NoteData_Julius(savedInstanceState, this);
    }

    public void initDb()
    {
        mDb = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "events")
          /*.addMigrations(MIGRATION_3_4)
                .addMigrations(MIGRATION_4_5)*/
          .allowMainThreadQueries()
          .build();
    }

    /*static final Migration MIGRATION_3_4 = new Migration(3,4) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
            database.execSQL("ALTER TABLE 'event' ADD 'event_date_end' TEXT");
            database.execSQL("ALTER TABLE 'event' ADD 'event_time_end' TEXT");
            database.execSQL("ALTER TABLE 'event' RENAME TO 'event_old'");
            database.execSQL("CREATE TABLE 'event'(id INTEGER primary key not null, event_title TEXT, event_date_start TEXT, event_time_start TEXT, event_date_end TEXT, event_time_end TEXT, event_description TEXT, event_location TEXT)");
            database.execSQL("DROP TABLE 'event_old'");
        }
    };

    //if database table is changed (new version) migration is needed
    static final Migration MIGRATION_4_5 = new Migration(4, 5) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {
            database.execSQL("CREATE TABLE IF NOT EXISTS 'note_julius'('note_id' INTEGER PRIMARY KEY NOT NULL, 'note_title' TEXT, 'note_content' TEXT)");
        }

    };*/

    public void initGui(){
        mGui = new GuiNoteOverview_Julius(this);
        initToolbar();
    }
    public void initApplicationLogic(){ mApplicationLogic = new ApplicationLogicNoteOverview_Julius(this, mNoteData, mGui, mDb, mNoteAdapter); }
    public void initListAdapter(){mNoteAdapter = new NoteAdapter_Julius(getApplicationContext());}

    public void initToolbar(){Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        getSupportActionBar().hide();
        TextView toolbarTextview = toolbar.findViewById(R.id.toolbar_textview);
        toolbarTextview.setText("Notes");
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer);
        if(drawer == null) Log.d("LOGTAG", "drawer ist null!!!!!!!!!!!!!!!!!!");
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
    }

    @Override
    protected void onSaveInstanceState(Bundle ourState){
        super.onSaveInstanceState(ourState);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        mApplicationLogic.onActivityReturned(requestCode, resultCode, data);
    }

    @Override
    public void onBackPressed(){
        mApplicationLogic.onBackPressed();
    }
}
