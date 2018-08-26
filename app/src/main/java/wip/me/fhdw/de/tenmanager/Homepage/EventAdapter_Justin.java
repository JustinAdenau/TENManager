package wip.me.fhdw.de.tenmanager.Homepage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.List;

import wip.me.fhdw.de.tenmanager.Event;
import wip.me.fhdw.de.tenmanager.R;

public class EventAdapter_Justin extends BaseAdapter {
    private Context mContext;
    private List<Event> mEventList;
    private ApplicationLogicHomepage_Justin mApplicationLogic;


    public EventAdapter_Justin(Context context)
    {
        this.mContext=context;
    }

    public void setEventList(List<Event> eventList){mEventList=eventList;}

    public void setApplicationLogic(ApplicationLogicHomepage_Justin applicationLogic){mApplicationLogic=applicationLogic;}

    @Override
    public int getCount() {
        return mEventList.size();
    }

    @Override
    public Object getItem(int position) {
        return mEventList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public List<Event> getEventList(){return mEventList;}

    @Override
    public View getView(int position, View v, ViewGroup viewGroup) {
        View view = View.inflate(mContext, R.layout.list_item_homepage_event, null);

        TextView textviewHomepageEventitemTitle = view.findViewById(R.id.homepage_event_title);
        TextView textviewHomepageEventitemDate = view.findViewById(R.id.homepage_event_date);
        TextView textviewHomepageEventitemTime = view.findViewById(R.id.homepage_event_time);

        ImageButton homepage_buttonDeleteEvent = view.findViewById(R.id.homepage_buttonDeleteEvent);

        homepage_buttonDeleteEvent.setOnClickListener(new ButtonDeleteEventClickListener_Justin(mApplicationLogic));

        textviewHomepageEventitemTitle.setText(mEventList.get(position).getEventTitle());
        textviewHomepageEventitemDate.setText(mEventList.get(position).getEventDateStart());
        textviewHomepageEventitemTime.setText(mEventList.get(position).getEventTimeStart());

        view.setTag(mEventList.get(position).getId());
        return view;
    }
}
