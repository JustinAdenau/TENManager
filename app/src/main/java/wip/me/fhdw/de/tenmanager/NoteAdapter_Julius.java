package wip.me.fhdw.de.tenmanager;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class NoteAdapter_Julius extends BaseAdapter{

    private Context mContext;
    private List<Note_Julius> mNoteList;

    public NoteAdapter_Julius(Context context, List<Note_Julius> noteList){
        mContext = context;
        mNoteList = noteList;

    }


    public void setNoteList(List<Note_Julius> noteList){mNoteList=noteList;}

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
    public View getView(int position, View v, ViewGroup viewGroup) {
        View view = View.inflate(mContext, R.layout.list_item_notesoverview, null);
        TextView textViewNoteTitle = view.findViewById(R.id.listviewitem_textview_title);
        TextView textViewNoteContent = view.findViewById(R.id.listviewitem_textview_content);

        textViewNoteTitle.setText(mNoteList.get(position).getNoteTitle());
        textViewNoteContent.setText(mNoteList.get(position).getFirstTwoContentRows());

        view.setTag(mNoteList.get(position).getNoteId());
        return view;
    }
}
