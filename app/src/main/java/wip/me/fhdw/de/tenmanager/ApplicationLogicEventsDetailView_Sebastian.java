package wip.me.fhdw.de.tenmanager;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import java.util.Calendar;

public class ApplicationLogicEventsDetailView_Sebastian  {

    private static final String TAG = "AppLogic_Sebastian";

    private GuiEventsDetailView_Sebastian mGui;
    private View mView;
    private DatepickerEventsDetailView_Sebastian datepicker;
    private TimepickerEventsDetailView_Sebastian timepicker;


    public ApplicationLogicEventsDetailView_Sebastian(GuiEventsDetailView_Sebastian gui) {
        mGui = gui;
        initGui();
        initCurrentDate();
        initCurrentTime();
        initDatepicker();
        initTimepicker();
        initSpanpicker();
    }


    private void initGui() {
        dataToGui();
    }




//todo

    public void dataToGui(){

    }

    /////////////////////////////////////////////
    // AppLogic
    ////////////////////////////////////////////7


    //todo Eingabefenster öffnet sich erst beim 2. Klick
    public void OnSpanButtonClicked(){
        mGui.getButtonSpan().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Log.d(TAG, "onClick: working");
                    LayoutInflater layoutInflaterAndroid = LayoutInflater.from(view.getContext());
                    mView = layoutInflaterAndroid.inflate(R.layout.eventdetailviewuserinputbox_sebastian, null);
                    AlertDialog.Builder alertDialogBuilderUserInput = new AlertDialog.Builder(view.getContext());
                    alertDialogBuilderUserInput.setView(mView);

                    final EditText userInputDialogEditText = (EditText) mView.findViewById(R.id.userInputDialog);
                    alertDialogBuilderUserInput
                            .setCancelable(false)
                            .setPositiveButton("Übernehmen", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialogBox, int id) {


                                    String span = ((EditText) mView.findViewById(R.id.userInputDialog)).getText().toString();

                                    //todo H klein formatieren
                                    mGui.getButtonSpan().setText(span + " h");
                                }
                            })

                            .setNegativeButton("Abbrechen",
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialogBox, int id) {
                                            dialogBox.cancel();
                                        }
                                    });

                    AlertDialog alertDialogAndroid = alertDialogBuilderUserInput.create();
                    alertDialogAndroid.show();
                    }

        });
    }


    private void initCurrentDate(){
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        month = month+1;

        mGui.getButtonDate().setText(String.format("%02d/%02d/%04d", day, month, year));
    }


    private void initCurrentTime(){
        Calendar cal = Calendar.getInstance();
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        int minute;

        hour = hour+1;
        minute = 00;

        mGui.getButtonTime().setText(String.format("%02d:%02d", hour, minute));
    }


    private void initDatepicker(){
        datepicker = new DatepickerEventsDetailView_Sebastian(mGui);
        datepicker.buildDatepicker();
        datepicker.setDateToButton();
    }


    private void initTimepicker(){
        timepicker = new TimepickerEventsDetailView_Sebastian(mGui);
        timepicker.bulidTimepicker();
    }


    private void initSpanpicker(){
        SpanpickerEventsDetailView_Sebastian clicklistener;

        clicklistener = new SpanpickerEventsDetailView_Sebastian(this);
        mGui.getButtonSpan().setOnClickListener(clicklistener);
    }
}
