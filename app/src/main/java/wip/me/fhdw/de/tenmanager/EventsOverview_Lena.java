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

    private EventAdapter eventAdapter;
    private ListView eventListView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.setContentView(R.layout.activity_main);

        //set ListView
        eventListView = findViewById(android.R.id.list);

        //set Database
        AppDatabase db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "events")
                .allowMainThreadQueries()
                .build();

        //Beispieldaten in DB bringen
        Event geburtstag = new Event("Geburtstagsfeier", "20.07.2018", "20:00", "Jana feiert ihren Geburtstag bei ihr im Garten");
        Event weihnachten = new Event("Weihnachten", "24.12.2018", "ganztägig", "");

        db.eventDao().insertAll(geburtstag, weihnachten);

        //get all Events from Database
        List<Event> events = db.eventDao().getAllEvents();

        /*Event geburtstag = new Event("Geburtstagsfeier", "20.07.2018", "20:00", "Jana feiert ihren Geburtstag bei ihr im Garten");
        Event weihnachten = new Event("Weihnachten", "24.12.2018", "ganztägig", "");

        final List<Event> eventList = new ArrayList<>();
        eventList.add(geburtstag);
        eventList.add(weihnachten);*/

        //set Adapter for ListView
        eventAdapter = new EventAdapter(getApplicationContext(), events);
        eventListView.setAdapter(eventAdapter);

        //set onClickListener for ListView
        eventListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                /*Intent intent = new Intent(EventsOverview_Lena.this, );
                intent.setClassName(getPackageName(), getPackageName()+".EventsDetailview_Sebastian"); //TODO: Einfügen der Activity Detailansicht Events
                intent.putExtra("selected", eventListView.getItemAtPosition(i).toString());
                startActivity(intent);*/
            }
        });


    }

}
