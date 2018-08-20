package wip.me.fhdw.de.tenmanager.Events;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;

import java.util.Calendar;


public class DatepickerEndEventsDetailView_Sebastian {
    private static final String TAG = "Datepicker_Sebastian";

    private int mDayEnd;
    private int mMonthEnd;
    private int mYearEnd;

    private Calendar mEnddate;

    private GuiEventsDetailView_Sebastian mGui;
    private DatePickerDialog.OnDateSetListener mDateSetListener;


    public DatepickerEndEventsDetailView_Sebastian(GuiEventsDetailView_Sebastian gui){
        mGui = gui;
    }


    public void buildDateEndpicker() {
        mGui.getButtonDateEnd().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mEnddate = Calendar.getInstance();

                mDayEnd = Integer.parseInt(mGui.getButtonDateEnd().getText().toString().substring(0,2));
                mMonthEnd = Integer.parseInt(mGui.getButtonDateEnd().getText().toString().substring(3, 5))-1;
                mYearEnd = Integer.parseInt(mGui.getButtonDateEnd().getText().toString().substring(6,10));


                DatePickerDialog dialog = new DatePickerDialog(
                        view.getContext(),
                        android.R.style.Theme_Holo_Dialog_MinWidth,
                        mDateSetListener,
                        mYearEnd, mMonthEnd,mDayEnd);

                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();

            }
        });

    }

    public void setDateEndToButton() {
        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;

                mGui.getButtonDateEnd().setText(String.format("%02d.%02d.%04d", day, month, year));

                mEnddate.set(Calendar.DAY_OF_MONTH, mMonthEnd);
                mEnddate.set(Calendar.MONTH, mMonthEnd);
                mEnddate.set(Calendar.YEAR, mYearEnd);
                Log.d(TAG, "Gespeichert in mEnddate ist jetzt: " + mEnddate.getTime().getTime());

            }
        };
    }

}
