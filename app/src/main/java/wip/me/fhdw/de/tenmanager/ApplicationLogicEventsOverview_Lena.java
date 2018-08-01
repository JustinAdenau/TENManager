package wip.me.fhdw.de.tenmanager;

import android.app.Activity;
import android.arch.persistence.room.Room;
import android.content.Intent;
import android.provider.SyncStateContract;
import android.util.Log;
import android.widget.EditText;
import android.widget.ListView;

import java.util.List;

public class ApplicationLogicEventsOverview_Lena {

    private Data mData;
    private GuiEventsOverview_Lena mGui;
    private AppDatabase mDb;
    private List<Event> mEventList;
    private EventAdapter_Lena mEventAdapter;


    public ApplicationLogicEventsOverview_Lena(Data data, GuiEventsOverview_Lena gui, AppDatabase db, EventAdapter_Lena eventAdapter)
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
        if(mGui.getFabCreateNew() == null)Log.d("LOGTAG", "FAB ist null !!!!");
        mGui.getFabCreateNew().setOnClickListener(floatingActionButtonClickListener);
    }



    public void dataToGui()
    {

        mDb.eventDao().deleteAll();
        Event geburtstag = new Event("Geburtstagsfeier", "20.07.2018", "20:00", "Jana feiert ihren Geburtstag bei ihr im Garten", "Garten", "4");
        Event weihnachten = new Event("Weihnachten", "24.12.2018", "ganztägig", "", "Zuhause", "24");
        Event gartenparty = new Event("Gartenparty", "02.08.2018", "15:00", "bei Lisa im Garten", "Garten", "2");
        Event grillen = new Event("Grillen", "26.07.2018", "18:00", "", "bei Kathi", "1");
        Event schwimmen = new Event("Schwimmen gehen", "27.07.2018", "14:00", "", "Freibad Kettwig", "3");

        mDb.eventDao().insertAll(geburtstag, weihnachten, gartenparty, grillen, schwimmen);
        mEventList = mDb.eventDao().getAllEvents();

        mEventAdapter.setEventList(mEventList);
        mGui.getListView().setAdapter(mEventAdapter);
    }


    public void onListItemClicked(int position)
    {
        mData.setEventTitle(mEventList.get(position).getEventTitle());
        mData.setEventDate(mEventList.get(position).getEventDate());
        mData.setEventTime(mEventList.get(position).getEventTime());
        mData.setEventDescription(mEventList.get(position).getEventDescription());
        mData.setEventLocation(mEventList.get(position).getEventLocation());
        mData.setEventSpan(mEventList.get(position).getEventSpan());
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
