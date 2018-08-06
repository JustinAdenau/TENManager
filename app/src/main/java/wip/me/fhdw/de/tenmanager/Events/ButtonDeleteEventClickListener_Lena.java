package wip.me.fhdw.de.tenmanager.Events;

import android.util.Log;
import android.view.View;


public class ButtonDeleteEventClickListener_Lena implements View.OnClickListener {

    private ApplicationLogicEventsOverview_Lena mApplicationLogic;

    public ButtonDeleteEventClickListener_Lena(ApplicationLogicEventsOverview_Lena applicationLogic)
    {
        mApplicationLogic=applicationLogic;
    }

    @Override
    public void onClick(View view) {
        Log.d("LOGTAG", "onClick: ButtonDeleteEvent wurde angeklickt!!!!!!!!!!!!!!!!");
        mApplicationLogic.onButtonDeleteEventClicked(view);
    }
}
