package wip.me.fhdw.de.tenmanager.Homepage;

import android.support.design.widget.NavigationView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import wip.me.fhdw.de.tenmanager.R;

public class GuiHomepage_Justin {
    private ViewStub mStub;
    private View mInflated;

    private TextView mCurrentDate;
    private ListView mEventListView;
    private ListView mTodoListView;

    private TextView mTodoHeader;
    private TextView mTodoTitle;
    private TextView mTodoDate;
    private ImageButton mButtonDeleteTodo;

    private TextView mEventHeader;
    private TextView mEventTitle;
    private TextView mEventDate;
    private TextView mEventTime;
    private ImageButton mButtonDeleteEvent;
    private NavigationView mNavigationView;


    public GuiHomepage_Justin(InitHomepage_Justin activity){
        activity.setContentView(R.layout.menu_homepage);
        mStub = (ViewStub) activity.findViewById(R.id.viewStub);
        mStub.setLayoutResource(R.layout.homepage_justin);


        mInflated = mStub.inflate();
        mCurrentDate = activity.findViewById(R.id.homepage_date);
        mEventHeader = activity.findViewById(R.id.homepage_header_event);
        mTodoHeader = activity.findViewById(R.id.homepage_header_todo);


        LayoutInflater inflater = LayoutInflater.from(activity.getApplicationContext());
        View view = inflater.inflate(R.layout.list_item_homepage_event, null);


        mEventListView = activity.findViewById(R.id.listview_events);
        mEventTitle = view.findViewById(R.id.homepage_event_title);
        mEventDate = view.findViewById(R.id.homepage_event_date);
        mEventTime = view.findViewById(R.id.homepage_event_time);
        mButtonDeleteEvent = view.findViewById(R.id.homepage_buttonDeleteEvent);

        View view2 = inflater.inflate(R.layout.list_item_homepage_todo, null);

        mTodoListView = activity.findViewById(R.id.listview_todos);
        mTodoTitle = view2.findViewById(R.id.homepage_todo_title);
        mTodoDate = view2.findViewById(R.id.homepage_todo_date);
        mButtonDeleteTodo = view2.findViewById(R.id.homepage_buttonDeleteTodo);

        mNavigationView = activity.findViewById(R.id.nav_view);
        if(mNavigationView == null) Log.d("LOGTAG", "NavigationView ist null in GuiEventsOverview Z.59!!!!!!!!!!");
    }

    public TextView getmCurrentDate(){return mCurrentDate;}
    public ListView getEventListView(){return mEventListView;}
    public ListView getTodoListView(){return mTodoListView;}

    public TextView getEventHeader(){return mEventHeader;}
    public TextView getTodoHeader(){return mTodoHeader;}

    public TextView getTextViewEventTitle(){return mEventTitle;}
    public TextView getTextViewEventDate(){return mEventDate;}
    public TextView getTextViewEventTime(){return mEventTime;}
    public ImageButton getButtonDeleteEvent(){return mButtonDeleteEvent;}

    public TextView getTextViewTodoTitle(){return mTodoTitle;}
    public TextView getTextViewTodoDate(){return mTodoDate;}
    public ImageButton getButtonDeleteTodo(){return mButtonDeleteTodo;}

    public NavigationView getNavigationView(){return mNavigationView;}
}
