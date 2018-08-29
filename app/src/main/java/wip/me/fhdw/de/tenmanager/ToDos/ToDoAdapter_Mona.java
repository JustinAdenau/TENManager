package wip.me.fhdw.de.tenmanager.ToDos;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import wip.me.fhdw.de.tenmanager.R;

public class ToDoAdapter_Mona extends BaseAdapter{

    private Context mContext;
    private List<ToDoOverview_Mona> mToDoList;
    private ApplicationLogicToDoOverview_Mona mApplicationLogic;
    private String mCheckboxActivated;


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

    public void setCheckboxActivated(String checkboxActivated){mCheckboxActivated = checkboxActivated;
        Log.d("LOGTAG", "checkBoxActivated wurde in OverviewAdapter gesetzt: "+mCheckboxActivated+"!!!!!!!!!!!!!!!!!!!!!");}

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
        Log.d("LOGTAG", "position in getView TodoOverviewAdapter: "+position+"!!!!!!!!!!!!!!!!!!");
        View view = android.view.View.inflate(mContext, R.layout.list_item_todooverview_mona, null);
        TextView textViewNoteTitle = view.findViewById(R.id.listviewitem_textview_title_todo);
        TextView textViewDuedate = view.findViewById(R.id.todo_duedate);
        TextView textViewStatus = view.findViewById(R.id.todoStatus);
        CheckBox checkbox1 = view.findViewById(R.id.todoCheckBox1);
        CheckBox checkbox2 = view.findViewById(R.id.todoCheckBox);
        ImageButton buttonDeleteTodo = view.findViewById(R.id.buttonDeleteToDo);

        buttonDeleteTodo.setOnClickListener(new ButtonDeleteToDoClickListener_Mona(mApplicationLogic));

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
        if(mToDoList != null && mToDoList.size()>0 && mToDoList.get(position).getCheckboxActivated() != null)
        {
            Log.d("LOGTAG", "checkboxAcivated: "+mToDoList.get(position).getCheckboxActivated()+"!!!!!!!!!!!!!!!");
            Log.d("LOGTAG", "position: "+position+"!!!!!!!!!!!!!!!");
            if(mToDoList.get(position).getCheckboxActivated().length() >1 && mToDoList.get(position).getCheckboxActivated().substring(0 ,1).equals("1"))
            {
                checkbox1.setChecked(true);
            }
            if( mToDoList.get(position).getCheckboxActivated().length() >2 && mToDoList.get(position).getCheckboxActivated().substring(1,2).equals("1"))
            {
                checkbox2.setChecked(true);
            }
        }
        textViewDuedate.setText(mToDoList.get(position).getDuedate());
        textViewStatus.setText(String.valueOf(mToDoList.get(position).getStatus())+"/100%");

        view.setTag(mToDoList.get(position).getId());
        return view;
    }
}