package wip.me.fhdw.de.tenmanager.Events;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import wip.me.fhdw.de.tenmanager.R;

public class GuiEventsOverview_Lena {

    private ListView mListView;
    private ViewStub mStub;
    private View mInflated;
    private TextView mTextViewTitle;
    private TextView mTextViewDateStart;
    private TextView mTextViewTimeStart;
    private TextView mTextViewDateEnd;
    private TextView mTextViewTimeEnd;

    private ImageButton mButtonDeleteEvent;
    private FloatingActionButton mFabCreateNew;
    private NavigationView mNavigationView;



    public GuiEventsOverview_Lena(InitEventsOverview_Lena activity)
    {
        activity.setContentView(R.layout.menu_alina_und_mona);

        mStub = (ViewStub) activity.findViewById(R.id.viewStub);
        mStub.setLayoutResource(R.layout.eventsoverview_lena);
        mInflated = mStub.inflate();

        mListView = activity.findViewById(android.R.id.list);

        LayoutInflater inflater = LayoutInflater.from(activity.getApplicationContext());
        View view = inflater.inflate(R.layout.list_item_eventsoverview, null);

        mTextViewTitle = view.findViewById(R.id.listviewitem_textview_event_title);
        mTextViewDateStart = view.findViewById(R.id.listviewitem_textview_dateStart);
        mTextViewTimeStart = view.findViewById(R.id.listviewitem_textview_timeStart);
        mTextViewDateEnd = view.findViewById(R.id.listviewitem_textview_dateEnd);
        mTextViewTimeEnd = view.findViewById(R.id.listviewitem_textview_timeEnd);

        mButtonDeleteEvent = view.findViewById(R.id.buttonDeleteEvent);

        mFabCreateNew = activity.findViewById(R.id.fab);

        mNavigationView = activity.findViewById(R.id.nav_view);
    }

    //getter to access Views
    public ListView getListView(){return mListView;}
    public FloatingActionButton getFabCreateNew() {return mFabCreateNew;}
    public ImageButton getButtonDeleteEvent(){return mButtonDeleteEvent;}
    public NavigationView getNavigationView(){return mNavigationView;}



    //methods to change View attributes




}
