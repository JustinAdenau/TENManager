package wip.me.fhdw.de.tenmanager;

import android.widget.ListView;

public class GuiEventsOverview_Lena {

    ListView mlistView;

    public GuiEventsOverview_Lena(InitEventsOverview_Lena activity)
    {
        activity.setContentView(R.layout.activity_main);

        mlistView = activity.findViewById(android.R.id.list);
    }

    //getter to access Views
    public ListView getListView(){return mlistView;}

    //methods to change View attributes


}
