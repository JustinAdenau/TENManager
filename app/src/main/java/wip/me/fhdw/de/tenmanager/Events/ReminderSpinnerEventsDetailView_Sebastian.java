package wip.me.fhdw.de.tenmanager.Events;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;


import wip.me.fhdw.de.tenmanager.R;

public class ReminderSpinnerEventsDetailView_Sebastian extends AppCompatActivity{

    private GuiEventsDetailView_Sebastian mGui;



    public ReminderSpinnerEventsDetailView_Sebastian(GuiEventsDetailView_Sebastian gui){
       mGui = gui;

    }


   public void buildReminderSpinner(){
       // String[] ReminderList = new String[]{"keine Erinnerung","5 Minuten vorher","15 Minuten vorher", "30 Minuten vorher","1 Stunde vorher","2 Stunden vorher"};

       // ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, ReminderList);

       // mGui.getSpinnerReminder().setAdapter(adapter);

        Spinner spinner = mGui.getSpinnerReminder();

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.reminder_list, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
       // spinner.setOnItemSelectedListener(this);
    }

}
