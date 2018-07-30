package wip.me.fhdw.de.tenmanager;

import android.widget.ListView;

import java.util.List;

public class GuiNoteOverview_Julius {

    ListView mListView;

    public GuiNoteOverview_Julius(InitNoteOverview_Julius activity){
        activity.setContentView(R.layout.activity_main);

        mListView = activity.findViewById(android.R.id.list);

    }

    public ListView getListView(){
        return mListView;
    }
}

