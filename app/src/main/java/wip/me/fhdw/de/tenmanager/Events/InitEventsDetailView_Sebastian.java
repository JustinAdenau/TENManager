package wip.me.fhdw.de.tenmanager.Events;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.TextView;

import wip.me.fhdw.de.tenmanager.AppDatabase;
import wip.me.fhdw.de.tenmanager.Constants;
import wip.me.fhdw.de.tenmanager.R;


public class InitEventsDetailView_Sebastian extends AppCompatActivity {

    private static final String TAG = "InitEventsDetailView_Sebastian";


    private GuiEventsDetailView_Sebastian mGui;
    private ApplicationLogicEventsDetailView_Sebastian mApplicationLogic;
    private EventData_Lena mData;
    private AppDatabase mDb;

    private Intent mIntent;

    //todo ApplicationLogic inizialisieren
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mIntent = this.getIntent();
        Log.d("LOGTAG", "onCreate InitEventsDetailView_Sebastian. title: "+ mIntent.getBundleExtra(Constants.KEYEVENTTITLE));
        initData(savedInstanceState);
        initGui();
        initApplicationLogic(mIntent);
        //initDb();

    }


    private void initGui(){
        mGui = new GuiEventsDetailView_Sebastian(this);
        initToolbar();
    }
    public void initData(Bundle savedInstanceState)
    {
        mData = new EventData_Lena(savedInstanceState, this);
    }


    private void initApplicationLogic(Intent intent){
        mApplicationLogic = new ApplicationLogicEventsDetailView_Sebastian(mData, mGui);
    }

    public void initToolbar(){Toolbar toolbar = findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        TextView toolbarTextview = toolbar.findViewById(R.id.toolbar_textview);
        toolbarTextview.setText("Event");
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
