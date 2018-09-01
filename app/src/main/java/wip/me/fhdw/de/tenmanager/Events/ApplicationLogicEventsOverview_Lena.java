package wip.me.fhdw.de.tenmanager.Events;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.List;

import wip.me.fhdw.de.tenmanager.AppDatabase;
import wip.me.fhdw.de.tenmanager.Constants;


import wip.me.fhdw.de.tenmanager.NavigationItemSelectListener_Lena;
import wip.me.fhdw.de.tenmanager.R;

public class ApplicationLogicEventsOverview_Lena {

    //instance variables
    private wip.me.fhdw.de.tenmanager.Events.EventData_Lena mData;
    private wip.me.fhdw.de.tenmanager.Events.GuiEventsOverview_Lena mGui;
    private AppDatabase mDb;
    private List<Event_Lena> mEventList;
    private wip.me.fhdw.de.tenmanager.Events.EventAdapter_Lena mEventAdapter;
    private Activity mActivity;

    //constructor
    public ApplicationLogicEventsOverview_Lena(Activity activity, EventData_Lena data, GuiEventsOverview_Lena gui, AppDatabase db, EventAdapter_Lena eventAdapter)
    {
        mActivity = activity;
        mData = data;
        mGui = gui;
        mDb = db;
        mEventAdapter = eventAdapter;
        initGui();
        initListener();
    }


    //declaration and initializing of Listeners and setting to button objects, ListView and NavigationView
    public void initListener()
    {
        ListViewItemClickListener_Lena listViewItemClickListener = new ListViewItemClickListener_Lena(this);
        mGui.getListView().setOnItemClickListener(listViewItemClickListener);
        EventFloatingActionButtonClickListener_Lena floatingActionButtonClickListener = new EventFloatingActionButtonClickListener_Lena(this);
        mGui.getFabCreateNew().setOnClickListener(floatingActionButtonClickListener);
        ButtonDeleteEventClickListener_Lena buttonDeleteEventClickListener = new ButtonDeleteEventClickListener_Lena(this);
        mGui.getButtonDeleteEvent().setOnClickListener(buttonDeleteEventClickListener);
        NavigationItemSelectListener_Lena navigationItemSelectListener = new NavigationItemSelectListener_Lena(this);
        mGui.getNavigationView().setNavigationItemSelectedListener(navigationItemSelectListener);
    }

    public void initGui(){dataToGui();}

    //get List of Events from Database, set ApplicationLogic + list to Adapter and set adapter to ListVIew
    public void dataToGui()
    {
        mEventList = mDb.eventDao().getAllEvents();
        mEventAdapter.setApplicationLogic(this);
        mEventAdapter.setEventList(mEventList);
        mGui.getListView().setAdapter(mEventAdapter);
    }

    //all atributes of Event are set to EventData and Activity is started with animations
    public void onListItemClicked(int position)
    {
        mData.setEventTitle(mEventList.get(position).getEventTitle());
        mData.setEventDateStart(mEventList.get(position).getEventDateStart());
        mData.setEventTimeStart(mEventList.get(position).getEventTimeStart());
        mData.setEventDateEnd(mEventList.get(position).getEventDateEnd());
        mData.setEventTimeEnd(mEventList.get(position).getEventTimeEnd());
        mData.setEventDescription(mEventList.get(position).getEventDescription());
        mData.setEventLocation(mEventList.get(position).getEventLocation());
        mData.setEventTimeReminder(mEventList.get(position).getEventTimeReminder());
        mData.setWithData(true);
        startActivity(Constants.ACTIVITYEVENTSDETAILVIEWCLASS, true);
        mData.getActivity().overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
    }

    //activity EventsDetailView_Sebastian is called without data to add a new Event to database
    public void onFabCreateNewClicked()
    {
        startActivity(Constants.ACTIVITYEVENTSDETAILVIEWCLASS, false);
        mData.getActivity().overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
    }

    //TextViews title, dateStart and timeStart are initialized, search Event in database, delete Event from database, reload Activity to reload ListView
    public void onButtonDeleteEventClicked(View view)
    {
        View v = (View)view.getParent().getParent().getParent();
        TextView title = v.findViewById(R.id.listviewitem_textview_event_title);
        TextView dateStart = v.findViewById(R.id.listviewitem_textview_dateStart);
        TextView timeStart = v.findViewById(R.id.listviewitem_textview_timeStart);
        Event_Lena eventToBeDeleted = mDb.eventDao().getEventByTitleDateTime(title.getText().toString(), dateStart.getText().toString(), timeStart.getText().toString());
        mDb.eventDao().deleteEvents(eventToBeDeleted);

        mActivity.recreate();
    }

    //compare id of item that called method with ids of all MenuItems, start right activity
    public void onMenuItemSelected(MenuItem item)
    {
        int id = item.getItemId();

        if(id == R.id.menuHome)
        {
            startActivity(Constants.ACTIVITYHOMEPAGECLASS, false);
            mData.getActivity().overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
        }
        else if (id == R.id.menuNotes) {

            startActivity(Constants.ACTIVITYNOTEOVERVIEWCLASS, false);
            mData.getActivity().overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);

        } else if (id == R.id.menuTodo) {

            startActivity(Constants.ACTIVITYTODOOVERVIEWCLASS, false);
            mData.getActivity().overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
        }

        DrawerLayout drawer = (DrawerLayout) mActivity.findViewById(R.id.drawer);
        drawer.closeDrawer(GravityCompat.START);
    }



    //finish activity with result: cancelled
    public void onBackPressed()
    {
        Log.d("LOGTAG", "onBackPress called");
        finishActivityResultCancelled();
    }

    //proof resultCode and requestCode and set attributes in EventData, put data to gui
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
        intent.putExtra(Constants.KEYWITHDATA, withData);
        Log.d("LOGTAG", "withData: "+withData+"!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        mData.getActivity().startActivityForResult(intent, Constants.REQUESTCODEONE);
    }

    private void finishActivityResultCancelled()
    {
        Intent intent = new Intent();
        intent.putExtra(Constants.KEYDATABUNDLE, mData.getDataBundle());
        mData.getActivity().setResult(Activity.RESULT_CANCELED, intent);
        Log.d("LOGTAG", "finishActivityResultCancel");
        mData.getActivity().finish();
        mData.getActivity().overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right);
    }
}
