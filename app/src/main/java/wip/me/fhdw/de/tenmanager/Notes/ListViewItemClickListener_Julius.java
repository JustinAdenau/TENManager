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
        if(view.getId() == R.id.idRelativeLayoutListItem) Log.d("LOGTAG", "RealtiveLayout wird übergeben" );
        List<String> data = new ArrayList<>();
        TextView textView = view.findViewById(R.id.listviewitem_textview_event_title);
        data.add(textView.getText().toString());
        textView = view.findViewById(R.id.listviewitem_textview_content);
        data.add(textView.getText().toString());


        mApplicationLogic.onListItemClicked(position);
    }
}
