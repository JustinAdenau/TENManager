package wip.me.fhdw.de.tenmanager.Notes;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import wip.me.fhdw.de.tenmanager.AppDatabase;
import wip.me.fhdw.de.tenmanager.Constants;
import wip.me.fhdw.de.tenmanager.R;

public class InitNoteDetailView_Alina extends AppCompatActivity{
    //Variablen Deklaration & Instanziierung


    private static final String TAG = "InitNoteDetailView_Alina";


    private GuiNoteDetailView_Alina mGui;
    private ApplicationLogicNoteDetailView_Alina mApplicationLogic;
    private NoteData_Julius mData;
    private AppDatabase mDb;
    private Intent mIntent;
    private ImageView imageView;


    //todo ApplicationLogic inizialisieren

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mIntent = this.getIntent();
        initData(savedInstanceState);
        initGui();
        initApplicationLogic(mIntent);
        //initDb();
    }

    private void initGui(){
        mGui = new GuiNoteDetailView_Alina(this);
        initToolbar();
    }
    public void initData(Bundle savedInstanceState)
    {
        mData = new NoteData_Julius(savedInstanceState, this);
    }


    private void initApplicationLogic(Intent intent){
        mApplicationLogic = new ApplicationLogicNoteDetailView_Alina(this, mData, mGui);
    }

    public void initToolbar(){
        Toolbar toolbar = findViewById(R.id.toolbar);
        getSupportActionBar().hide();
        TextView toolbarTextview = toolbar.findViewById(R.id.toolbar_textview);
        toolbarTextview.setText("Note");
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer);
        if(drawer == null);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
    }


    @Override
    protected void onSaveInstanceState (Bundle outState) {
        mData.saveDataInBundle(outState);
        super.onSaveInstanceState(outState);
        outState.putString("NoteTitel", mGui.getEditTextTitle().getText().toString());
        outState.putString("NoteContent", mGui.getEditTextContent().getText().toString());

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
