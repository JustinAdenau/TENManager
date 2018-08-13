package wip.me.fhdw.de.tenmanager.Homepage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import wip.me.fhdw.de.tenmanager.R;

public class GuiHomepage_Justin {
    private ListView mListView;
    private ViewStub mStub;
    private View mInflated;
    private TextView mTitle;
    private TextView mDate;
    private TextView mTime;

    private TextView mEvent;

    private ImageButton mButtonDeleteEvent;


    public GuiHomepage_Justin(InitHomepage_Justin activity){
        activity.setContentView(R.layout.homepage_layout_justin);
        mStub = (ViewStub) activity.findViewById(R.id.viewStub);
        mStub.setLayoutResource(R.layout.homepage_justin);

        mInflated = mStub.inflate();
        mEvent = activity.findViewById(R.id.homepage_title_event);
        mListView = activity.findViewById(android.R.id.list);

        LayoutInflater inflater = LayoutInflater.from(activity.getApplicationContext());
        View view = inflater.inflate(R.layout.list_item_homepage_event, null);

        mTitle = view.findViewById(R.id.homepage_event_title);
        mDate = view.findViewById(R.id.homepage_event_date);
        mTime = view.findViewById(R.id.homepage_event_time);



        mButtonDeleteEvent = view.findViewById(R.id.homepage_buttonDeleteEvent);

    }

    public ListView getListView(){return mListView;}

    public TextView getTextViewTitle(){return mTitle;}
    public TextView getTextViewDate(){return mDate;}
    public TextView getTextViewTime(){return mTime;}

    public TextView getEvent(){return mEvent;}

    public ImageButton getButtonDeleteEvent(){return mButtonDeleteEvent;}
}
