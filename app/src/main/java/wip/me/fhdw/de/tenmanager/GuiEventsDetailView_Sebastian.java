package wip.me.fhdw.de.tenmanager;


import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.EditText;

public class GuiEventsDetailView_Sebastian {

    private Button mButtonDateStart;
    private Button mButtonDateEnd;
    private Button mButtonTimeStart;
    private Button mButtonTimeEnd;

    private ViewStub stub;
    private View inflated;

    private EditText mEditTextTitle;
    private EditText mEditTextDescription;
    private EditText mEditTextLocation;

    private FloatingActionButton mFabSave;


    public GuiEventsDetailView_Sebastian(InitEventsDetailView_Sebastian activity){
        activity.setContentView(R.layout.activity_main);
        stub = (ViewStub) activity.findViewById(R.id.viewStub);
        stub.setLayoutResource(R.layout.eventsdetailview_sebastian);
        inflated = stub.inflate();

        mEditTextTitle = activity.findViewById(R.id.eventTitleEditText);
        mEditTextDescription = activity.findViewById(R.id.eventDescriptionEditText);
        mEditTextLocation = activity.findViewById(R.id.eventLocationEditText);
        mButtonDateStart = activity.findViewById(R.id.eventDateStart);
        mButtonDateEnd  = activity.findViewById(R.id.eventDateEnd);
        mButtonTimeStart = activity.findViewById(R.id.eventTimeStart);
        mButtonTimeEnd = activity.findViewById(R.id.eventTimeEnd);

        mFabSave = activity.findViewById(R.id.fab);
        //mFabSave.setId(R.id.fabSave);
        mFabSave.setImageResource(android.R.drawable.ic_menu_save);
    }


    public EditText getEditTextTitle(){return mEditTextTitle; }

    public EditText getEditTextDescription(){return mEditTextDescription; }

    public EditText getEditTextLocation(){return mEditTextLocation; }

    public Button getButtonDateStart() {
        return mButtonDateStart;
    }

    public Button getButtonDateEnd() {
        return mButtonDateEnd;
    }

    public Button getButtonTimeStart() {
        return mButtonTimeStart;
    }

    public Button getButtonTimeEnd() {
        return mButtonTimeEnd;
    }

    public FloatingActionButton getFabSave(){return mFabSave;}

}
