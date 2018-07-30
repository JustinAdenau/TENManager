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

    @Override
    public View getView(int position, View v, ViewGroup viewGroup) {
        View view = View.inflate(mContext, R.layout.list_item_eventsoverview, null);
        TextView textviewEventitemTitle = view.findViewById(R.id.listviewitem_textview_title);
        TextView textviewEventitemDate = view.findViewById(R.id.listviewitem_textview_date);
        TextView textviewEventitemTime = view.findViewById(R.id.listviewitem_textview_time);

        textviewEventitemTitle.setText(mEventList.get(position).getEventTitle());
        textviewEventitemDate.setText(mEventList.get(position).getEventDate());
        textviewEventitemTime.setText(mEventList.get(position).getEventTime());

        view.setTag(mEventList.get(position).getId());
        return view;
    }
}
