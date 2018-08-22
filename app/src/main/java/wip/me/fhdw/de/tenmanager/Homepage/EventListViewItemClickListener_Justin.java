package wip.me.fhdw.de.tenmanager.Homepage;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class EventListViewItemClickListener_Justin implements ListView.OnItemClickListener{
    ApplicationLogicHomepage_Justin mApplicationLogic;

    public EventListViewItemClickListener_Justin(ApplicationLogicHomepage_Justin applicationLogic)
    {
        mApplicationLogic = applicationLogic;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l)
    {
        mApplicationLogic.onEventListItemClicked(position);
    }
}
