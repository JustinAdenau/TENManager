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

    private ListView mlistView;
    private ViewStub mStub;
    private View mInflated;
    private TextView mTextViewTitle;
    private TextView mTextViewDateStart;
    private TextView mTextViewTimeStart;
    private TextView mTextViewDateEnd;
    private TextView mTextViewTimeEnd;

    private ImageButton mButtonDeleteEvent;
    private ImageButton mButtonMenu;
    private FloatingActionButton mFabCreateNew;
    private NavigationView mNavigationView;



    public GuiEventsOverview_Lena(InitEventsOverview_Lena activity)
    {
        activity.setContentView(R.layout.activity_main);

        //mButtonMenu = (ImageButton) activity.findViewById(R.id.button_menu);

        mStub = (ViewStub) activity.findViewById(R.id.viewStub);
        mStub.setLayoutResource(R.layout.eventsoverview_lena);
        mInflated = mStub.inflate();

        mlistView = activity.findViewById(android.R.id.list);

        LayoutInflater inflater = LayoutInflater.from(activity.getApplicationContext());
        View view = inflater.inflate(R.layout.list_item_eventsoverview, null);

        mTextViewTitle = view.findViewById(R.id.listviewitem_textview_title);
        mTextViewDateStart = view.findViewById(R.id.listviewitem_textview_dateStart);
        mTextViewTimeStart = view.findViewById(R.id.listviewitem_textview_timeStart);
        mTextViewDateEnd = view.findViewById(R.id.listviewitem_textview_dateEnd);
        mTextViewTimeEnd = view.findViewById(R.id.listviewitem_textview_timeEnd);

        mButtonDeleteEvent = view.findViewById(R.id.buttonDeleteEvent);

        mFabCreateNew = activity.findViewById(R.id.fab);

        /*View rootView = inflater.inflate(R.layout.menu_alina_und_mona, null);
        mNavigationView = rootView.findViewById(R.id.nav_view);*/
    }

    //getter to access Views
    public ListView getListView(){return mlistView;}
    public FloatingActionButton getFabCreateNew() {return mFabCreateNew;}
    public ImageButton getButtonDeleteEvent(){return mButtonDeleteEvent;}
    public NavigationView getNavigationView(){return mNavigationView;}
    public ImageButton getButtonMenu(){return mButtonMenu;}

    public TextView getTextViewTitle(){return mTextViewTitle;}
    public TextView getTextViewDateStart(){return mTextViewDateStart;}
    public TextView getTextViewTimeStart(){return mTextViewTimeStart;}
    public TextView getTextViewDateEnd(){return mTextViewDateEnd;}
    public TextView getTextViewTimeEnd(){return mTextViewTimeEnd;}


    //methods to change View attributes




}
