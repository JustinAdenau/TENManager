package wip.me.fhdw.de.tenmanager;

import android.app.AlertDialog;
import android.app.TimePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.TimePicker;

import java.util.Calendar;



public class TimepickerEventsDetailView_Sebastian {

    private static final String TAG = "Timepicker_Sebastian";

    private GuiEventsDetailView_Sebastian mGui;
    private TimePickerDialog.OnTimeSetListener mTimeSetListener;

    public TimepickerEventsDetailView_Sebastian(GuiEventsDetailView_Sebastian gui){
        mGui = gui;
    }

//todo
    public void bulidTimepicker(){
        mGui.getButtonTime().setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Calendar cal = Calendar.getInstance();
                int hour = cal.get(Calendar.HOUR_OF_DAY);
                int minute =cal.get(Calendar.MINUTE);

                TimePickerDialog dialog = new TimePickerDialog(

                       view.getContext(), AlertDialog.THEME_HOLO_DARK, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hour, int minute) {
                        mGui.getButtonTime().setText(String.format("%02d:%02d", hour, minute));
                    }
                }
                        , hour, minute, true);

                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();




            }
        });
    }

//todo onTimeSet aus bulidTimepicker auslagern
    public void setTimeToButton() {

    }

}
