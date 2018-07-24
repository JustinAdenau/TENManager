package wip.me.fhdw.de.tenmanager;

import android.app.ListActivity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;


public class ToDoOverview_Mona extends ListActivity {
    @Override
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
