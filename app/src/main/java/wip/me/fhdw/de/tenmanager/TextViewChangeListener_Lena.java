package wip.me.fhdw.de.tenmanager;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.widget.TextView;

public class TextViewChangeListener_Lena implements TextWatcher {

    ApplicationLogicEventsOverview_Lena mApplicationLogic;

    public TextViewChangeListener_Lena(ApplicationLogicEventsOverview_Lena applicationLogic)
    {
        mApplicationLogic = applicationLogic;
    }


    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable editable) {

    }
}
