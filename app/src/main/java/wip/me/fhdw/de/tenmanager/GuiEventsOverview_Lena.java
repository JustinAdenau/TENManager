package wip.me.fhdw.de.tenmanager;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewStub;
import android.widget.ListView;
import android.widget.TextView;

public class GuiEventsOverview_Lena {

    private ListView mlistView;
    private ViewStub stub;
    private View inflated;

    public GuiEventsOverview_Lena(InitEventsOverview_Lena activity)
    {
        activity.setContentView(R.layout.activity_main);
        stub = (ViewStub) activity.findViewById(R.id.viewStub);
        stub.setLayoutResource(R.layout.eventsoverview_lena);
        inflated = stub.inflate();

        mlistView = activity.findViewById(android.R.id.list);
    }

    //getter to access Views
    public ListView getListView(){return mlistView;}

    //methods to change View attributes


}
