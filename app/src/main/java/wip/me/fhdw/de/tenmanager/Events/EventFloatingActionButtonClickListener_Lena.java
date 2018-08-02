package wip.me.fhdw.de.tenmanager.Events;

import android.util.Log;
import android.view.View;

public class EventFloatingActionButtonClickListener_Lena implements View.OnClickListener{

    ApplicationLogicEventsOverview_Lena mApplicationlogicEventsOverview;
    ApplicationLogicEventsDetailView_Sebastian mApplicationlogicEventsDetailview;

    public EventFloatingActionButtonClickListener_Lena(ApplicationLogicEventsOverview_Lena applicationLogic)
    {
        mApplicationlogicEventsOverview = applicationLogic;
    }

    public EventFloatingActionButtonClickListener_Lena(ApplicationLogicEventsDetailView_Sebastian applicationLogic)
    {
        mApplicationlogicEventsDetailview = applicationLogic;
    }

    @Override
    public void onClick(View view) {

        Log.d("LOGTAG", "FAB wurde angeklickt!!");

        if(mApplicationlogicEventsDetailview == null) mApplicationlogicEventsOverview.onFabCreateNewClicked();
        else mApplicationlogicEventsDetailview.onFabSaveClicked();

    }
}
