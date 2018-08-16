package wip.me.fhdw.de.tenmanager.ToDos;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;

import java.util.List;

import wip.me.fhdw.de.tenmanager.AppDatabase;
import wip.me.fhdw.de.tenmanager.Constants;

public class ApplicationLogicToDoOverview_Mona {

    private GuiToDoOverview_Mona mGui;
    private ToDoData_Mona mToDoData;
    private AppDatabase mDb;
    private List<ToDoOverview_Mona> mToDoList;
    private ToDoAdapter_Mona mToDoAdapter;

    public ApplicationLogicToDoOverview_Mona(ToDoData_Mona data, GuiToDoOverview_Mona gui, AppDatabase db, ToDoAdapter_Mona todoAdapter){
        mToDoData = data;
        mGui = gui;
        mDb = db;
        mToDoAdapter = todoAdapter;
        initGui();
        initListener();
    }

    public void initListener(){
        ListViewItemClickListener_Mona listViewItemClickListener = new ListViewItemClickListener_Mona(this);
        mGui.getListView().setOnItemClickListener(listViewItemClickListener);
        ToDoFloatingActionButtonClickListener_Mona floatingActionButtonClickListener = new ToDoFloatingActionButtonClickListener_Mona(this);
        if(mGui.getFabCreateNew() == null)Log.d("LOGTAG", "FAB ist null !!!!");
        mGui.getFabCreateNew().setOnClickListener(floatingActionButtonClickListener);
    }

    public void initGui(){
        dataToGui();
    }

    private void dataToGui() {
        mDb.todoDao().deleteAllToDos();
        String frühjahr = "- Fenster putzen \n- Waschen \n- Wischen";
        String Fertig = "18.12.2018";
        int Stand = 33;
        ToDoOverview_Mona frühjahrsputz = new ToDoOverview_Mona("Frühjahrsputz", frühjahr, Fertig, Stand);

        String Uni = "- GBI \n- IuF \n- PIT";
        String Faelligkeit = "12.12.2018";
        int Status = 66;
        ToDoOverview_Mona uniaufgaben = new ToDoOverview_Mona("Zu erledigende Uniaufgaben!", Uni, Faelligkeit, Status);
        mDb.todoDao().insertAll(frühjahrsputz, uniaufgaben);

        mToDoList = mDb.todoDao().getAllToDos();

        //ToDo Liste bearbeiten 2 Zeilen


        for (int i = 0 ; i < mToDoList.size(); i++)
        {
            mToDoList.get(i).setContent(mToDoList.get(i).getFirstTwoContentRows());
        }

        mToDoAdapter.setToDoList(mToDoList);
        mGui.getListView().setAdapter(mToDoAdapter);

    }

    public void onFabCreateNewClicked() {
        startActivity(Constants.ACTIVITYEVENTSDETAILVIEWCLASS, false);
    }

    private void startActivity(Class<?> activityClass, boolean withData) {
        Intent intent = new Intent();
        intent.setClass(mToDoData.getActivity(), activityClass);

        if(withData){ intent.putExtra(Constants.KEYDATABUNDLE, mToDoData.getDataBundle());}

        mToDoData.getActivity().startActivityForResult(intent, Constants.REQUESTCODEONE);
    }

    public void onListItemClicked(int position)
    {
        mToDoData.setToDoTitle(mToDoList.get(position).getTitle());
        startActivity(Constants.ACTIVITYEVENTSDETAILVIEWCLASS, true);
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
                    mToDoData.readIntentParametersOrSetDefaultValues(intent);
                    dataToGui();
                    break;
            }
        }
    }

    private void finishActivityResultOK() {
        Intent intent = new Intent();
        intent.putExtra(Constants.KEYDATABUNDLE, mToDoData.getDataBundle());
        mToDoData.getActivity().setResult(Activity.RESULT_OK, intent);
        Log.d("LOGTAG", "finishAktivityResultOK");
        mToDoData.getActivity().finish();
    }

    private void finishActivityResultCanceled() {
        Intent intent = new Intent();
        intent.putExtra(Constants.KEYDATABUNDLE, mToDoData.getDataBundle());
        mToDoData.getActivity().setResult(Activity.RESULT_CANCELED, intent);
        Log.d("LOGTAG", "finishAktivityResultCanceled");
        mToDoData.getActivity().finish();

    }
}
