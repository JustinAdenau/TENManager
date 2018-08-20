package wip.me.fhdw.de.tenmanager.Notes;

import android.util.Log;
import android.view.View;

public class NoteFloatingActionButtonClickListener_Julius implements View.OnClickListener {

    ApplicationLogicNoteOverview_Julius mApplicationlogicNoteOverview_Julius;
    ApplicationLogicNoteDetailView_Alina mApplicationLogicNoteDetailView_Alina;

    public NoteFloatingActionButtonClickListener_Julius(ApplicationLogicNoteOverview_Julius applicationLogic)
    {
        mApplicationlogicNoteOverview_Julius = applicationLogic;
    }
    public NoteFloatingActionButtonClickListener_Julius(ApplicationLogicNoteDetailView_Alina applicationLogic)
    {
        mApplicationLogicNoteDetailView_Alina = applicationLogic;
    }

    @Override
    public void onClick(View view) {

        //TODO extend activity check (Alina or Julius) with applicationLogic

        if(mApplicationLogicNoteDetailView_Alina == null) mApplicationlogicNoteOverview_Julius.onFabCreateNewClicked();
        else mApplicationLogicNoteDetailView_Alina.onFabSaveClicked();
    }
}
