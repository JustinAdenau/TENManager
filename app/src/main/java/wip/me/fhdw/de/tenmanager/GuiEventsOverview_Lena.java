package wip.me.fhdw.de.tenmanager;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewStub;
import android.widget.ListView;
import android.widget.TextView;

public class GuiEventsOverview_Lena {

    private ListView mlistView;
    private ViewStub mStub;
    private View mInflated;
    private TextView mTextViewTitle;
    private TextView mTextViewDate;
    private TextView mTextViewTime;

    private FloatingActionButton mFabCreateNew;


    public GuiEventsOverview_Lena(InitEventsOverview_Lena activity)
    {
        activity.setContentView(R.layout.activity_main);
        mStub = (ViewStub) activity.findViewById(R.id.viewStub);
        mStub.setLayoutResource(R.layout.eventsoverview_lena);
        mInflated = mStub.inflate();

        mlistView = activity.findViewById(android.R.id.list);

        LayoutInflater inflater = LayoutInflater.from(activity.getApplicationContext());
        View view = inflater.inflate(R.layout.list_item_eventsoverview, null);

        mTextViewTitle = view.findViewById(R.id.listviewitem_textview_title);
        mTextViewDate = view.findViewById(R.id.listviewitem_textview_date);
        mTextViewTime = view.findViewById(R.id.listviewitem_textview_time);

        mFabCreateNew = activity.findViewById(R.id.fab);
    }

    //getter to access Views
    public ListView getListView(){return mlistView;}
    public FloatingActionButton getFabCreateNew() {return mFabCreateNew;}

    public TextView getTextViewTitle(){return mTextViewTitle;}
    public TextView getTextViewDate(){return mTextViewDate;}
    public TextView getTextViewTime(){return mTextViewTime;}

    //methods to change View attributes


}
