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

    private EditText mEditTextTitle;
    private EditText mEditTextDescription;
    private EditText mEditTextLocation;

    private FloatingActionButton mFabSave;


    public GuiEventsDetailView_Sebastian(InitEventsDetailView_Sebastian activity){
        activity.setContentView(R.layout.activity_main);
        ViewStub stub = (ViewStub) activity.findViewById(R.id.viewStub);
        stub.setLayoutResource(R.layout.eventsdetailview_sebastian);
        View inflated = stub.inflate();

        mEditTextTitle = activity.findViewById(R.id.eventTitleEditText);
        mEditTextDescription = activity.findViewById(R.id.eventDescriptionEditText);
        mEditTextLocation = activity.findViewById(R.id.eventLocationEditText);
        mButtonDate = activity.findViewById(R.id.eventDate);
        mButtonTime = activity.findViewById(R.id.eventTime);
        mButtonSpan = activity.findViewById(R.id.eventSpan);

        mFabSave = activity.findViewById(R.id.fab);
        mFabSave.setImageResource(android.R.drawable.ic_menu_save);
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

    public Button getButtonSpan() {
        return mButtonSpan;
    }

    public FloatingActionButton getFabSave(){return mFabSave;}

    //todo bis jetzt nicht benötigt
    /*public void setButtonSpan(Button mButtonSpan) {
        this.mButtonSpan = mButtonSpan;
    }*/

}
