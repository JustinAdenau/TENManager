package wip.me.fhdw.de.tenmanager.Events;

import android.util.Log;
import android.view.View;

public class FloatingActionButtonClickListener_Lena implements View.OnClickListener {

    wip.me.fhdw.de.tenmanager.Events.ApplicationLogicEventsOverview_Lena mApplicationlogicEventsOverview;
    wip.me.fhdw.de.tenmanager.Events.ApplicationLogicEventsDetailView_Sebastian mApplicationlogicEventsDetailview;
    wip.me.fhdw.de.tenmanager.ApplicationLogicNoteOverview_Julius mApplicationlogicNoteOverview_Julius;

    public FloatingActionButtonClickListener_Lena(wip.me.fhdw.de.tenmanager.Events.ApplicationLogicEventsOverview_Lena applicationLogic)
    {
        mApplicationlogicEventsOverview = applicationLogic;
    }

    public FloatingActionButtonClickListener_Lena(wip.me.fhdw.de.tenmanager.Events.ApplicationLogicEventsDetailView_Sebastian applicationLogic)
    {
        mApplicationlogicEventsDetailview = applicationLogic;
    }

    public FloatingActionButtonClickListener_Lena(wip.me.fhdw.de.tenmanager.ApplicationLogicNoteOverview_Julius applicationLogic)
    {
        Log.d("LOGTAG", "FAB wurde erzeugt!!");
        mApplicationlogicNoteOverview_Julius = applicationLogic;
    }
    @Override
    public void onClick(View view)
    {
        Log.d("LOGTAG", "FAB wurde angeklickt!!");

        if(mApplicationlogicEventsDetailview == null) mApplicationlogicEventsOverview.onFabCreateNewClicked();
        else mApplicationlogicEventsDetailview.onFabSaveClicked();
    }
}
