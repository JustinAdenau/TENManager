package wip.me.fhdw.de.tenmanager;

import android.app.Activity;
import android.widget.Button;

public class GuiEventsDetailView_Sebastian {

    private Button mButtonDate;
    private Button mButtonTime;

    public GuiEventsDetailView_Sebastian(InitEventsDetailView_Sebastian activity){
        activity.setContentView(R.layout.eventsdetailview_sebastian);

        mButtonDate = activity.findViewById(R.id.eventDate);
    }

    public Button getButtonDate() {
        return mButtonDate;
    }
}
