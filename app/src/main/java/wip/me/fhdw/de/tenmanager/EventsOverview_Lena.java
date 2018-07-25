package wip.me.fhdw.de.tenmanager;

import android.app.Activity;
import android.app.ListActivity;
import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;


public class EventsOverview_Lena extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.setContentView(R.layout.activity_main);



        List<String> EventList = new ArrayList<>();
        EventList.add("Geburtstagsfeier 20.07.2018, 20:00 Uhr im Garten");
        EventList.add("Weihnachten 24.12.2018, ganztägig Zuhause");
        EventList.add("Silvesterparty 31.12.2018, 19:00 Uhr bei Franziska");

        ListAdapter adapter = new ArrayAdapter<>(getApplicationContext(), R.layout.list_item_eventsoverview, R.id.listviewitem_textview_title, EventList);
        final ListView listView = findViewById(android.R.id.list);
        listView.setAdapter(adapter);

       /* listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(EventsOverview_Lena.this, Even);
                intent.setClassName(getPackageName(), getPackageName()+".EventsDetailview_Sebastian"); //TODO: Einfügen der Activity Detailansicht Events
                intent.putExtra("selected", listView.getItemAtPosition(i).toString());
                startActivity(intent);
            }
        });*/

       AppDatabase db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "events")
               .allowMainThreadQueries()
               .build();

       List<Event> events = db.eventDao().getAllEvents();
    }


}
