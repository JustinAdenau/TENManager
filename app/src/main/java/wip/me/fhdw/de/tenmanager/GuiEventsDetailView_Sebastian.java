package wip.me.fhdw.de.tenmanager;


import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.EditText;

public class GuiEventsDetailView_Sebastian {

    private Button mButtonDate;
    private Button mButtonTime;
    private Button mButtonSpan;

    private ViewStub stub;
    private View inflated;

    private EditText mEditTextTitle;
    private EditText mEditTextDescription;
    private EditText mEditTextLocation;

    private FloatingActionButton mFabCreateNew;


    public GuiEventsDetailView_Sebastian(InitEventsDetailView_Sebastian activity){
        activity.setContentView(R.layout.activity_main);
        stub = (ViewStub) activity.findViewById(R.id.viewStub);
        stub.setLayoutResource(R.layout.eventsdetailview_sebastian);
        inflated = stub.inflate();

        mEditTextTitle = activity.findViewById(R.id.eventTitleEditText);
        mEditTextDescription = activity.findViewById(R.id.eventDescriptionEditText);
        mEditTextLocation = activity.findViewById(R.id.eventLocationEditText);
        mButtonDate = activity.findViewById(R.id.eventDateStart);
        mButtonTime = activity.findViewById(R.id.eventTimeStart);
        //mButtonSpan = activity.findViewById(R.id.eventSpan);

        mFabCreateNew = activity.findViewById(R.id.fab);
        //TODO: change icon to save icon
    }


    public EditText getEditTextTitle(){return mEditTextTitle; }

    public EditText getEditTextDescription(){return mEditTextDescription; }

    public EditText getEditTextLocation(){return mEditTextLocation; }

    public Button getButtonDate() {
        return mButtonDate;
    }

    public Button getButtonTime() {
        return mButtonTime;
    }

   // public Button getButtonSpan() {
   //     return mButtonSpan;
   // }

    //todo bis jetzt nicht benötigt
    /*public void setButtonSpan(Button mButtonSpan) {
        this.mButtonSpan = mButtonSpan;
    }*/

}
