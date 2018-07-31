package wip.me.fhdw.de.tenmanager;

import android.view.View;

public class FloatingActionButtonClickListener_Lena implements View.OnClickListener {

    ApplicationLogicEventsOverview_Lena mApplicationlogicEventsOverview;
    ApplicationLogicEventsDetailView_Sebastian mApplicationlogicEventsDetailview;

    public FloatingActionButtonClickListener_Lena(ApplicationLogicEventsOverview_Lena applicationLogic)
    {
        mApplicationlogicEventsOverview = applicationLogic;
    }

    @Override
    public void onClick(View view) {
        switch(view.getId())
        {
            case R.layout.eventsoverview_lena:
                mApplicationlogicEventsOverview.onFabCreateNewClicked();
                break;

            case R.layout.eventsdetailview_sebastian:
                mApplicationlogicEventsDetailview.onFabSaveClicked();
                break;
        }

    }
}
