package wip.me.fhdw.de.tenmanager.Notes;

import android.view.View;

import wip.me.fhdw.de.tenmanager.Events.ApplicationLogicEventsOverview_Lena;

public class NoteFloatingActionButtonClickListener_Julius implements View.OnClickListener {

    ApplicationLogicNoteOverview_Julius mApplicationlogicNoteOverview;
    //ApplicationLogicNoteDetailview_Julius mApplicationlogicNoteDetailview;

    public NoteFloatingActionButtonClickListener_Julius(ApplicationLogicNoteOverview_Julius applicationLogic)
    {
        mApplicationlogicNoteOverview = applicationLogic;
    }

    /*public NoteFloatingActionButtonClickListener_Julius(ApplicationLogicNoteDetailview_Julius applicationLogic)
    {
        mApplicationlogicNoteDetailview = applicationLogic;
    }*/

    @Override
    public void onClick(View view) {
        /*if(mApplicationlogicNoteDetailview == null) mApplicationlogicNoteOverview.onFabCreateNewClicked();
        else mApplicationlogicNoteDetailview.onFabSaveClicked();*/
    }
}
