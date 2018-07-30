package wip.me.fhdw.de.tenmanager;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;
import android.widget.TextView;

public class GuiEventsOverview_Lena {

    private ListView mlistView;

    public GuiEventsOverview_Lena(InitEventsOverview_Lena activity)
    {
        activity.setContentView(R.layout.activity_main);

        mlistView = activity.findViewById(android.R.id.list);
    }

    //getter to access Views
    public ListView getListView(){return mlistView;}

    //methods to change View attributes


}
