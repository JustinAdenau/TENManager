package wip.me.fhdw.de.tenmanager.Events;

import android.app.AlertDialog;
import android.app.TimePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.view.View;
import android.widget.TimePicker;


public class TimepickerStartEventsDetailView_Sebastian {

    private static final String TAG = "Timepicker_Sebastian";

    private GuiEventsDetailView_Sebastian mGui;
    private TimePickerDialog.OnTimeSetListener mTimeSetListener;
    private ReminderSpinnerEventsDetailView_Sebastian mReminderSpinner;

    private int mHourStart;
    private int mMinuteStart;

    public TimepickerStartEventsDetailView_Sebastian(GuiEventsDetailView_Sebastian gui, ReminderSpinnerEventsDetailView_Sebastian reminderSpinner){
        mGui = gui;
        mReminderSpinner = reminderSpinner;
    }

    //time picker to set event start time
    public void bulidTimeStartpicker(){
        mGui.getButtonTimeStart().setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                mHourStart = Integer.parseInt(mGui.getButtonTimeStart().getText().toString().substring(0, 2));
                mMinuteStart = Integer.parseInt(mGui.getButtonTimeStart().getText().toString().substring(3, 5));

                TimePickerDialog dialog = new TimePickerDialog(

                       view.getContext(), AlertDialog.THEME_HOLO_DARK, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hour, int minute) {
                        mGui.getButtonTimeStart().setText(String.format("%02d:%02d", hour, minute));
                    }
                }
                        , mHourStart, mMinuteStart, true);

                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
                mReminderSpinner.buildReminderSpinner1();
                mReminderSpinner.buildReminderSpinner2();
                mReminderSpinner.buildReminderSpinner3();
            }
        });
    }
}
