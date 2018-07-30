package wip.me.fhdw.de.tenmanager;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class ListViewItemClickListener_Lena implements ListView.OnItemClickListener {

    ApplicationLogicEventsOverview_Lena mApplicationLogic;

    public ListViewItemClickListener_Lena(ApplicationLogicEventsOverview_Lena applicationLogic)
    {
        mApplicationLogic = applicationLogic;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        mApplicationLogic.onListItemClicked();
    }
}
