package wip.me.fhdw.de.tenmanager.Notes;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewStub;
import android.widget.ListView;
import android.widget.TextView;

import wip.me.fhdw.de.tenmanager.R;

public class GuiNoteOverview_Julius {

    private ListView mListView;
    private ViewStub mStub;
    private View mInflated;
    private TextView mTitle;
    private TextView mContent;

    private FloatingActionButton mFabCreateNew;
    private NavigationView mNavigationView;

    public GuiNoteOverview_Julius(InitNoteOverview_Julius activity){
        activity.setContentView(R.layout.menu_alina_und_mona);
        mStub = (ViewStub) activity.findViewById(R.id.viewStub);
        mStub.setLayoutResource(R.layout.notesoverview_julius);
        mInflated = mStub.inflate();

        mListView = activity.findViewById(android.R.id.list);

        LayoutInflater inflater = LayoutInflater.from(activity.getApplicationContext());
        View view = inflater.inflate(R.layout.list_item_notesoverview, null);

        mTitle = view.findViewById(R.id.listviewitem_textview_event_title);
        mContent = view.findViewById(R.id.listviewitem_textview_content);

        mFabCreateNew = activity.findViewById(R.id.fab);

        mNavigationView = activity.findViewById(R.id.nav_view);
    }

    public ListView getListView(){return mListView;}
    public FloatingActionButton getFabCreateNew() {return mFabCreateNew;}
    public NavigationView getNavigationView(){return mNavigationView;}

    public TextView getTextViewTitle(){return mTitle;}
    public TextView getTextViewContent(){return mContent;}
}

