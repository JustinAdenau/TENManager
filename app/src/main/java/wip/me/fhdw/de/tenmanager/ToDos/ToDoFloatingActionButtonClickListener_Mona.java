package wip.me.fhdw.de.tenmanager.ToDos;

import android.view.View;

public class ToDoFloatingActionButtonClickListener_Mona implements View.OnClickListener {

    ApplicationLogicToDoOverview_Mona mApplicationlogicToDoOverview_Mona;

    public ToDoFloatingActionButtonClickListener_Mona(ApplicationLogicToDoOverview_Mona applicationLogic)
    {
        mApplicationlogicToDoOverview_Mona = applicationLogic;
    }

    @Override
    public void onClick(View view) {

        //TODO extend activity check (Alina or Julius) with applicationLogic
        mApplicationlogicToDoOverview_Mona.onFabCreateNewClicked();
    }
}
