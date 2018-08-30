package wip.me.fhdw.de.tenmanager.ToDos;

import android.view.View;

public class ButtonNewTaskClickListener_Lena implements View.OnClickListener {

    ApplicationLogicToDoDetailview_Mona mApplicationLogic;

    public ButtonNewTaskClickListener_Lena(ApplicationLogicToDoDetailview_Mona applicationLogic)
    {
        mApplicationLogic = applicationLogic;
    }

    @Override
    public void onClick(View view) {
        mApplicationLogic.onButtonNewTaskClicked();
    }
}
