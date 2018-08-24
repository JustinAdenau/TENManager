package wip.me.fhdw.de.tenmanager.ToDos;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import wip.me.fhdw.de.tenmanager.R;

public class ToDoAdapter_Mona extends BaseAdapter{

        private Context mContext;
        private List<ToDoOverview_Mona> mToDoList;
        private ApplicationLogicToDoOverview_Mona mApplicationLogic;

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

        public void setApplicationLogic(ApplicationLogicToDoOverview_Mona applicationLogic){mApplicationLogic = applicationLogic;}

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
            TextView textViewNoteTitle = view.findViewById(R.id.listviewitem_textview_title_todo);
            CheckBox checkbox1 = view.findViewById(R.id.todoCheckBox1);
            CheckBox checkbox2 = view.findViewById(R.id.todoCheckBox);

            String content = mToDoList.get(position).getContent();
            List<String> checkboxList = new ArrayList<>();
            int startindex = 0;
            for(int i=0; i< content.length(); i++)
            {
                if(content.charAt(i) == ',')
                {
                    checkboxList.add(content.substring(startindex, i));
                    startindex = i+1;
                }
            }

            textViewNoteTitle.setText(mToDoList.get(position).getTitle());
            if(!checkboxList.isEmpty())checkbox1.setText(checkboxList.get(0));
            if(checkboxList.size()>=2){checkbox2.setText(checkboxList.get(1));}


            view.setTag(mToDoList.get(position).getId());
            return view;
        }
    }
