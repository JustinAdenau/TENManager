package wip.me.fhdw.de.tenmanager;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

public class ApplicationLogicEventsDetailview_Lena {

    private Data mData;
    private GuiEventsDetailview_Lena mGui;

    private String mTitle;
    private String mDate;
    private String mTime;
    private String mDescription;
    private String mLocation;
    private String mSpan;

    private EditText editTextTitle;
    private EditText editTextDate;
    private EditText editTextTime;
    private EditText editTextDescription;
    private EditText editTextLocation;
    private EditText editTextSpan;


    public ApplicationLogicEventsDetailview_Lena(Data data, GuiEventsDetailview_Lena gui)
    {
        mData=data;
        mGui = gui;

        initGui();
        initListener();
    }

    public void initGui(){dataToGui();}

    public void initListener(){

        mGui.getEditTextTitle().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                onTextViewTitleChanged(mGui.getEditTextTitle().getText().toString());
            }
            @Override
            public void afterTextChanged(Editable editable) { }
        });

        //TODO: überprüfen, ob der Listener beim Button greift
        mGui.getButtonTextDate().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                onTextViewDateChanged(mGui.getButtonTextDate().getText().toString());
            }
            @Override
            public void afterTextChanged(Editable editable) { }
        });

        mGui.getEditTextTime().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                onTextViewTimeChanged(mGui.getEditTextTime().getText().toString());
            }
            @Override
            public void afterTextChanged(Editable editable) { }
        });

        mGui.getEditTextDescription().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                onTextViewDescriptionChanged(mGui.getEditTextDescription().getText().toString());
            }
            @Override
            public void afterTextChanged(Editable editable) {}
        });

        mGui.getEditTextLocation().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                onTextViewLocationChanged(mGui.getEditTextLocation().getText().toString());
            }
            @Override
            public void afterTextChanged(Editable editable) { }
        });

        mGui.getEditTextSpan().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                onTextViewSpanChanged(mGui.getEditTextSpan().getText().toString());
            }
            @Override
            public void afterTextChanged(Editable editable) {}
        });
    }

    public void dataToGui(){}

    public void onButtonSaveClicked()
    {
        mData.createAndSaveNewEvent(mTitle, mDate, mTime, mDescription, mLocation);
    }

    public void onTextViewTitleChanged(String title){mTitle = title;}

    public void onTextViewDateChanged(String date){mDate = date;}

    public void onTextViewTimeChanged(String time){mTime = time;}

    public void onTextViewDescriptionChanged(String description){mDescription = description;}

    public void onTextViewLocationChanged(String location){mLocation = location;}

    public void onTextViewSpanChanged(String span){mSpan = span;}




}
