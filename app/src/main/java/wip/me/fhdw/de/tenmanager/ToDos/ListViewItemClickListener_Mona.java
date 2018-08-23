package wip.me.fhdw.de.tenmanager.ToDos;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import wip.me.fhdw.de.tenmanager.R;

public class ListViewItemClickListener_Mona implements ListView.OnItemClickListener{
    ApplicationLogicToDoOverview_Mona mApplicationLogic;

    public ListViewItemClickListener_Mona(ApplicationLogicToDoOverview_Mona applicationLogic)
    {
        mApplicationLogic = applicationLogic;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l)
    {
        mApplicationLogic.onListItemClicked(position);
    }
}
