package wip.me.fhdw.de.tenmanager;

import android.util.Log;
import android.view.View;

public class FloatingActionButtonClickListener_Lena implements View.OnClickListener {

    ApplicationLogicEventsOverview_Lena mApplicationlogicEventsOverview;
    ApplicationLogicEventsDetailView_Sebastian mApplicationlogicEventsDetailview;
    ApplicationLogicNoteOverview_Julius mApplicationlogicNoteOverview_Julius;

    public FloatingActionButtonClickListener_Lena(ApplicationLogicEventsOverview_Lena applicationLogic)
    {
        mApplicationlogicEventsOverview = applicationLogic;
    }

    public FloatingActionButtonClickListener_Lena(ApplicationLogicEventsDetailView_Sebastian applicationLogic)
    {
        mApplicationlogicEventsDetailview = applicationLogic;
    }

    public FloatingActionButtonClickListener_Lena(ApplicationLogicNoteOverview_Julius applicationLogic)
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
