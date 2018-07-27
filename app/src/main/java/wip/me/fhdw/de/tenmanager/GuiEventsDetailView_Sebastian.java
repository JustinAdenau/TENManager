package wip.me.fhdw.de.tenmanager;

import android.widget.Button;

public class GuiEventsDetailView_Sebastian {

    private Button mButtonDate;
    private Button mButtonTime;

    public GuiEventsDetailView_Sebastian(InitEventsDetailView_Sebastian activity){
        activity.setContentView(R.layout.eventsdetailview_sebastian);

        mButtonDate = activity.findViewById(R.id.eventDate);
        mButtonTime = activity.findViewById(R.id.eventTime);
    }

    public Button getButtonDate() {
        return mButtonDate;
    }

    public Button getButtonTime() {
        return mButtonTime;
    }
}
