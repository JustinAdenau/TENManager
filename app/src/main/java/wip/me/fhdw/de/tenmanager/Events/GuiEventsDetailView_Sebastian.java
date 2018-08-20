package wip.me.fhdw.de.tenmanager.Events;


import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TextInputLayout;
import android.view.View;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import wip.me.fhdw.de.tenmanager.R;

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

    private TextInputLayout mTextInputLayoutTitle;
    private TextInputLayout mTextInputLayoutLocation;
    private TextInputLayout mTextInputLayoutDescription;

    private TextView mTextViewDateTimeValidation;

    private Spinner mSpinnerReminder;

    private FloatingActionButton mFabSave;
    private NavigationView mNavigationView;


    public GuiEventsDetailView_Sebastian(InitEventsDetailView_Sebastian activity){
        activity.setContentView(R.layout.menu_alina_und_mona);
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
        mTextInputLayoutTitle = activity.findViewById(R.id.eventTitle);
        mTextInputLayoutLocation = activity.findViewById(R.id.eventLocation);
        mTextInputLayoutDescription = activity.findViewById(R.id.eventDescription);
        mTextViewDateTimeValidation = activity.findViewById(R.id.eventHintDateTimeValidation);
        mSpinnerReminder = activity.findViewById(R.id.eventReminderSpinner);

        mFabSave = activity.findViewById(R.id.fab);
        mFabSave.setImageResource(android.R.drawable.ic_menu_save);
        mNavigationView = activity.findViewById(R.id.nav_view);
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

    public TextInputLayout getTextInputLayoutTitle() {
        return mTextInputLayoutTitle;
    }

    public TextInputLayout getTextInputLayoutLocation() {
        return mTextInputLayoutLocation;
    }

    public TextInputLayout getTextInputLayoutDescription() {
        return mTextInputLayoutDescription;
    }

    public TextView getTextViewDateTimeValidation(){
        return mTextViewDateTimeValidation;
    }

    public FloatingActionButton getFabSave() {
        return mFabSave;
    }

    public Spinner getSpinnerReminder() {
        return mSpinnerReminder;
    }

    public NavigationView getNavigationView(){return mNavigationView;}

    public void setButtonTimeStart(String ButtonTimeStart) {
        this.mButtonTimeStart.setText(ButtonTimeStart);
    }

    public void setButtonTimeEnd(String ButtonTimeEnd) {
        this.mButtonTimeEnd.setText(ButtonTimeEnd);
    }

    public void setButtonDateStart(String ButtonDateStart) {
        this.mButtonDateStart.setText(ButtonDateStart);
    }

    public void setButtonDateEnd(String ButtonDateEnd) {
        this.mButtonDateEnd.setText(ButtonDateEnd);
    }
}
