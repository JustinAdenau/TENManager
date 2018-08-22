package wip.me.fhdw.de.tenmanager.Homepage;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import wip.me.fhdw.de.tenmanager.AppDatabase;
import wip.me.fhdw.de.tenmanager.Events.EventData_Lena;
import wip.me.fhdw.de.tenmanager.R;
import wip.me.fhdw.de.tenmanager.ToDos.ToDoData_Mona;

public class InitHomepage_Justin extends AppCompatActivity{

    private GuiHomepage_Justin mGui;
    private ApplicationLogicHomepage_Justin mApplicationLogic;
    private ToDoData_Mona mTodoData;
    private EventData_Lena mEventData;
    private AppDatabase mDb;
    private ToDoAdapter_Justin mTodoAdapter;
    private EventAdapter_Justin mEventAdapter;

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
        mEventData = new EventData_Lena(savedInstanceState, this);
        mTodoData = new ToDoData_Mona(savedInstanceState,this);
    }

    public void initDb()
    {
        mDb = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "events")
                //.addMigrations(MIGRATION_2_3)
                .allowMainThreadQueries()
                .build();
    }

    public void initGui(){
        mGui = new GuiHomepage_Justin(this);initToolbar();
    }
    public void initApplicationLogic(){ mApplicationLogic = new ApplicationLogicHomepage_Justin(this, mEventData,mTodoData,
            mGui, mDb, mTodoAdapter,mEventAdapter); }
    public void initListAdapter(){mEventAdapter = new EventAdapter_Justin(getApplicationContext());
        mTodoAdapter = new ToDoAdapter_Justin(getApplicationContext());}
    public void initToolbar(){Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        TextView toolbarTextview = toolbar.findViewById(R.id.toolbar_textview);
        toolbarTextview.setText("Start");
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
