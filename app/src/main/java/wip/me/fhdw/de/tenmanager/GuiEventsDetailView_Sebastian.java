package wip.me.fhdw.de.tenmanager;


import android.widget.Button;
import android.widget.EditText;

public class GuiEventsDetailView_Sebastian {

    private Button mButtonDate;
    private Button mButtonTime;
    private Button mButtonSpan;

    public GuiEventsDetailView_Sebastian(InitEventsDetailView_Sebastian activity){
        activity.setContentView(R.layout.eventsdetailview_sebastian);

        mButtonDate = activity.findViewById(R.id.eventDate);
        mButtonTime = activity.findViewById(R.id.eventTime);
        mButtonSpan = activity.findViewById(R.id.eventSpan);

    }

    public Button getButtonDate() {
        return mButtonDate;
    }

    public Button getButtonTime() {
        return mButtonTime;
    }

    public Button getButtonSpan() {
        return mButtonSpan;
    }

    public void setButtonSpan(Button mButtonSpan) {
        this.mButtonSpan = mButtonSpan;
    }

}
