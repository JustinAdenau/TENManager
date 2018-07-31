package wip.me.fhdw.de.tenmanager;

import android.util.Log;
import android.view.View;

public class SpanpickerEventsDetailView_Sebastian implements View.OnClickListener {

    private static final String TAG = "Spanspicker_Sebastian";

   private ApplicationLogicEventsDetailView_Sebastian mApplicationLogic;

    public SpanpickerEventsDetailView_Sebastian(ApplicationLogicEventsDetailView_Sebastian applicationlogic) {
        mApplicationLogic = applicationlogic;
    }

//todo wird das benötigt? ggf umbauen z.b. if
    public void onClick(View view) {
        Log.d(TAG, "onClick: ersterklick");

        switch (view.getId()) {
            case R.id.eventSpan:
                mApplicationLogic.OnSpanButtonClicked();
                break;
        }

    }
}
