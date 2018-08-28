package wip.me.fhdw.de.tenmanager.Homepage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.List;

import wip.me.fhdw.de.tenmanager.R;
import wip.me.fhdw.de.tenmanager.ToDos.ToDoOverview_Mona;

public class ToDoAdapter_Justin extends BaseAdapter{
    private Context mContext;
    private List<ToDoOverview_Mona> mTodoList;
    private ApplicationLogicHomepage_Justin mApplicationLogic;


    public ToDoAdapter_Justin(Context context)
    {
        this.mContext=context;
    }

    public void setToDoList(List<ToDoOverview_Mona> todoList){mTodoList=todoList;}

    public void setApplicationLogic(ApplicationLogicHomepage_Justin applicationLogic){mApplicationLogic=applicationLogic;}

    @Override
    public int getCount() {
        return mTodoList.size();
    }

    @Override
    public Object getItem(int position) {
        return mTodoList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public List<ToDoOverview_Mona> getTodoList(){return mTodoList;}

    @Override
    public View getView(int position, View v, ViewGroup viewGroup) {
        View view = View.inflate(mContext, R.layout.list_item_homepage_todo, null);

        TextView textviewHomepageTodoitemTitle = view.findViewById(R.id.homepage_todo_title);
        TextView textviewHomepageTodoitemDate = view.findViewById(R.id.homepage_todo_date);

        ImageButton homepage_buttonDeleteTodo = view.findViewById(R.id.homepage_buttonDeleteTodo);

        //eigener Listener??
        homepage_buttonDeleteTodo.setOnClickListener(new ButtonDeleteToDoClickListener_Justin(mApplicationLogic));

        //aus Datenklasse
        textviewHomepageTodoitemTitle.setText(mTodoList.get(position).getTitle());
        textviewHomepageTodoitemDate.setText(mTodoList.get(position).getDuedate());

        view.setTag(mTodoList.get(position).getId());
        return view;
    }
}
