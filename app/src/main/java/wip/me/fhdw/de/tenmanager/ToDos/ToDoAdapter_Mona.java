package wip.me.fhdw.de.tenmanager.ToDos;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import wip.me.fhdw.de.tenmanager.R;

public class ToDoAdapter_Mona extends BaseAdapter{

        private Context mContext;
        private List<ToDoOverview_Mona> mToDoList;

    public ToDoAdapter_Mona(Context context, List<ToDoOverview_Mona> todoList)
        {
            mContext = context;
            mToDoList = todoList;

        }

    public ToDoAdapter_Mona(Context context)
        {
            this.mContext=context;
        }

        public void setToDoList(List<ToDoOverview_Mona> todoList){mToDoList=todoList;}

        @Override
        public int getCount() {
            return mToDoList.size();
        }

        @Override
        public Object getItem(int position) {
            return mToDoList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View v, ViewGroup viewGroup)
        {
            View view = android.view.View.inflate(mContext, R.layout.list_item_todooverview_mona, null);
            TextView textViewNoteTitle = view.findViewById(R.id.listviewitem_textview_title);
            TextView textViewNoteContent = view.findViewById(R.id.listviewitem_textview_content);

            textViewNoteTitle.setText(mToDoList.get(position).getTitle());
            textViewNoteContent.setText(mToDoList.get(position).getContent());

            view.setTag(mToDoList.get(position).getId());
            return view;
        }
    }
