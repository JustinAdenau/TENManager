package wip.me.fhdw.de.tenmanager.Notes;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.TextView;

import wip.me.fhdw.de.tenmanager.AppDatabase;
import wip.me.fhdw.de.tenmanager.Constants;
import wip.me.fhdw.de.tenmanager.R;

public class InitNoteDetailView_Alina extends AppCompatActivity{


    private static final String TAG = "InitNoteDetailView_Alina";


    private GuiNoteDetailView_Alina mGui;
    private ApplicationLogicNoteDetailView_Alina mApplicationLogic;
    private NoteData_Julius mData;
    private AppDatabase mDb;

    private Intent mIntent;

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
        mApplicationLogic = new ApplicationLogicNoteDetailView_Alina(mData, mGui);
    }

    public void initToolbar(){
        Toolbar toolbar = findViewById(R.id.toolbar);
        //getSupportActionBar().hide();
        TextView toolbarTextview = toolbar.findViewById(R.id.toolbar_textview);
        toolbarTextview.setText("Note");
    }


    @Override
    protected void onSaveInstanceState (Bundle outState) {
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
