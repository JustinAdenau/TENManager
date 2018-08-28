package wip.me.fhdw.de.tenmanager;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.view.MenuItem;

import wip.me.fhdw.de.tenmanager.Events.ApplicationLogicEventsDetailView_Sebastian;
import wip.me.fhdw.de.tenmanager.Events.ApplicationLogicEventsOverview_Lena;
import wip.me.fhdw.de.tenmanager.Homepage.ApplicationLogicHomepage_Justin;
import wip.me.fhdw.de.tenmanager.Notes.ApplicationLogicNoteDetailView_Alina;
import wip.me.fhdw.de.tenmanager.Notes.ApplicationLogicNoteOverview_Julius;
import wip.me.fhdw.de.tenmanager.ToDos.ApplicationLogicToDoDetailview_Mona;
import wip.me.fhdw.de.tenmanager.ToDos.ApplicationLogicToDoOverview_Mona;

public class NavigationItemSelectListener_Lena implements NavigationView.OnNavigationItemSelectedListener {

    ApplicationLogicEventsOverview_Lena mApplicationLogicEventsOverview;
    ApplicationLogicToDoOverview_Mona mApplicationLogicToDosOverview;
    ApplicationLogicNoteOverview_Julius mApplicationLogicNotesOverview;
    ApplicationLogicEventsDetailView_Sebastian mApplicationLogicEventsDetailview;
    ApplicationLogicNoteDetailView_Alina mApplicationLogicNotesDetailview;
    ApplicationLogicToDoDetailview_Mona mApplicationLogicToDosDetailview;
    ApplicationLogicHomepage_Justin mApplicationLogicHomepage;


    public NavigationItemSelectListener_Lena(ApplicationLogicEventsOverview_Lena applicationLogic)
    {
        mApplicationLogicEventsOverview = applicationLogic;
    }

    public NavigationItemSelectListener_Lena(ApplicationLogicNoteOverview_Julius applicationLogic)
    {
        mApplicationLogicNotesOverview = applicationLogic;
    }

    public NavigationItemSelectListener_Lena(ApplicationLogicToDoOverview_Mona applicationLogic)
    {
        mApplicationLogicToDosOverview = applicationLogic;
    }

    public NavigationItemSelectListener_Lena(ApplicationLogicEventsDetailView_Sebastian applicationLogic)
    {
        mApplicationLogicEventsDetailview = applicationLogic;
    }

    public NavigationItemSelectListener_Lena(ApplicationLogicNoteDetailView_Alina applicationLogic)
    {
        mApplicationLogicNotesDetailview = applicationLogic;
    }

    public NavigationItemSelectListener_Lena(ApplicationLogicToDoDetailview_Mona applicationLogic)
    {
        mApplicationLogicToDosDetailview = applicationLogic;
    }

    public NavigationItemSelectListener_Lena(ApplicationLogicHomepage_Justin applicationLogic)
    {
        mApplicationLogicHomepage = applicationLogic;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        if(mApplicationLogicEventsOverview != null) mApplicationLogicEventsOverview.onMenuItemSelected(item);
        else if(mApplicationLogicNotesOverview != null){ mApplicationLogicNotesOverview.onMenuItemSelected(item); }
        else if(mApplicationLogicToDosOverview != null) {mApplicationLogicToDosOverview.onMenuItemSelected(item);}
        else if(mApplicationLogicEventsDetailview != null){mApplicationLogicEventsDetailview.onMenuItemSelected(item);}
        else if(mApplicationLogicNotesDetailview != null){mApplicationLogicNotesDetailview.onMenuItemSelected(item);}
        else if(mApplicationLogicToDosDetailview != null){mApplicationLogicToDosDetailview.onMenuItemSelected(item);}
        else if(mApplicationLogicHomepage != null){mApplicationLogicHomepage.onMenuItemSelected(item);}
        return false;
    }
}
