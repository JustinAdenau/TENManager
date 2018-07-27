package wip.me.fhdw.de.tenmanager;

import android.app.Activity;
import android.os.Bundle;


public class InitEventsDetailView_Sebastian extends Activity{

    private static final String TAG = "InitEventsDetailView_Sebastian";

    private DatepickerEventsDetailView_Sebastian datepicker;
    private TimepickerEventsDetailView_Sebastian timepicker;
    private GuiEventsDetailView_Sebastian mGui;
    private ApplicationLogicEventsDetailView_Sebastian mApplicationLogic;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initGui();
        initDatepicker();
        initTimepicker();

    }



    private void initGui(){
        mGui = new GuiEventsDetailView_Sebastian(this);
    }

    private void initDatepicker(){
        datepicker = new DatepickerEventsDetailView_Sebastian(mGui);
        datepicker.buildDatepicker();
        datepicker.setDateToButton();
    }

    private void initTimepicker(){
        timepicker = new TimepickerEventsDetailView_Sebastian(mGui);
        timepicker.bulidTimepicker();
       // timepicker.setTimeToButton();
    }



}
