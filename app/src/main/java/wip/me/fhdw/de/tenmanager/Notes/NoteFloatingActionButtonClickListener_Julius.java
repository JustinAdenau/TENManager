package wip.me.fhdw.de.tenmanager.Notes;

import android.util.Log;
import android.view.View;

public class NoteFloatingActionButtonClickListener_Julius implements View.OnClickListener {

    ApplicationLogicNoteOverview_Julius mApplicationlogicNoteOverview_Julius;

    public NoteFloatingActionButtonClickListener_Julius(ApplicationLogicNoteOverview_Julius applicationLogic)
    {
        mApplicationlogicNoteOverview_Julius = applicationLogic;
    }

    @Override
    public void onClick(View view) {

        //TODO extend activity check (Alina or Julius) with applicationLogic
        mApplicationlogicNoteOverview_Julius.onFabCreateNewClicked();
    }
}
