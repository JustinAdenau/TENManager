package wip.me.fhdw.de.tenmanager.Homepage;

import android.util.Log;
import android.view.View;

public class ButtonDeleteToDoClickListener_Justin implements View.OnClickListener{
    private ApplicationLogicHomepage_Justin mApplicationLogic;

    public ButtonDeleteToDoClickListener_Justin(ApplicationLogicHomepage_Justin applicationLogic)
    {
        mApplicationLogic=applicationLogic;
    }

    @Override
    public void onClick(View view) {
        Log.d("LOGTAG", "onClick: ButtonDeleteEvent wurde angeklickt!!!!!!!!!!!!!!!!");
        mApplicationLogic.onButtonDeleteTodoClicked(view);
    }
}
