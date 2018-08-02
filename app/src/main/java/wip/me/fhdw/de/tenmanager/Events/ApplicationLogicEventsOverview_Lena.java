package wip.me.fhdw.de.tenmanager.Events;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;

import java.util.List;

import wip.me.fhdw.de.tenmanager.AppDatabase;
import wip.me.fhdw.de.tenmanager.Constants;
import wip.me.fhdw.de.tenmanager.Event;


public class ApplicationLogicEventsOverview_Lena {

    private wip.me.fhdw.de.tenmanager.Events.EventData_Lena mData;
    private wip.me.fhdw.de.tenmanager.Events.GuiEventsOverview_Lena mGui;
    private AppDatabase mDb;
    private List<Event> mEventList;
    private wip.me.fhdw.de.tenmanager.Events.EventAdapter_Lena mEventAdapter;


    public ApplicationLogicEventsOverview_Lena(EventData_Lena data, GuiEventsOverview_Lena gui, AppDatabase db, EventAdapter_Lena eventAdapter)
    {
        mData = data;
        mGui = gui;
        mDb = db;
        mEventAdapter = eventAdapter;
        initGui();
        initListener();
    }

    public void initGui(){dataToGui();}

    public void initListener()
    {
        ListViewItemClickListener_Lena listViewItemClickListener = new ListViewItemClickListener_Lena(this);
        mGui.getListView().setOnItemClickListener(listViewItemClickListener);
        FloatingActionButtonClickListener_Lena floatingActionButtonClickListener = new FloatingActionButtonClickListener_Lena(this);
        mGui.getFabCreateNew().setOnClickListener(floatingActionButtonClickListener);
    }



    public void dataToGui()
    {
        //mDb.eventDao().deleteAll();

        mEventList = mDb.eventDao().getAllEvents();

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
        startActivity(Constants.ACTIVITYEVENTSDETAILVIEWCLASS, true);
    }

    public void onFabCreateNewClicked()
    {
        startActivity(Constants.ACTIVITYEVENTSDETAILVIEWCLASS, false);
    }


    public void onBackPressed()
    {
        Log.d("LOGTAG", "onBackPress called");
        finishActivityResultCancelled();
    }

    public void onActivityReturned(int requestCode, int resultCode, Intent intent)
    {
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



    // activities
    public void startActivity(Class<?> activityClass, boolean withData) //?: Elementtyp der Klasse ist offen
    {
        Intent intent = new Intent();
        intent.setClass(mData.getActivity(), activityClass);

        if(withData){ intent.putExtra(Constants.KEYDATABUNDLE, mData.getDataBundle());}

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

    private void finishActivityResultCancelled()
    {
        Intent intent = new Intent();
        intent.putExtra(Constants.KEYDATABUNDLE, mData.getDataBundle());
        mData.getActivity().setResult(Activity.RESULT_CANCELED, intent);
        Log.d("LOGTAG", "finishActivityResultCancel");
        mData.getActivity().finish();
    }
}
