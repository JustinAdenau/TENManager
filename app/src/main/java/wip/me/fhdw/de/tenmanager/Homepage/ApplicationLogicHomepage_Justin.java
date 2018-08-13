package wip.me.fhdw.de.tenmanager.Homepage;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.List;

import wip.me.fhdw.de.tenmanager.AppDatabase;
import wip.me.fhdw.de.tenmanager.Constants;
import wip.me.fhdw.de.tenmanager.Event;
import wip.me.fhdw.de.tenmanager.Events.EventData_Lena;
import wip.me.fhdw.de.tenmanager.R;

public class ApplicationLogicHomepage_Justin {
    private GuiHomepage_Justin mGui;
    private AppDatabase mDb;
    private List<Event> mEventList;
    private EventAdapter_Justin mEventAdapter;
    private Activity mActivity;
    private wip.me.fhdw.de.tenmanager.Events.EventData_Lena mData;

    public ApplicationLogicHomepage_Justin(Activity activity, EventData_Lena data, GuiHomepage_Justin gui, AppDatabase db, EventAdapter_Justin eventAdapter){
        mActivity = activity;
        mData = data;
        mGui = gui;
        mDb = db;
        mEventAdapter = eventAdapter;
        initGui();
        initListener();
    }

    public void initGui(){
        dataToGui();

    }

    public void initListener(){
        ListViewItemClickListener_Justin listViewItemClickListener = new ListViewItemClickListener_Justin(this);
        mGui.getListView().setOnItemClickListener(listViewItemClickListener);
        ButtonDeleteEventClickListener_Justin buttonDeleteEventClickListener = new ButtonDeleteEventClickListener_Justin(this);
        mGui.getButtonDeleteEvent().setOnClickListener(buttonDeleteEventClickListener);
        TitleEventClickListener titleEventClickListener = new TitleEventClickListener(this);
        mGui.getEvent().setOnClickListener(titleEventClickListener);
    }

    public void dataToGui(){
        //mDb.eventDao().deleteAll();

        mEventList = mDb.eventDao().getAllEvents(); //andere Abfrage??

        mEventAdapter.setApplicationLogic(this);
        mEventAdapter.setEventList(mEventList);
        mGui.getListView().setAdapter(mEventAdapter);
    }

    public void onListItemClicked(int position)
    {
        mData.setEventTitle(mEventList.get(position).getEventTitle());
        mData.setEventDateStart(mEventList.get(position).getEventDateStart());
        mData.setEventTimeStart(mEventList.get(position).getEventTimeStart());
        mData.setEventDateEnd(mEventList.get(position).getEventDateEnd());
        mData.setEventTimeEnd(mEventList.get(position).getEventTimeEnd());
        mData.setEventDescription(mEventList.get(position).getEventDescription());
        mData.setEventLocation(mEventList.get(position).getEventLocation());
        mData.setWithData(true);
        startActivity(Constants.ACTIVITYEVENTSDETAILVIEWCLASS, true);
    }

    public void onButtonDeleteEventClicked(View view)
    {
        View v = (View)view.getParent().getParent().getParent();
        TextView title = v.findViewById(R.id.homepage_event_title);
        TextView dateStart = v.findViewById(R.id.homepage_event_date);
        TextView timeStart = v.findViewById(R.id.homepage_event_time);
        Event eventToBeDeleted = mDb.eventDao().getEventByTitleDateTime(title.getText().toString(), dateStart.getText().toString(), timeStart.getText().toString());
        mDb.eventDao().deleteEvents(eventToBeDeleted);

        mActivity.recreate();
    }

    public void onTitleEventClicked(View view){
        View v = (View)view.getParent().getParent().getParent();
        startActivity(Constants.ACTIVITYEVENTSOVERVIEWCLASS, false);
    }

    public void onBackPressed(){
        Log.d("LOGTAG", "onBackPressed ...");
        finishActivityResultCanceled();

    }

    public void onActivityReturned(int requestCode, int resultCode, Intent intent) {
        Log.d("LOGTAG", "onActivityReturned ...");
        Log.d("LOGTAG", "  resultCode: " + resultCode);
        int value;
        if ( resultCode == Activity.RESULT_OK ) {
            switch (requestCode) {
                case Constants.REQUESTCODEONE:
                    mData.readIntentParametersOrSetDefaultValues(intent);
                    dataToGui();
                    break;
            }
        }
    }

    public void startActivity(Class<?> activityClass, boolean withData) //?: Elementtyp der Klasse ist offen
    {
        Intent intent = new Intent();
        intent.setClass(mData.getActivity(), activityClass);

        if(withData){ intent.putExtra(Constants.KEYDATABUNDLE, mData.getDataBundle());}
        intent.putExtra(Constants.KEYWITHDATA, withData);
        Log.d("LOGTAG", "withData: "+withData+"!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        mData.getActivity().startActivityForResult(intent, Constants.REQUESTCODEONE);
    }

    private void finishActivityResultOk()
    {
        Intent intent = new Intent();
        intent.putExtra(Constants.KEYDATABUNDLE, mData.getDataBundle());
        mData.getActivity().setResult(Activity.RESULT_OK, intent);
        Log.d("LOGTAG", "finishActivityResultOk");
        mData.getActivity().finish();
    }

    private void finishActivityResultCanceled()
    {
        Intent intent = new Intent();
        intent.putExtra(Constants.KEYDATABUNDLE, mData.getDataBundle());
        mData.getActivity().setResult(Activity.RESULT_CANCELED, intent);
        Log.d("LOGTAG", "finishActivityResultCancel");
        mData.getActivity().finish();
    }
}

