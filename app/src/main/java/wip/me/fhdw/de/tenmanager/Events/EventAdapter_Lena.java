package wip.me.fhdw.de.tenmanager;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class EventAdapter_Lena extends BaseAdapter {

    private Context mContext;
    private List<Event> mEventList;

    public EventAdapter_Lena(Context context, List<Event> eventList)
    {
        this.mContext=context;
        this.mEventList=eventList;
    }

    public EventAdapter_Lena(Context context)
    {
        this.mContext=context;
    }

    public void setEventList(List<Event> eventList){mEventList=eventList;}

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
        View view = View.inflate(mContext, R.layout.list_item_eventsoverview, null);
        TextView textviewEventitemTitle = view.findViewById(R.id.listviewitem_textview_title);
        TextView textviewEventitemDateStart = view.findViewById(R.id.listviewitem_textview_dateStart);
        TextView textviewEventitemTimeStart = view.findViewById(R.id.listviewitem_textview_timeStart);
        TextView textviewEventitemDateEnd = view.findViewById(R.id.listviewitem_textview_dateEnd);
        TextView textviewEventitemTimeEnd = view.findViewById(R.id.listviewitem_textview_timeEnd);

        textviewEventitemTitle.setText(mEventList.get(position).getEventTitle());
        textviewEventitemDateStart.setText(mEventList.get(position).getEventDateStart());
        textviewEventitemTimeStart.setText(mEventList.get(position).getEventTimeStart());
        textviewEventitemDateEnd.setText(mEventList.get(position).getEventDateEnd());
        textviewEventitemTimeEnd.setText(mEventList.get(position).getEventTimeEnd());

        view.setTag(mEventList.get(position).getId());
        return view;
    }
}
