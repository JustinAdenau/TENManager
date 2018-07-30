package wip.me.fhdw.de.tenmanager;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

import java.util.Calendar;


public class DatepickerEventsDetailView_Sebastian {


    private static final String TAG = "Datepicker_Sebastian";


    private GuiEventsDetailView_Sebastian mGui;
    private DatePickerDialog.OnDateSetListener mDateSetListener;


    public DatepickerEventsDetailView_Sebastian(GuiEventsDetailView_Sebastian gui){
        mGui = gui;
    }


    public void buildDatepicker() {
        mGui.getButtonDate().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);


                DatePickerDialog dialog = new DatePickerDialog(
                        view.getContext(),
                        android.R.style.Theme_Holo_Dialog_MinWidth,
                        mDateSetListener,
                        year, month, day);

                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

    }

    public void setDateToButton() {
        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;

                mGui.getButtonDate().setText(String.format("%02d/%02d/%04d", day, month, year));

            }
        };
    }


}
