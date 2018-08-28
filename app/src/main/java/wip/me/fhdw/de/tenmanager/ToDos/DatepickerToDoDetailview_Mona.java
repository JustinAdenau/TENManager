package wip.me.fhdw.de.tenmanager.ToDos;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.DatePicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;


public class DatepickerToDoDetailview_Mona {


    private static final String TAG = "Datepicker_Mona";

    private int mDayStart;
    private int mMonthStart;
    private int mYearStart;

    private Calendar mStartDate;


    private GuiToDoDetailview_Mona mGui;
    private DatePickerDialog.OnDateSetListener mDateSetListener;


    public DatepickerToDoDetailview_Mona(GuiToDoDetailview_Mona gui){
        mGui = gui;
    }


    public void buildDateStartDuedatepicker() {
        mGui.getTodoDetailviewButtonDuedate().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mDayStart = Integer.parseInt(mGui.getTodoDetailviewButtonDuedate().getText().toString().substring(0,2));
                mMonthStart = Integer.parseInt(mGui.getTodoDetailviewButtonDuedate().getText().toString().substring(3, 5))-1;
                mYearStart = Integer.parseInt(mGui.getTodoDetailviewButtonDuedate().getText().toString().substring(6,10));

                mStartDate = Calendar.getInstance();
                mStartDate.set(Calendar.DAY_OF_MONTH, mDayStart);
                mStartDate.set(Calendar.MONTH, mMonthStart);
                mStartDate.set(Calendar.YEAR, mYearStart);

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

    public void setDuedateToButton() {
        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;

                mGui.getTodoDetailviewButtonDuedate().setText(String.format("%02d.%02d.%04d", day, month, year));
                SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

                Calendar newStartDate = Calendar.getInstance();
                newStartDate.set(Calendar.DAY_OF_MONTH, day);
                newStartDate.set(Calendar.MONTH, month-1);
                newStartDate.set(Calendar.YEAR, year);
            }
        };
    }


}
