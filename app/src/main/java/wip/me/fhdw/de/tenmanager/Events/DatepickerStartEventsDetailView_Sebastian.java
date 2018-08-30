package wip.me.fhdw.de.tenmanager.Events;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;



public class DatepickerStartEventsDetailView_Sebastian {


    private static final String TAG = "Datepicker_Sebastian";

    private int mDayStart;
    private int mMonthStart;
    private int mYearStart;

    private long mDiffDays;
    private Calendar mStartDate;
    private Calendar mNewStartDate;
    private Calendar mEndDate;


    private GuiEventsDetailView_Sebastian mGui;
    private DatePickerDialog.OnDateSetListener mDateSetListener;


    public DatepickerStartEventsDetailView_Sebastian(GuiEventsDetailView_Sebastian gui){
        mGui = gui;
    }

    //date picker to set event start date
    public void buildDateStartpicker() {
        mGui.getButtonDateStart().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mDayStart = Integer.parseInt(mGui.getButtonDateStart().getText().toString().substring(0,2));
                mMonthStart = Integer.parseInt(mGui.getButtonDateStart().getText().toString().substring(3, 5))-1;
                mYearStart = Integer.parseInt(mGui.getButtonDateStart().getText().toString().substring(6,10));

                int dayEnd = Integer.parseInt(mGui.getButtonDateEnd().getText().toString().substring(0,2));
                int monthEnd = Integer.parseInt(mGui.getButtonDateEnd().getText().toString().substring(3, 5))-1;
                int yearEnd = Integer.parseInt(mGui.getButtonDateEnd().getText().toString().substring(6,10));


                mStartDate = Calendar.getInstance();
                mStartDate.set(Calendar.DAY_OF_MONTH, mDayStart);
                mStartDate.set(Calendar.MONTH, mMonthStart);
                mStartDate.set(Calendar.YEAR, mYearStart);

                mEndDate = Calendar.getInstance();
                mEndDate.set(Calendar.DAY_OF_MONTH, dayEnd);
                mEndDate.set(Calendar.MONTH, monthEnd);
                mEndDate.set(Calendar.YEAR, yearEnd);

                long diffMillis = mEndDate.getTimeInMillis() - mStartDate.getTimeInMillis();
                mDiffDays = diffMillis /(24*60*60*1000);

                Log.d(TAG, "Datediff:" +mDiffDays);

                DatePickerDialog dialog = new DatePickerDialog(
                        view.getContext(),
                        android.R.style.Theme_Holo_Dialog_MinWidth,
                        mDateSetListener,
                        mYearStart, mMonthStart, mDayStart);

                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();

            }
        });

    }

    //set chosen date to button
    public void setDateStartToButton() {
        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;

                mGui.getButtonDateStart().setText(String.format("%02d.%02d.%04d", day, month, year));
                int diff = (int)mDiffDays;
                SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

                mNewStartDate = Calendar.getInstance();
                mNewStartDate.set(Calendar.DAY_OF_MONTH, day);
                mNewStartDate.set(Calendar.MONTH, month-1);
                mNewStartDate.set(Calendar.YEAR, year);

                mNewStartDate.add(Calendar.DATE, diff);
                Calendar newEndDate = mNewStartDate;
                Log.d("LOGTAG", "newEndDate:" +sdf.format(newEndDate.getTime()));
                mGui.getButtonDateEnd().setText(sdf.format(newEndDate.getTime()));

            }
        };
    }

}
