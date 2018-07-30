package wip.me.fhdw.de.tenmanager;


import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.Editable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

public class ApplicationLogicEventsDetailView_Sebastian  {

    private static final String TAG = "AppLogic_Sebastian";

    private GuiEventsDetailView_Sebastian mGui;
    private View mView;


    public ApplicationLogicEventsDetailView_Sebastian(GuiEventsDetailView_Sebastian gui) {
        mGui = gui;
        initGui();
        initListener();
    }

    private void initGui() {
        dataToGui();
    }


   private void initListener(){
        SpanpickerEventsDetailView_Sebastian clicklistener;

        clicklistener = new SpanpickerEventsDetailView_Sebastian(this);
        mGui.getButtonSpan().setOnClickListener(clicklistener);
        //todo Date und Time erweitern oder initPicker()
    }



    public void dataToGui(){

    }

    // AppLogic


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


}
