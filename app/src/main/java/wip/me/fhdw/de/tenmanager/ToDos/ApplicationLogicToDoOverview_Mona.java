package wip.me.fhdw.de.tenmanager.ToDos;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;

import java.util.List;

import wip.me.fhdw.de.tenmanager.AppDatabase;
import wip.me.fhdw.de.tenmanager.Constants;

public class ApplicationLogicToDoOverview_Mona {

    private GuiToDoOverview_Mona mGui;
    private ToDoOverviewData_Mona mToDoData;
    private AppDatabase mDb;
    private ToDoOverviewAdapter_Mona mToDoAdapter;
    private List<ToDoOverview_Mona> mToDoList;

    public ApplicationLogicToDoOverview_Mona(ToDoOverviewData_Mona data, GuiToDoOverview_Mona gui, AppDatabase db, ToDoOverviewAdapter_Mona noteAdapter){
        mToDoData = data;
        mGui = gui;
        mDb = db;
        mToDoAdapter = noteAdapter;
        initGui();
        initListener();
    }

    public void initListener(){

    }

    public void initGui(){
        dataToGui();
    }

    private void dataToGui() {
        //mDb.todoDao().deleteAllToDos();

        ToDoOverview_Mona hausputz = new ToDoOverview_Mona("Hausputz", "Fenster, Küche, Bad", "20.08.2018", 0);
        ToDoOverview_Mona uni = new ToDoOverview_Mona("Uni", "WIP, PIT, GBI, IuF", "25.09.2018", 3);
        mDb.todoDao().insertAll(hausputz, uni);

        mToDoList = mDb.todoDao().getAllToDos();
        mToDoAdapter.setApplicationLogic(this);
        mToDoAdapter.setToDoList(mToDoList);
        mGui.getListView().setAdapter(mToDoAdapter);
    }

    public void onActivityReturned(int requestCode, int resultCode, Intent intent) {
        Log.d("LOGTAG", "onActivityReturned ...");
        Log.d("LOGTAG", "  resultCode: " + resultCode);
        if ( resultCode == Activity.RESULT_OK ) {
            switch (requestCode) {
                case Constants.REQUESTCODEONE:
                    //ToDoOverviewData_Mona.readIntentParametersOrSetDefaultValues(intent);
                    dataToGui();
                    break;
            }
        }
    }

    public void onBackPressed(){
        Log.d("LOGTAG", "onBackPressed ...");
        finishActivityResultCanceled();
    }

    private void finishActivityResultCanceled() {
        Intent intent = new Intent();
        intent.putExtra(Constants.KEYDATABUNDLE, mToDoData.getDataBundle());
        mToDoData.getActivity().setResult(Activity.RESULT_CANCELED, intent);
        Log.d("LOGTAG", "finishActivityResultCanceled");
        mToDoData.getActivity().finish();
    }

    public void onFabCreateNewClicked()
    {
        //TODO change constant
        startActivity(Constants.ACTIVITYEVENTSDETAILVIEWCLASS, false);
    }

    public void startActivity(Class<?> activityClass, boolean withData) //?: Elementtyp der Klasse ist offen
    {
        Intent intent = new Intent();
        intent.setClass(mToDoData.getActivity(), activityClass);

        if(withData){ intent.putExtra(Constants.KEYDATABUNDLE, mToDoData.getDataBundle());}

        mToDoData.getActivity().startActivityForResult(intent, Constants.REQUESTCODEONE);
    }
}
