package wip.me.fhdw.de.tenmanager.Homepage;

import android.view.View;
import android.widget.ListView;

public class TitleTodoClickListener implements ListView.OnClickListener{
    ApplicationLogicHomepage_Justin mApplicationLogic;

    public TitleTodoClickListener(ApplicationLogicHomepage_Justin applicationLogic)
    {
        mApplicationLogic = applicationLogic;
    }

    @Override
    public void onClick(View view)
    {
        mApplicationLogic.onTitleTodoClicked(view);
    }
}
