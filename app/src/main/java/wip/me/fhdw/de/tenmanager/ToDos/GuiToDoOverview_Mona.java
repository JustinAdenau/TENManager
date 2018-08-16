package wip.me.fhdw.de.tenmanager.ToDos;

import android.support.design.widget.FloatingActionButton;
import android.widget.ListView;

import wip.me.fhdw.de.tenmanager.R;

public class GuiToDoOverview_Mona {

    private ListView mListView;

    private FloatingActionButton mFabCreateNew;

    public GuiToDoOverview_Mona(InitToDoOverview_Mona activity) {
        activity.setContentView(R.layout.todooverview_mona);
        mListView = activity.findViewById(R.id.todooverviewListview);

        mFabCreateNew = activity.findViewById(R.id.fabtodooverview);
    }

    public FloatingActionButton getFabCreateNew() {return mFabCreateNew;}
}
