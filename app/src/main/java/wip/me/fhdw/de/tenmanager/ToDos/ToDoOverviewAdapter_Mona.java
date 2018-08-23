package wip.me.fhdw.de.tenmanager.ToDos;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import wip.me.fhdw.de.tenmanager.R;

public class ToDoOverviewAdapter_Mona extends BaseAdapter {

    private Context mContext;
    private List<ToDoOverview_Mona> mToDoList;
    private ApplicationLogicToDoOverview_Mona mApplicationLogic;


    public ToDoOverviewAdapter_Mona(Context context) {

        this.mContext = context;
    }

    public void setToDoList(List<ToDoOverview_Mona> toDoList){mToDoList = toDoList;}

    public void setApplicationLogic(ApplicationLogicToDoOverview_Mona applicationLogic){mApplicationLogic = applicationLogic;}



    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    public List<ToDoOverview_Mona> getToDoList(){return mToDoList;}

    @Override
    public View getView(int position, View v, ViewGroup viewGroup) {
        View view = View.inflate(mContext, R.layout.list_item_todooverview_mona, null);
        EditText editTextToDoTitle = view.findViewById(R.id.todotitle);
        CheckBox checkBox1 = view.findViewById(R.id.todoCheckBox1);
        CheckBox checkBox2 = view.findViewById(R.id.todoCheckBox);
        TextView textViewToDoStatus = view.findViewById(R.id.todoStatus);
        TextView textViewToDoDuedate = view.findViewById(R.id.todo_duedate);
        //ImageButton buttonDeleteToDo = view.findViewById();
        //buttonDeleteToDo.setOnClickListener(new ButtonDeleteToDoClickListener_Mona(mApplicationLogic));

        editTextToDoTitle.setText(mToDoList.get(position).getTitle());
        String content = mToDoList.get(position).getContent();
        List<String> contents = new ArrayList<>();
        int startindex = 0;
        for(int i=0; i<=content.length(); i++)
        {
            if(content.charAt(i)==',')
            {
                contents.add(content.substring(startindex, i));
                startindex = i;
            }
        }
        if(contents.size()>=2 )
        {
            checkBox1.setText(contents.get(0));
            checkBox2.setText(contents.get(1));

        }
        else  checkBox1.setText(contents.get(0));

        textViewToDoStatus.setText(mToDoList.get(position).getStatus());
        textViewToDoDuedate.setText(mToDoList.get(position).getDuedate());

        return null;
    }
}
