package wip.me.fhdw.de.tenmanager;

import android.app.AlertDialog;
import android.app.TimePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.TimePicker;

import java.util.Calendar;

public class TimepickerEndEventsDetailView_Sebastian {

    private static final String TAG = "Timepicker_Sebastian";

    private GuiEventsDetailView_Sebastian mGui;
    private TimePickerDialog.OnTimeSetListener mTimeSetListener;

    private int mHourEnd;
    private int mMinuteEnd;

    public TimepickerEndEventsDetailView_Sebastian(GuiEventsDetailView_Sebastian gui){
        mGui = gui;
    }


    public void buildTimeEndpicker(){
        mGui.getButtonTimeEnd().setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                mHourEnd = Integer.parseInt(mGui.getButtonTimeEnd().getText().toString().substring(0, 2));
                mMinuteEnd = Integer.parseInt(mGui.getButtonTimeEnd().getText().toString().substring(3, 5));

                TimePickerDialog dialog = new TimePickerDialog(

                        view.getContext(), AlertDialog.THEME_HOLO_DARK, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hour, int minute) {
                        mGui.getButtonTimeEnd().setText(String.format("%02d:%02d", mHourEnd, mMinuteEnd));
                    }
                }
                        , mHourEnd, mMinuteEnd, true);

                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });
    }
}
