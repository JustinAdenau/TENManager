package wip.me.fhdw.de.tenmanager.Notes;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import wip.me.fhdw.de.tenmanager.R;

public class ListViewItemClickListener_Julius implements ListView.OnItemClickListener{
    ApplicationLogicNoteOverview_Julius mApplicationLogic;

    public ListViewItemClickListener_Julius(ApplicationLogicNoteOverview_Julius applicationLogic)
    {
        mApplicationLogic = applicationLogic;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l)
    {
        mApplicationLogic.onListItemClicked(position);
    }
}
