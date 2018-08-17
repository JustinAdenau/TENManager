package wip.me.fhdw.de.tenmanager.ToDos;

import android.support.design.widget.FloatingActionButton;
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

    private EditText mTitle;
    private ImageButton mImButton;
    private CheckBox mCheckbox1;
    private CheckBox mCheckbox2;
    private TextView mStatusText;
    private TextView mDueDateText;
    private TextView mStatus;
    private TextView mDueDate;

    private View mInflated;
    private ViewStub mStub;
    private ListView mListView;

    private FloatingActionButton mFabCreateNew;

    public GuiToDoOverview_Mona(InitToDoOverview_Mona activity){
        activity.setContentView(R.layout.activity_main);
        mStub = (ViewStub) activity.findViewById(R.id.viewStub);
        mStub.setLayoutResource(R.layout.todooverview_mona);
        mInflated = mStub.inflate();

        mListView = activity.findViewById(android.R.id.list);

        LayoutInflater inflater = LayoutInflater.from(activity.getApplicationContext());
        View view = inflater.inflate(R.layout.list_item_notesoverview, null);

        mTitle = view.findViewById(R.id.listviewitem_textview_title);
        mImButton = view.findViewById(R.id.buttonDeleteToDo);
        mCheckbox1 = view.findViewById(R.id.todoCheckBox1);
        mCheckbox2 = view.findViewById(R.id.todoCheckBox2);
        mStatusText = view.findViewById(R.id.todoStatusText);
        mDueDateText = view.findViewById(R.id.todoDuedateText);
        mStatus = view.findViewById(R.id.todoStatus);
        mDueDate = view.findViewById(R.id.todoDuedate);

        mFabCreateNew = activity.findViewById(R.id.fab);
    }

    public ListView getListView(){return mListView;}
    public FloatingActionButton getFabCreateNew() {return mFabCreateNew;}

    public EditText getmTitle() {
        return mTitle;
    }

    public void setmTitle(EditText mTitle) {
        this.mTitle = mTitle;
    }

    public ImageButton getmImButton() {
        return mImButton;
    }

    public void setmImButton(ImageButton mImButton) {
        this.mImButton = mImButton;
    }

    public CheckBox getmCheckbox1() {
        return mCheckbox1;
    }

    public void setmCheckbox1(CheckBox mCheckbox1) {
        this.mCheckbox1 = mCheckbox1;
    }

    public CheckBox getmCheckbox2() {
        return mCheckbox2;
    }

    public void setmCheckbox2(CheckBox mCheckbox2) {
        this.mCheckbox2 = mCheckbox2;
    }

    public TextView getmStatusText() {
        return mStatusText;
    }

    public void setmStatusText(TextView mStatusText) {
        this.mStatusText = mStatusText;
    }

    public TextView getmDueDateText() {
        return mDueDateText;
    }

    public void setmDueDateText(TextView mDueDateText) {
        this.mDueDateText = mDueDateText;
    }

    public TextView getmStatus() {
        return mStatus;
    }

    public void setmStatus(TextView mStatus) {
        this.mStatus = mStatus;
    }

    public TextView getmDueDate() {
        return mDueDate;
    }

    public void setmDueDate(TextView mDueDate) {
        this.mDueDate = mDueDate;
    }

    public FloatingActionButton getFabSaved(){return mFabCreateNew;}
}

