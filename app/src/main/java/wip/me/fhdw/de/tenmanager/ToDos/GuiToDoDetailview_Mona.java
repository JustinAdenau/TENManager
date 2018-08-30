package wip.me.fhdw.de.tenmanager.ToDos;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.view.ViewStub;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import wip.me.fhdw.de.tenmanager.R;

public class GuiToDoDetailview_Mona {

    private EditText mTodoDetailviewTitle;
    private ListView mListView;
    private TextView mTodoDetailviewTextviewStatus;
    private Button mTodoDetailviewButtonDuedate;
    private EditText mTodoDetailviewEditTextNew;
    private Button mTodoDetailviewButtonNew;

    private ViewStub stub;
    private View inflated;

    private FloatingActionButton mFabSave;
    private NavigationView mNavigationView;

    public GuiToDoDetailview_Mona(InitToDoDetailview_Mona activity){
        activity.setContentView(R.layout.menu_alina_und_mona);
        stub = (ViewStub) activity.findViewById(R.id.viewStub);
        stub.setLayoutResource(R.layout.tododetailview_mona);
        inflated = stub.inflate();

        mTodoDetailviewTitle = activity.findViewById(R.id.todotitle);
        mListView = activity.findViewById(R.id.listview_todo_detailview);
        mTodoDetailviewTextviewStatus = activity.findViewById(R.id.tododetailviewStatus);
        mTodoDetailviewButtonDuedate = activity.findViewById(R.id.todoDetailviewButtonDueDate);
        mTodoDetailviewEditTextNew = activity.findViewById(R.id.edittext_newTodo);
        mTodoDetailviewButtonNew = activity.findViewById(R.id.button_newTodo);

        mFabSave = activity.findViewById(R.id.fab);
        //mFabSave.setId(R.id.fabSave);
        mFabSave.setImageResource(android.R.drawable.ic_menu_save);
        mNavigationView = activity.findViewById(R.id.nav_view);
    }



    public EditText getTodoDetailviewTitle() {
        return mTodoDetailviewTitle;
    }

    public void setTodoDetailviewTitle(EditText todoDetailviewTitle) {
        this.mTodoDetailviewTitle = todoDetailviewTitle;
    }

    public ListView getListView(){return mListView;}


    public TextView getTodoDetailviewTextviewStatus() {
        return mTodoDetailviewTextviewStatus;
    }

    public void setTodoDetailviewStatus(TextView todoDetailviewTextviewStatus) {
        this.mTodoDetailviewTextviewStatus = todoDetailviewTextviewStatus;
    }

    public Button getTodoDetailviewButtonDuedate() {
        return mTodoDetailviewButtonDuedate;
    }

    public void setTodoDetailviewDuedate(Button todoDetailviewDuedate) {
        this.mTodoDetailviewButtonDuedate = todoDetailviewDuedate;
    }

    public EditText getTodoEdittextNew(){return mTodoDetailviewEditTextNew;}

    public Button getTodoButtonNew(){return mTodoDetailviewButtonNew;}


    public FloatingActionButton getFabSave() {
        return mFabSave;
    }

    public NavigationView getNavigationView(){return mNavigationView;}
}
