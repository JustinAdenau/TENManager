package wip.me.fhdw.de.tenmanager;

import android.app.Activity;
import android.os.Bundle;


public class InitEventsDetailView_Sebastian extends Activity{

    private static final String TAG = "InitEventsDetailView_Sebastian";

    private DatepickerEventsDetailView_Sebastian datepicker;
    private GuiEventsDetailView_Sebastian mGui;
    private ApplicationLogicEventsDetailView_Sebastian mApplicationLogic;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initGui();
        initDatepicker();

    }

    private void initDatepicker(){
        datepicker = new DatepickerEventsDetailView_Sebastian(mGui);
        datepicker.buildDatepicker();
        datepicker.setDateToButton();
    }

    private void initGui(){
        mGui = new GuiEventsDetailView_Sebastian(this);
    }



}
