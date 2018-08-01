package wip.me.fhdw.de.tenmanager;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

public class SpanpickerEventsDetailView_Sebastian  {

    private static final String TAG = "Spanspicker_Sebastian";

   private ApplicationLogicEventsDetailView_Sebastian mApplicationLogic;
   private GuiEventsDetailView_Sebastian mGui;
   private View mView;

   public SpanpickerEventsDetailView_Sebastian(GuiEventsDetailView_Sebastian gui) {
       mGui = gui;
   }


//todo Button ID anpassen
    public void BuildSpanpicker() {
            mGui.getButtonSpan().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.d(TAG, "onClick: working");
                    LayoutInflater layoutInflaterAndroid = LayoutInflater.from(view.getContext());
                    mView = layoutInflaterAndroid.inflate(R.layout.eventdetailviewuserinputbox_sebastian, null);
                    AlertDialog.Builder alertDialogBuilderUserInput = new AlertDialog.Builder(view.getContext());
                    alertDialogBuilderUserInput.setView(mView);

                    final EditText EventUserInputDialogHourEditText = (EditText) mView.findViewById(R.id.EventUserInputDialogHour);
                    final EditText EventUserInputDialogMinuteEditText = (EditText) mView.findViewById(R.id.EventUserInputDialogMinute);
                    alertDialogBuilderUserInput
                            .setCancelable(false)
                            .setPositiveButton("Übernehmen", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialogBox, int id) {


                                    String spanHour = ((EditText) mView.findViewById(R.id.EventUserInputDialogHour)).getText().toString();
                                    String spanMinute = ((EditText) mView.findViewById(R.id.EventUserInputDialogMinute)).getText().toString();

                                    //todo Formatierung als 5,80 h oder 5:50 h
                                    mGui.getButtonSpan().setText(spanHour + ":" + spanMinute + " h");
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

}

