package wip.me.fhdw.de.tenmanager.ToDos;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;

import wip.me.fhdw.de.tenmanager.AppDatabase;
import wip.me.fhdw.de.tenmanager.Constants;
import wip.me.fhdw.de.tenmanager.R;

public class InitToDoDetailview_Mona extends AppCompatActivity {

    private GuiToDoDetailview_Mona mGui;
    private ApplicationLogicToDoDetailview_Mona mApplicationLogic;
    private ToDoData_Mona mData;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initData(savedInstanceState);
        initGui();
        initApplicationLogic();
    }


    private void initApplicationLogic() {
        mApplicationLogic = new ApplicationLogicToDoDetailview_Mona(this, mData, mGui, getApplicationContext());
    }

    private void initGui() {
        mGui = new GuiToDoDetailview_Mona(this);
        initToolbar();
    }

    private void initToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        getSupportActionBar().hide();
        TextView toolbarTextview = toolbar.findViewById(R.id.toolbar_textview);
        toolbarTextview.setText("ToDo");
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
    }

    private void initData(Bundle savedInstanceState) {
        mData = new ToDoData_Mona(savedInstanceState, this);
    }

    @Override
    protected void onSaveInstanceState (Bundle outState) {
        mData.saveDataInBundle(outState);
        super.onSaveInstanceState(outState);

        outState.putString("TodoDuedate", mGui.getTodoDetailviewButtonDuedate().getText().toString());
        outState.putString("TodoContent", mApplicationLogic.buildContentStringFromGui());
        outState.putString("CheckboxActivated", mApplicationLogic.buildCheckboxActivated());
        outState.putBoolean("WithData", mData.getWithData());
    }

    @Override
    public void onRestoreInstanceState(Bundle outState) {
        super.onRestoreInstanceState(outState);
        mApplicationLogic.restoreInstanceState(outState);
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


