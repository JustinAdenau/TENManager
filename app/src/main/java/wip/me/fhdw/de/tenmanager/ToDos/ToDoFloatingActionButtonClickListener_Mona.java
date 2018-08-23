package wip.me.fhdw.de.tenmanager.ToDos;

import android.view.View;

public class ToDoFloatingActionButtonClickListener_Mona implements View.OnClickListener {

    ApplicationLogicToDoOverview_Mona mApplicationlogicOverview;
    ApplicationLogicToDoDetailview_Mona mApplicationLogicDetailview;

    public ToDoFloatingActionButtonClickListener_Mona(ApplicationLogicToDoOverview_Mona applicationLogic)
    {
        mApplicationlogicOverview = applicationLogic;
    }

    public ToDoFloatingActionButtonClickListener_Mona(ApplicationLogicToDoDetailview_Mona applicationLogic)
    {
        mApplicationLogicDetailview = applicationLogic;
    }

    @Override
    public void onClick(View view) {

        if(mApplicationLogicDetailview == null)mApplicationlogicOverview.onFabCreateNewClicked();
        else mApplicationLogicDetailview.onFabSaveClicked();

    }
}
