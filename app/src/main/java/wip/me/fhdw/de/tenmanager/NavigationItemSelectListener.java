package wip.me.fhdw.de.tenmanager;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.view.MenuItem;

import wip.me.fhdw.de.tenmanager.Events.ApplicationLogicEventsOverview_Lena;

public class NavigationItemSelectListener implements NavigationView.OnNavigationItemSelectedListener {

    ApplicationLogicEventsOverview_Lena mApplicationLogic;

    public NavigationItemSelectListener(ApplicationLogicEventsOverview_Lena applicationLogic)
    {
        mApplicationLogic = applicationLogic;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        mApplicationLogic.onMenuItemSelected(item);
        return false;
    }
}
