package wip.me.fhdw.de.tenmanager.ToDos;

import android.util.Log;
import android.view.View;


public class ButtonDeleteToDoClickListener_Mona implements View.OnClickListener {

    private ApplicationLogicToDoOverview_Mona mApplicationLogic;

    public ButtonDeleteToDoClickListener_Mona(ApplicationLogicToDoOverview_Mona applicationLogic)
    {
        mApplicationLogic=applicationLogic;
    }

    @Override
    public void onClick(View view) {
        Log.d("LOGTAG", "onClick: ButtonDeleteEvent wurde angeklickt!!!!!!!!!!!!!!!!");
        mApplicationLogic.onButtonDeleteToDoClicked(view);
    }
}
