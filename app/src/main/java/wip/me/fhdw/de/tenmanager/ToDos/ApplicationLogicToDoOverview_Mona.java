package wip.me.fhdw.de.tenmanager.ToDos;

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

public class ApplicationLogicToDoOverview_Mona {

    private GuiToDoOverview_Mona mGui;
    private ToDoData_Mona mToDoData;
    private AppDatabase mDb;
    private List<ToDo_Mona> mToDoList;
    private ToDoAdapter_Mona mToDoAdapter;
    private Activity mActivity;

    public ApplicationLogicToDoOverview_Mona(ToDoData_Mona data, GuiToDoOverview_Mona gui, AppDatabase db, ToDoAdapter_Mona todoAdapter, Activity activity){
        mToDoData = data;
        mGui = gui;
        mDb = db;
        mToDoAdapter = todoAdapter;
        initGui();
        initListener();
        mActivity = activity;
    }

    public void initListener(){
        ListViewItemClickListener_Mona listViewItemClickListener = new ListViewItemClickListener_Mona(this);
        mGui.getListView().setOnItemClickListener(listViewItemClickListener);
        ToDoFloatingActionButtonClickListener_Mona floatingActionButtonClickListener = new ToDoFloatingActionButtonClickListener_Mona(this);
        if(mGui.getFabCreateNew() == null)Log.d("LOGTAG", "FAB ist null !!!!");
        mGui.getFabCreateNew().setOnClickListener(floatingActionButtonClickListener);
        NavigationItemSelectListener_Lena navigationItemSelectListener = new NavigationItemSelectListener_Lena(this);
        mGui.getNavigationView().setNavigationItemSelectedListener(navigationItemSelectListener);
        ButtonDeleteToDoClickListener_Mona buttonDeleteClickListener = new ButtonDeleteToDoClickListener_Mona(this);
        mGui.getButtonDelete().setOnClickListener(buttonDeleteClickListener);
    }

    public void initGui(){
        dataToGui();
    }

    private void dataToGui() {

        //mDb.todoDao().deleteAllToDos();
        //ToDo_Mona todoNew = new ToDo_Mona("Fertig werden!!!", "eventDetailview, todos, fotos,", "23.08.2018", 50, "010");
        //mDb.todoDao().insertAll(todoNew);
        mToDoList = mDb.todoDao().getAllToDos();

        mToDoAdapter.setToDoList(mToDoList);
        mToDoAdapter.setApplicationLogic(this);
        mToDoAdapter.setCheckboxActivated(mToDoData.getToDoCheckboxActivated());
        mGui.getListView().setAdapter(mToDoAdapter);
    }

    public void onFabCreateNewClicked() {
        startActivity(Constants.ACTIVITYTODODETAILVIEWCLASS, false);
        mToDoData.getActivity().overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
    }

    public void onMenuItemSelected(MenuItem item)
    {
        int id = item.getItemId();

        if(id == R.id.menuHome)
        {
            startActivity(Constants.ACTIVITYHOMEPAGECLASS, false);
            mToDoData.getActivity().overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
        }
        else if (id == R.id.menuNotes) {

            startActivity(Constants.ACTIVITYNOTEOVERVIEWCLASS, false);
            mToDoData.getActivity().overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);

        } else if (id == R.id.menuEvent) {

            startActivity(Constants.ACTIVITYEVENTSOVERVIEWCLASS, false);
            mToDoData.getActivity().overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);

        }

        DrawerLayout drawer = (DrawerLayout) mActivity.findViewById(R.id.drawer);
        drawer.closeDrawer(GravityCompat.START);
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
        mToDoData.setToDoContent(mToDoList.get(position).getContent());
        mToDoData.setToDoDuedate(mToDoList.get(position).getDuedate());
        mToDoData.setToDoStaus(mToDoList.get(position).getStatus());
        mToDoData.setToDoCheckboxActivated(mToDoList.get(position).getCheckboxActivated());
        mToDoData.setWithData(true);
        startActivity(Constants.ACTIVITYTODODETAILVIEWCLASS, true);
        mToDoData.getActivity().overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
    }

    public void onBackPressed(){
        Log.d("LOGTAG", "onBackPressed ...");
        finishActivityResultCanceled();

    }

    public void onActivityReturned(int requestCode, int resultCode, Intent intent) {
        Log.d("LOGTAG", "onActivityReturned ...");
        Log.d("LOGTAG", "  resultCode: " + resultCode);
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
        mToDoData.getActivity().overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right);
    }

    private void finishActivityResultCanceled() {
        Intent intent = new Intent();
        intent.putExtra(Constants.KEYDATABUNDLE, mToDoData.getDataBundle());
        mToDoData.getActivity().setResult(Activity.RESULT_CANCELED, intent);
        Log.d("LOGTAG", "finishActivityResultCanceled");
        mToDoData.getActivity().finish();
        mToDoData.getActivity().overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right);
    }



    public void onButtonDeleteToDoClicked(View view) {
        Log.d("LOGTAG", "ButtonDelete wurde angeklickt!!!!!!!!!!!!!!!!");
        View v = (View)view.getParent().getParent().getParent();
        TextView title = v.findViewById(R.id.listviewitem_textview_title_todo);
        if(title == null) Log.d("LOGTAG", "Title ist null!!!!!!!!!!!!!!!!!!");
        else Log.d("LOGTAG", "Title ist nicht null!!!!!!!!!!!!!!!!!!");
        ToDo_Mona todoToBeDeleted = mDb.todoDao().getTodoByTitle(title.getText().toString());
        mDb.todoDao().deleteToDos(todoToBeDeleted);

        mActivity.recreate();
    }
}