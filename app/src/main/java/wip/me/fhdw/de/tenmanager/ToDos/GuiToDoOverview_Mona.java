package wip.me.fhdw.de.tenmanager.ToDos;

import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewStub;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import wip.me.fhdw.de.tenmanager.R;

public class GuiToDoOverview_Mona {

    private ListView mListView;
    private ViewStub mStub;
    private View mInflated;
    private EditText mEditTextTitle;
    private CheckBox mCheckbox1;
    private CheckBox mCheckbox2;
    private CheckBox mCheckbox3;
    private TextView mTextViewStatus;
    private TextView mTextViewDuedate;

    private FloatingActionButton mFabCreateNew;

    public GuiToDoOverview_Mona(InitToDoOverview_Mona activity) {
        activity.setContentView(R.layout.activity_main);

        mStub = (ViewStub) activity.findViewById(R.id.viewStub);
        mStub.setLayoutResource(R.layout.todooverview_mona);
        mInflated = mStub.inflate();

        mListView = activity.findViewById(R.id.todooverviewListview);

        LayoutInflater inflater = LayoutInflater.from(activity.getApplicationContext());
        View view = inflater.inflate(R.layout.listview_item, null);

        mEditTextTitle = view.findViewById(R.id.todotitle);
        mCheckbox1 = view.findViewById(R.id.todoCheckBox1);
        mCheckbox2 = view.findViewById(R.id.todoCheckBox2);
        mCheckbox3 = view.findViewById(R.id.todocCheckBox3);
        mTextViewStatus = view.findViewById(R.id.todoStatus);
        mTextViewDuedate = view.findViewById(R.id.todoDuedate);

        mFabCreateNew = activity.findViewById(R.id.fab);
    }

    public FloatingActionButton getFabCreateNew() {return mFabCreateNew;}
    public ListView getListView(){return mListView;}
    public EditText getEditTextTitle(){return mEditTextTitle;}
    public CheckBox getCheckbox1(){return mCheckbox1;}
    public CheckBox getCheckBox2(){return mCheckbox2;}
    public CheckBox getCheckBox3(){return mCheckbox3;}
    public TextView getTextViewStatus(){return mTextViewStatus;}
    public TextView getTextViewDuedate(){return mTextViewDuedate;}

}
