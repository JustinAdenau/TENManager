package wip.me.fhdw.de.tenmanager.Notes;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.List;

import wip.me.fhdw.de.tenmanager.Events.ApplicationLogicEventsOverview_Lena;
import wip.me.fhdw.de.tenmanager.Events.ButtonDeleteEventClickListener_Lena;
import wip.me.fhdw.de.tenmanager.R;

public class NoteAdapter_Julius extends BaseAdapter{

    private Context mContext;
    private List<Note_Julius> mNoteList;
    private ApplicationLogicNoteOverview_Julius mApplicationLogic;


    public NoteAdapter_Julius(Context context)
    {
        this.mContext=context;
    }

    public void setNoteList(List<Note_Julius> noteList){mNoteList=noteList;}

    public void setApplicationLogic(ApplicationLogicNoteOverview_Julius applicationLogic){mApplicationLogic=applicationLogic;}

    @Override
    public int getCount() {
        return mNoteList.size();
    }

    @Override
    public Object getItem(int position) {
        return mNoteList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View v, ViewGroup viewGroup)
    {
        View view = View.inflate(mContext, R.layout.list_item_notesoverview, null);
        TextView textViewNoteTitle = view.findViewById(R.id.listviewitem_textview_title);
        TextView textViewNoteContent = view.findViewById(R.id.listviewitem_textview_content);
        ImageButton buttonDeleteNote = view.findViewById(R.id.buttonDeleteNote);

        buttonDeleteNote.setOnClickListener(new ButtonDeleteNoteClickListener_Julius(mApplicationLogic));

        textViewNoteTitle.setText(mNoteList.get(position).getTitle());
        Log.d("LOGTAG", "Content setzen: "+mNoteList.get(position).getContent());
        textViewNoteContent.setText(mNoteList.get(position).getContent());

        view.setTag(mNoteList.get(position).getId());
        return view;
    }
}
