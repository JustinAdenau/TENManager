package wip.me.fhdw.de.tenmanager.ToDos;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewStub;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import wip.me.fhdw.de.tenmanager.R;

public class GuiToDoOverview_Mona {

    private TextView mTitle;
    private ImageButton mButtonDelete;
    private CheckBox mCheckbox1;
    private CheckBox mCheckbox2;
    private TextView mStatus;
    private TextView mDueDate;

    private View mInflated;
    private ViewStub mStub;
    private ListView mListView;

    private FloatingActionButton mFabCreateNew;
    private NavigationView mNavigationView;

    public GuiToDoOverview_Mona(InitToDoOverview_Mona activity){
        activity.setContentView(R.layout.menu_alina_und_mona);
        mStub = (ViewStub) activity.findViewById(R.id.viewStub);
        mStub.setLayoutResource(R.layout.todooverview_mona);
        mInflated = mStub.inflate();

        mListView = activity.findViewById(android.R.id.list);

        LayoutInflater inflater = LayoutInflater.from(activity.getApplicationContext());
        View view = inflater.inflate(R.layout.list_item_todooverview_mona, null);

        mTitle = view.findViewById(R.id.listviewitem_textview_title_todo);
        mButtonDelete = view.findViewById(R.id.buttonDeleteToDo);
        mCheckbox1 = view.findViewById(R.id.todoCheckBox1);
        mCheckbox2 = view.findViewById(R.id.todoCheckBox);
        mStatus = view.findViewById(R.id.todoStatus);
        mDueDate = view.findViewById(R.id.todo_duedate);

        mFabCreateNew = activity.findViewById(R.id.fab);

        mNavigationView = activity.findViewById(R.id.nav_view);
    }

    public ListView getListView(){return mListView;}
    public FloatingActionButton getFabCreateNew() {return mFabCreateNew;}
    public NavigationView getNavigationView(){return mNavigationView;}

    public TextView getTitle() {
        return mTitle;
    }

    public void setTitle(EditText mTitle) {
        this.mTitle = mTitle;
    }

    public ImageButton getButtonDelete() {
        return mButtonDelete;
    }

    public void setButtonDelete(ImageButton mImButton) {
        this.mButtonDelete = mImButton;
    }

    public CheckBox getCheckbox1() {
        return mCheckbox1;
    }

    public void setCheckbox1(CheckBox mCheckbox1) {
        this.mCheckbox1 = mCheckbox1;
    }

    public CheckBox getCheckbox2() {
        return mCheckbox2;
    }

    public void setCheckbox2(CheckBox mCheckbox2) {
        this.mCheckbox2 = mCheckbox2;
    }

    public TextView getStatus() {
        return mStatus;
    }

    public void setStatus(TextView mStatus) {
        this.mStatus = mStatus;
    }

    public TextView getDueDate() {
        return mDueDate;
    }

    public void setDueDate(TextView mDueDate) {
        this.mDueDate = mDueDate;
    }

    public FloatingActionButton getFabSaved(){return mFabCreateNew;}
}

