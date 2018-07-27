package wip.me.fhdw.de.tenmanager;

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

                        //Variante 1
                  /*      view.getContext(),
                        android.R.style.TextAppearance_Theme,
                        hour, minute
                );*/


                       //Variante 2
                       view.getContext(), new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hour, int minute) {
                        String time = hour + ":" + minute;
                        mGui.getButtonTime().setText(time);
                    }
                }
                        , hour, minute, true);

                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();




            }
        });
    }

//todo
    public void setTimeToButton() {

    }

}
