package wip.me.fhdw.de.tenmanager;

import android.app.Activity;
import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

public class InitEventsDetailview_Lena extends AppCompatActivity {

    private GuiEventsDetailview_Lena mGui;
    private ApplicationLogicEventsDetailview_Lena mApplicationLogic;

    private Data mData;
    private AppDatabase mDb;


    /*@Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initDb();
        initData(savedInstanceState);
        initGui();
        initApplicationLogic();
    }


    public void initData(Bundle savedInstanceState)
    {
        mData = new Data(savedInstanceState, this);
    }

    public void initDb(){mDb = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "events")
            //.addMigrations(MIGRATION_1_2)
            .allowMainThreadQueries()
            .build();
    }

    //if database table is changed (new version) migration is needed
    static final Migration MIGRATION_1_2 = new Migration(1, 2) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {
            database.execSQL("ALTER TABLE 'event' ADD 'event_location' TEXT");
        }
    };

    public void initGui(){mGui = new GuiEventsDetailview_Lena(this); initToolbar();}
    public void initApplicationLogic(){mApplicationLogic = new ApplicationLogicEventsDetailview_Lena(mData, mGui, mDb);}

    public void initToolbar(){Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        TextView toolbarTextview = toolbar.findViewById(R.id.toolbar_textview);
        toolbarTextview.setText("Event"); }

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
    }*/
}
