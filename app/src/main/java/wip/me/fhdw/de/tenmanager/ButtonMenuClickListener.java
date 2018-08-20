package wip.me.fhdw.de.tenmanager;

import android.view.View;
import android.widget.Button;

import wip.me.fhdw.de.tenmanager.Events.ApplicationLogicEventsOverview_Lena;

public class ButtonMenuClickListener implements Button.OnClickListener {

    ApplicationLogicEventsOverview_Lena mApplicationLogic;

    public ButtonMenuClickListener(ApplicationLogicEventsOverview_Lena applicationLogic){
        mApplicationLogic = applicationLogic;
    }

    @Override
    public void onClick(View view) {
        mApplicationLogic.startActivity(Constants.ACTIVITYMENUCLASS, false);
    }
}
