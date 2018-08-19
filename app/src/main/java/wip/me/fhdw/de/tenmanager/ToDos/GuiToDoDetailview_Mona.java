package wip.me.fhdw.de.tenmanager.ToDos;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TextInputLayout;
import android.view.ViewStub;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import wip.me.fhdw.de.tenmanager.R;

public class GuiToDoDetailview_Mona {

    private EditText mtodotitle;
    private CheckBox mtodoCheckBox1;
    private CheckBox mtodoCheckBox2;
    private CheckBox mtodoCheckBox3;
    private TextView mtodoDescriptionStatus;
    private TextView mtodoDescriptionDuedate;
    private TextView mtodoDetailviewStatus;
    private TextView mtodoDetailviewDueDate;

    private ViewStub stub;
    private View inflated;

    private FloatingActionButton mFabSave;
    private NavigationView mNavigationView;

    public GuiToDoDetailview_Mona(InitToDoDetailview_Mona activity){
        activity.setContentView(R.layout.menu_alina_und_mona);
        stub = (ViewStub) activity.findViewById(R.id.viewStub);
        stub.setLayoutResource(R.layout.todooverview_mona);
        inflated = stub.inflate();

        mtodotitle = activity.findViewById(R.id.todotitle);
        mtodoCheckBox1 = activity.findViewById(R.id.todoCheckBox1);
        mtodoCheckBox2 = activity.findViewById(R.id.todoCheckBox2);
        mtodoCheckBox3 = activity.findViewById(R.id.todoCheckBox3);
        mtodoDescriptionStatus = activity.findViewById(R.id.todoDescriptionStatus);
        mtodoDescriptionDuedate = activity.findViewById(R.id.todoDescriptionDuedate);
        mtodoDetailviewStatus = activity.findViewById(R.id.todoDescriptionStatus);
        mtodoDetailviewDueDate = activity.findViewById(R.id.todoDetailviewDueDate);

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

    public CheckBox getMtodoCheckBox1() {
        return mtodoCheckBox1;
    }

    public void setMtodoCheckBox1(CheckBox mtodoCheckBox1) {
        this.mtodoCheckBox1 = mtodoCheckBox1;
    }

    public CheckBox getMtodoCheckBox2() {
        return mtodoCheckBox2;
    }

    public void setMtodoCheckBox2(CheckBox mtodoCheckBox2) {
        this.mtodoCheckBox2 = mtodoCheckBox2;
    }

    public CheckBox getMtodoCheckBox3() {
        return mtodoCheckBox3;
    }

    public void setMtodoCheckBox3(CheckBox mtodoCheckBox3) {
        this.mtodoCheckBox3 = mtodoCheckBox3;
    }

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

    public TextView getMtodoDetailviewDueDate() {
        return mtodoDetailviewDueDate;
    }

    public void setMtodoDetailviewDueDate(TextView mtodoDetailviewDueDate) {
        this.mtodoDetailviewDueDate = mtodoDetailviewDueDate;
    }


    public FloatingActionButton getFabSave() {
        return mFabSave;
    }

    public NavigationView getNavigationView(){return mNavigationView;}
}
