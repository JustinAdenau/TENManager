package wip.me.fhdw.de.tenmanager.ToDos;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TextInputLayout;
import android.view.ViewStub;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import wip.me.fhdw.de.tenmanager.R;

public class GuiToDoDetailview_Mona {

    private EditText mtodotitle;
    private ListView mListView;
    private TextView mtodoDescriptionStatus;
    private TextView mtodoDescriptionDuedate;
    private TextView mtodoDetailviewStatus;
    private EditText mtodoDetailviewDueDate;
    private EditText mtodoEditTextNew;
    private Button mtodoButtonNew;

    private ViewStub stub;
    private View inflated;

    private FloatingActionButton mFabSave;
    private NavigationView mNavigationView;

    public GuiToDoDetailview_Mona(InitToDoDetailview_Mona activity){
        activity.setContentView(R.layout.menu_alina_und_mona);
        stub = (ViewStub) activity.findViewById(R.id.viewStub);
        stub.setLayoutResource(R.layout.tododetailview_mona);
        inflated = stub.inflate();

        mtodotitle = activity.findViewById(R.id.todotitle);
        mListView = activity.findViewById(R.id.listview_todo_detailview);
        mtodoDetailviewStatus = activity.findViewById(R.id.tododetailviewStatus);
        mtodoDetailviewDueDate = activity.findViewById(R.id.todoDetailviewDueDate);
        mtodoEditTextNew = activity.findViewById(R.id.edittext_newTodo);
        mtodoButtonNew = activity.findViewById(R.id.button_newTodo);

        mFabSave = activity.findViewById(R.id.fab);
        //mFabSave.setId(R.id.fabSave);
        mFabSave.setImageResource(android.R.drawable.ic_menu_save);
        mNavigationView = activity.findViewById(R.id.nav_view);
    }



    public EditText getMtodotitle() {
        return mtodotitle;
    }

    public void setMtodotitle(EditText mtodotitle) {
        this.mtodotitle = mtodotitle;
    }

    public ListView getListView(){return mListView;}

    public TextView getMtodoDescriptionStatus() {
        return mtodoDescriptionStatus;
    }

    public void setMtodoDescriptionStatus(TextView mtodoDescriptionStatus) {
        this.mtodoDescriptionStatus = mtodoDescriptionStatus;
    }

    public TextView getMtodoDescriptionDuedate() {
        return mtodoDescriptionDuedate;
    }

    public void setMtodoDescriptionDuedate(TextView mtodoDescriptionDuedate) {
        this.mtodoDescriptionDuedate = mtodoDescriptionDuedate;
    }

    public TextView getMtodoDetailviewStatus() {
        return mtodoDetailviewStatus;
    }

    public void setMtodoDetailviewStatus(TextView mtodoDetailviewStatus) {
        this.mtodoDetailviewStatus = mtodoDetailviewStatus;
    }

    public EditText getMtodoDetailviewDueDate() {
        return mtodoDetailviewDueDate;
    }

    public void setMtodoDetailviewDueDate(EditText mtodoDetailviewDueDate) {
        this.mtodoDetailviewDueDate = mtodoDetailviewDueDate;
    }

    public EditText getTodoEdittextNew(){return mtodoEditTextNew;}

    public Button getTodoButtonNew(){return mtodoButtonNew;}


    public FloatingActionButton getFabSave() {
        return mFabSave;
    }

    public NavigationView getNavigationView(){return mNavigationView;}
}
