package wip.me.fhdw.de.tenmanager;

import android.app.Activity;
import android.os.Bundle;


public class InitEventsDetailView_Sebastian extends Activity{

    private static final String TAG = "InitEventsDetailView_Sebastian";


    private GuiEventsDetailView_Sebastian mGui;
    private ApplicationLogicEventsDetailView_Sebastian mApplicationLogic;

    //todo ApplicationLogic inizialisieren
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initGui();
        initApplicationLogic();
    }


    private void initGui(){
        mGui = new GuiEventsDetailView_Sebastian(this);
    }


    private void initApplicationLogic(){
        mApplicationLogic = new ApplicationLogicEventsDetailView_Sebastian(
               //todo mDate,
                mGui
        );
    }

}
