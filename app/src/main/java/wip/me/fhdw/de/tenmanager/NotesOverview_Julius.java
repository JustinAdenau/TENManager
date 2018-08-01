package wip.me.fhdw.de.tenmanager;

import android.app.ListActivity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;


public class NotesOverview_Julius extends ListActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.setContentView(R.layout.activity_main);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        List<String> NotesList = new ArrayList<>();
        NotesList.add("Mich an Milch kaufen erinnern");
        NotesList.add("Meine Lieblingsblumen: - Rosen - Lilien - Veilchen");
        NotesList.add("Serien die ich noch schauen will: Lucifer, Blindspot, NavyCIS, HIMYM");

        ListAdapter adapter = new ArrayAdapter<>(getApplicationContext(), R.layout.list_item_notesoverview, R.id.listviewitem_textview_title, NotesList);
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

    }
}