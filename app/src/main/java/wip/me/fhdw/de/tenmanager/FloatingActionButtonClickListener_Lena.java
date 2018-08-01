package wip.me.fhdw.de.tenmanager;

import android.util.Log;
import android.view.View;

public class FloatingActionButtonClickListener_Lena implements View.OnClickListener {

    ApplicationLogicEventsOverview_Lena mApplicationlogicEventsOverview;
    ApplicationLogicEventsDetailView_Sebastian mApplicationlogicEventsDetailview;

    public FloatingActionButtonClickListener_Lena(ApplicationLogicEventsOverview_Lena applicationLogic)
    {
        Log.d("LOGTAG", "FAB wurde erzeugt!!");
        mApplicationlogicEventsOverview = applicationLogic;
    }

    public FloatingActionButtonClickListener_Lena(ApplicationLogicEventsDetailView_Sebastian applicationLogic)
    {
        Log.d("LOGTAG", "FAB wurde erzeugt!!");
        mApplicationlogicEventsDetailview = applicationLogic;
    }

    @Override
    public void onClick(View view)
    {
        Log.d("LOGTAG", "FAB wurde angeklickt!!");
        Log.d("LOGTAG", "viewId:" +String.valueOf(view.getId()));

        if(mApplicationlogicEventsDetailview == null) mApplicationlogicEventsOverview.onFabCreateNewClicked();
        else mApplicationlogicEventsDetailview.onFabSaveClicked();
    }
}
