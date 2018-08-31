package wip.me.fhdw.de.tenmanager.Events;

import android.util.Log;
import android.view.View;

import wip.me.fhdw.de.tenmanager.Notes.ApplicationLogicNoteOverview_Julius;

public class EventFloatingActionButtonClickListener_Lena implements View.OnClickListener {


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

        if(mApplicationlogicEventsDetailview == null) mApplicationlogicEventsOverview.onFabCreateNewClicked();
        else mApplicationlogicEventsDetailview.onFabSaveClicked();

    }
}
