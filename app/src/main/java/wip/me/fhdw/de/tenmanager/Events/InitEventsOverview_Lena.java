package wip.me.fhdw.de.tenmanager.Events;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.migration.Migration;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.zip.Inflater;

import wip.me.fhdw.de.tenmanager.AppDatabase;
import wip.me.fhdw.de.tenmanager.Menu.Menu_Alina_und_Mona;
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
            //.addMigrations(MIGRATION_5_6)
            .allowMainThreadQueries()
            .build();
    }

    //if database table is changed (new version) migration is needed
    /*static final Migration MIGRATION_5_6 = new Migration(5, 6) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
            database.execSQL("CREATE TABLE IF NOT EXISTS 'todoOverview_mona'('todo_id' INTEGER PRIMARY KEY NOT NULL, 'todo_title' TEXT, 'todo_duedate' TEXT, 'todo_status' INTEGER NOT NULL, 'todo_content' TEXT)");
        }
    };*/


    public void initGui()
    {
        mGui = new GuiEventsOverview_Lena(this);
        initToolbar();
        //initMenu();
    }

    public void initApplicationLogic(){mApplicationLogic = new ApplicationLogicEventsOverview_Lena(this, mData, mGui, mDb, mEventAdapter);}
    public void initListAdapter(){mEventAdapter = new EventAdapter_Lena(getApplicationContext());}

    public void initToolbar()
    {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        TextView toolbarTextview = toolbar.findViewById(R.id.toolbar_textview);
        toolbarTextview.setText("Events");
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);


        /*DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer);
        if(drawer == null) Log.d("LOGTAG", "drawer ist null!!!!!!!!!!!!!!!!!!");
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();*/
    }

    public void initMenu()
    {
        //Menu_Alina_und_Mona menu = new Menu_Alina_und_Mona();
    }

    @Override
    public boolean onCreateOptionsMenu (Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected (MenuItem item){
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


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
