package wip.me.fhdw.de.tenmanager;

import android.widget.Button;
import android.widget.EditText;

public class GuiEventsDetailview_Lena {

    private EditText mEditTextTitle;
    private Button mButtonDate;
    private EditText mEditTextTime;
    private EditText mEditTextDescription;
    private EditText mEditTextLocation;
    private EditText mEditTextSpan;

    public GuiEventsDetailview_Lena(InitEventsDetailview_Lena activity)
    {
        activity.setContentView(R.layout.activity_main);

       /* mEditTextTitle = activity.findViewById(R.id.eventTitle);
        mButtonDate = activity.findViewById(R.id.eventDate);
        mEditTextTime = activity.findViewById(R.id.eventTime);
        mEditTextDescription = activity.findViewById(R.id.eventDescription);
        mEditTextLocation = activity.findViewById(R.id.eventLocation);
        mEditTextSpan = activity.findViewById(R.id.eventSpan);*/
    }

    //getter
    public EditText getEditTextTitle(){return mEditTextTitle; }
    public Button getButtonTextDate(){return mButtonDate; }
    public EditText getEditTextTime(){return mEditTextTime; }
    public EditText getEditTextDescription(){return mEditTextDescription; }
    public EditText getEditTextLocation(){return mEditTextLocation; }
    public EditText getEditTextSpan(){return mEditTextSpan; }




}
