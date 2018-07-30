package wip.me.fhdw.de.tenmanager;

import android.app.Activity;
import android.os.Bundle;


public class InitEventsDetailView_Sebastian extends Activity{

    private static final String TAG = "InitEventsDetailView_Sebastian";

    private DatepickerEventsDetailView_Sebastian datepicker;
    private TimepickerEventsDetailView_Sebastian timepicker;
    private GuiEventsDetailView_Sebastian mGui;
    private ApplicationLogicEventsDetailView_Sebastian mApplicationLogic;

    //todo ApplicationLogic inizialisieren
    //todo init Datepicker und Timepicker und Spanpicker in ApplicationLogic
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initGui();
        initApplicationLogic();
        initCurrentTime();
        initCurrentDate();
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

    private void initApplicationLogic(){
        mApplicationLogic = new ApplicationLogicEventsDetailView_Sebastian(
               //todo mDate,
                mGui
        );
    }

    //todo
    private void initCurrentTime(){

    }

    //todo
    private void initCurrentDate(){

    }


    private void initTimepicker(){
        timepicker = new TimepickerEventsDetailView_Sebastian(mGui);
        timepicker.bulidTimepicker();
        //todo Falls Methode in timepicker geschrieben wird!
       // timepicker.setTimeToButton();
    }

//todo init Spanpicker

}
