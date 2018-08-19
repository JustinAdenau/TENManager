package wip.me.fhdw.de.tenmanager;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.view.MenuItem;

import wip.me.fhdw.de.tenmanager.Events.ApplicationLogicEventsOverview_Lena;
import wip.me.fhdw.de.tenmanager.Notes.ApplicationLogicNoteOverview_Julius;
import wip.me.fhdw.de.tenmanager.ToDos.ApplicationLogicToDoOverview_Mona;

public class NavigationItemSelectListener implements NavigationView.OnNavigationItemSelectedListener {

    ApplicationLogicEventsOverview_Lena mApplicationLogicEvents;
    ApplicationLogicToDoOverview_Mona mApplicationLogicToDos;
    ApplicationLogicNoteOverview_Julius mApplicationLogicNotes;

    public NavigationItemSelectListener(ApplicationLogicEventsOverview_Lena applicationLogic)
    {
        mApplicationLogicEvents = applicationLogic;
    }

    public NavigationItemSelectListener(ApplicationLogicNoteOverview_Julius applicationLogic)
    {
        mApplicationLogicNotes = applicationLogic;
    }

    public NavigationItemSelectListener(ApplicationLogicToDoOverview_Mona applicationLogic)
    {
        mApplicationLogicToDos = applicationLogic;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        if(mApplicationLogicEvents != null) mApplicationLogicEvents.onMenuItemSelected(item);
        else if(mApplicationLogicNotes != null){ mApplicationLogicNotes.onMenuItemSelected(item); }
        else if(mApplicationLogicToDos != null) {mApplicationLogicToDos.onMenuItemSelected(item);}
        return false;
    }
}
