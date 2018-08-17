package wip.me.fhdw.de.tenmanager.ToDos;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toolbar;

import wip.me.fhdw.de.tenmanager.AppDatabase;
import wip.me.fhdw.de.tenmanager.Constants;
import wip.me.fhdw.de.tenmanager.R;

public class InitToDoDetailview_Mona extends AppCompatActivity {

    private GuiToDoDetailview_Mona mGui;
    private ApplicationLogicToDoDetailview_Mona mApplicationLogic;
    private ToDoData_Mona mData;
    private AppDatabase mDb;

    private Intent mIntent;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mIntent = this.getIntent();
        Log.d("LOGTAG", "onCreate InitEventsDetailView_Sebastian. title: " + mIntent.getBundleExtra(Constants.KEYEVENTTITLE));
        initData(savedInstanceState);
        initGui();
        initApplicationLogic(mIntent);
        initDb();
    }

    private void initDb() {


    }

    private void initApplicationLogic(Intent mIntent) {
        mApplicationLogic = new ApplicationLogicToDoDetailview_Mona(mData, mGui);
    }

    private void initGui() {
        mGui = new GuiToDoDetailview_Mona(this);
        initToolbar();
    }

    private void initToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        TextView toolbarTextview = toolbar.findViewById(R.id.toolbar_textview);
        toolbarTextview.setText("ToDo");
    }

    private void initData(Bundle savedInstanceState) {
        mData = new ToDoData_Mona(savedInstanceState, this);
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        //mData.saveDataInBundle(outState);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // super.onActivityResult(requestCode, resultCode, data);
        mApplicationLogic.onActivityReturned(requestCode, resultCode, data);
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        mApplicationLogic.onBackPressed();
    }
}


