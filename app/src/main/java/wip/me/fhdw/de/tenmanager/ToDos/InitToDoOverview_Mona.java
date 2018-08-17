package wip.me.fhdw.de.tenmanager.ToDos;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import wip.me.fhdw.de.tenmanager.AppDatabase;
import wip.me.fhdw.de.tenmanager.R;

public class InitToDoOverview_Mona extends AppCompatActivity {

    private GuiToDoOverview_Mona mGui;
    private ApplicationLogicToDoOverview_Mona mApplicationLogic;
    private ToDoOverviewData_Mona mToDoData;
    private AppDatabase mDb;
    private ToDoOverviewAdapter_Mona mToDoAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        initDb();
        initData(savedInstanceState);
        initGui();
        initListAdapter();
        initApplicationLogic();
    }

    private void initData(Bundle savedInstanceState) {
        mToDoData = new ToDoOverviewData_Mona(savedInstanceState, this);
    }

    public void initApplicationLogic(){ mApplicationLogic = new ApplicationLogicToDoOverview_Mona(mToDoData, mGui, mDb, mToDoAdapter); }

    public void initListAdapter(){mToDoAdapter = new ToDoOverviewAdapter_Mona(getApplicationContext());}

    private void initGui() {
       mGui = new GuiToDoOverview_Mona(this);
       initToolbar();
    }

    private void initDb() {
        mDb = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "events")
                //.addMigrations(MIGRATION_2_3)
                .allowMainThreadQueries()
                .build();
    }

    public void initToolbar(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        TextView toolbarTextview = toolbar.findViewById(R.id.toolbar_textview);
        toolbarTextview.setText("ToDos");
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
