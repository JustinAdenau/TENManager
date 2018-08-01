package wip.me.fhdw.de.tenmanager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

public class InitNoteOverview_Julius extends AppCompatActivity {

    private GuiNoteOverview_Julius mGui;
    private ApplicationLogicNoteOverview_Julius mApplicationLogic;
    private NoteData mNoteData;
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
        mData = new Data(savedInstanceState, this);
    }

    public void initDb()
    {
        mDb = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "events")
        //.addMigrations(MIGRATION_2_3)
          .allowMainThreadQueries()
          .build();
    }

    public void initGui(){
        mGui = new GuiNoteOverview_Julius(this);
    }
    public void initApplicationLogic(){ mApplicationLogic = new ApplicationLogicNoteOverview_Julius(mData, mGui); }
    public void initListAdapter(){mNoteAdapter = new NoteAdapter_Julius(getApplicationContext());}
    public void initToolbar(){Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        TextView toolbarTextview = toolbar.findViewById(R.id.toolbar_textview);
        toolbarTextview.setText("Notes");
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
