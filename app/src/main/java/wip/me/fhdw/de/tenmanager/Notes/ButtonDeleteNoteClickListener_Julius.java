package wip.me.fhdw.de.tenmanager.Notes;

import android.util.Log;
import android.view.View;


public class ButtonDeleteNoteClickListener_Julius implements View.OnClickListener {

    private ApplicationLogicNoteOverview_Julius mApplicationLogic;

    public ButtonDeleteNoteClickListener_Julius(ApplicationLogicNoteOverview_Julius applicationLogic)
    {
        mApplicationLogic = applicationLogic;
    }

    @Override
    public void onClick(View view) {
        mApplicationLogic.onButtonDeleteNoteClicked(view);
    }
}
