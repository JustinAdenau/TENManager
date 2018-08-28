package wip.me.fhdw.de.tenmanager.Homepage;

import android.view.View;
import android.widget.ListView;

public class TitleEventClickListener implements ListView.OnClickListener{
    ApplicationLogicHomepage_Justin mApplicationLogic;

    public TitleEventClickListener(ApplicationLogicHomepage_Justin applicationLogic)
    {
        mApplicationLogic = applicationLogic;
    }

    @Override
    public void onClick(View view)
    {
        mApplicationLogic.onTitleEventClicked(view);
    }
}
