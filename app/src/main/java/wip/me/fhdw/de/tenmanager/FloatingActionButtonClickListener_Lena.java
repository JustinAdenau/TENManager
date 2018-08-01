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

    @Override
    public void onClick(View view)
    {

        Log.d("LOGTAG", "FAB wurde angeklickt!!");
        Log.d("LOGTAG", "viewId:" +view.getId());

        //switch(view.getId())
        //{
            //case R.layout.eventsoverview_lena:
                mApplicationlogicEventsOverview.onFabCreateNewClicked();
            //    break;

            /*case R.layout.eventsdetailview_sebastian:
                mApplicationlogicEventsDetailview.onFabSaveClicked();
                break;*/
        //}

    }
}
