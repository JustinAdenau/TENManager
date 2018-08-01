package wip.me.fhdw.de.tenmanager;

import android.util.Log;
import android.view.View;

public class FloatingActionButtonClickListener_Lena implements View.OnClickListener {

    ApplicationLogicEventsOverview_Lena mApplicationlogicEventsOverview;
    ApplicationLogicEventsDetailView_Sebastian mApplicationlogicEventsDetailview;

    public FloatingActionButtonClickListener_Lena(ApplicationLogicEventsOverview_Lena applicationLogic)
    {
        mApplicationlogicEventsOverview = applicationLogic;
    }

    public FloatingActionButtonClickListener_Lena(ApplicationLogicEventsDetailView_Sebastian applicationLogic)
    {
        mApplicationlogicEventsDetailview = applicationLogic;
    }

    @Override
    public void onClick(View view)
    {
        Log.d("LOGTAG", "FAB wurde angeklickt!!");

        if(mApplicationlogicEventsDetailview == null) mApplicationlogicEventsOverview.onFabCreateNewClicked();
        else mApplicationlogicEventsDetailview.onFabSaveClicked();
    }
}
