package wip.me.fhdw.de.tenmanager.ToDos;

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

public class InitToDoOverview_Mona extends AppCompatActivity {

    private GuiToDoOverview_Mona mGui;
    private ApplicationLogicToDoOverview_Mona mApplicationLogic;
    private ToDoData_Mona mToDoData;
    private AppDatabase mDb;
    private ToDoAdapter_Mona mToDoAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        initDb();
        initData(savedInstanceState);
        initGui();
        initListAdapter();
        initApplicationLogic();
        initListener();
    }

    private void initData(Bundle savedInstanceState)
    {
        mToDoData = new ToDoData_Mona(savedInstanceState, this);
    }

    public void initApplicationLogic(){ mApplicationLogic = new ApplicationLogicToDoOverview_Mona(mToDoData, mGui, mDb, mToDoAdapter, this); }

    public void initListAdapter(){
        mToDoAdapter = new ToDoAdapter_Mona(getApplicationContext());}

    private void initGui() {
       mGui = new GuiToDoOverview_Mona(this);
       initToolbar();
    }

    private void initDb() {
        mDb = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "events")
                .addMigrations(MIGRATION_5_6)
                .allowMainThreadQueries()
                .build();
    }

    static final Migration MIGRATION_5_6 = new Migration(5, 6) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
            database.execSQL("CREATE TABLE IF NOT EXISTS 'todoOverview_mona'('todo_id' INTEGER PRIMARY KEY NOT NULL, 'todo_title' TEXT, 'todo_duedate' TEXT, 'todo_status' INTEGER NOT NULL, 'todo_content' TEXT)");
        }
    };

    public void initToolbar(){Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        getSupportActionBar().hide();
        TextView toolbarTextview = toolbar.findViewById(R.id.toolbar_textview);
        toolbarTextview.setText("ToDos");
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

    public void initListener()
    {
        ToDoFloatingActionButtonClickListener_Mona floatingactionbutton = new ToDoFloatingActionButtonClickListener_Mona(mApplicationLogic);
        mGui.getFabSaved().setOnClickListener(floatingactionbutton);
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


    /*@Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.setContentView(R.layout.todooverview_mona);

        List<String> ToDoList = new ArrayList<>();
        ToDoList.add("Frühjahrsputz Bügeln, Putzen, Waschen");
        ToDoList.add("Einkaufen Käse, Wurst, Brot");
        ToDoList.add("E-Mail Bewerbung Lebenslauf Foto");

        ListAdapter adapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.listview_item, ToDoList);
        final ListView listView = findViewById(R.id.todooverviewListview);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(EventsOverview_Lena.this, Even);
                intent.setClassName(getPackageName(), getPackageName()+".EventsDetailview_Sebastian"); //TODO: Einfügen der Activity Detailansicht Events
                intent.putExtra("selected", listView.getItemAtPosition(i).toString());
                startActivity(intent);
            }
        });

    }*/
}
