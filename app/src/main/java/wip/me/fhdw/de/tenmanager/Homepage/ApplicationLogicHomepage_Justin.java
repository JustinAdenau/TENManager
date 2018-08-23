package wip.me.fhdw.de.tenmanager.Homepage;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import wip.me.fhdw.de.tenmanager.AppDatabase;
import wip.me.fhdw.de.tenmanager.Constants;
import wip.me.fhdw.de.tenmanager.Event;
import wip.me.fhdw.de.tenmanager.Events.EventData_Lena;
import wip.me.fhdw.de.tenmanager.NavigationItemSelectListener;
import wip.me.fhdw.de.tenmanager.R;
import wip.me.fhdw.de.tenmanager.ToDos.ToDoData_Mona;
import wip.me.fhdw.de.tenmanager.ToDos.ToDoOverview_Mona;

public class ApplicationLogicHomepage_Justin {
    private GuiHomepage_Justin mGui;
    private AppDatabase mDb;

    private List<Event> mEventList;
    private List<ToDoOverview_Mona> mTodoList;

    private EventAdapter_Justin mEventAdapter;
    private ToDoAdapter_Justin mTodoAdapter;

    private Activity mActivity;

    private wip.me.fhdw.de.tenmanager.Events.EventData_Lena mEventData;
    private wip.me.fhdw.de.tenmanager.ToDos.ToDoData_Mona mTodoData;


    public ApplicationLogicHomepage_Justin(Activity activity, EventData_Lena eventData, ToDoData_Mona todoData,
                                           GuiHomepage_Justin gui, AppDatabase db, ToDoAdapter_Justin todoAdapter,
                                           EventAdapter_Justin eventAdapter){
        mActivity = activity;
        mEventData = eventData;
        mTodoData = todoData;
        mGui = gui;
        mDb = db;
        mTodoAdapter = todoAdapter;
        mEventAdapter = eventAdapter;
        initGui();
        initListener();
    }

    public void initGui(){
        dataToGui();

    }

    public void initListener(){
        EventListViewItemClickListener_Justin eventListViewItemClickListener = new EventListViewItemClickListener_Justin(this);
        mGui.getEventListView().setOnItemClickListener(eventListViewItemClickListener);
        ToDoListViewItemClickListener_Justin todoListViewItemClickListener = new ToDoListViewItemClickListener_Justin(this);
        mGui.getTodoListView().setOnItemClickListener(todoListViewItemClickListener);

        ButtonDeleteEventClickListener_Justin buttonDeleteEventClickListener = new ButtonDeleteEventClickListener_Justin(this);
        mGui.getButtonDeleteEvent().setOnClickListener(buttonDeleteEventClickListener);
        ButtonDeleteToDoClickListener_Justin buttonDeleteTodoClickListener = new ButtonDeleteToDoClickListener_Justin(this);
        mGui.getButtonDeleteTodo().setOnClickListener(buttonDeleteTodoClickListener);

        TitleEventClickListener titleEventClickListener = new TitleEventClickListener(this);
        mGui.getEventHeader().setOnClickListener(titleEventClickListener);
        TitleTodoClickListener titleTodoClickListener = new TitleTodoClickListener(this);
        mGui.getTodoHeader().setOnClickListener(titleTodoClickListener);

        NavigationItemSelectListener navigationItemSelectListener = new NavigationItemSelectListener(this);
        mGui.getNavigationView().setNavigationItemSelectedListener(navigationItemSelectListener);
    }

    public void dataToGui(){
        //mDb.eventDao().deleteAll();

        // Setting Current Date in Gui
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
        Date date = new Date();

        //mEventList = mDb.eventDao().getAllEvents(); //andere Abfrage??
        mEventList = mDb.eventDao().getEventsToday((formatter.format(date).toString()));
        mTodoList = mDb.todoDao().getAllToDos(); //andere Abfrage??

        mEventAdapter.setApplicationLogic(this);
        mEventAdapter.setEventList(mEventList);
        mTodoAdapter.setApplicationLogic(this);
        mTodoAdapter.setToDoList(mTodoList);



        mGui.getmCurrentDate().setText(formatter.format(date));

        mGui.getEventListView().setAdapter(mEventAdapter);
        mGui.getTodoListView().setAdapter(mTodoAdapter);
    }

    public void onEventListItemClicked(int position)
    {
        mEventData.setEventTitle(mEventList.get(position).getEventTitle());
        mEventData.setEventDateStart(mEventList.get(position).getEventDateStart());
        mEventData.setEventTimeStart(mEventList.get(position).getEventTimeStart());
        mEventData.setEventDateEnd(mEventList.get(position).getEventDateEnd());
        mEventData.setEventTimeEnd(mEventList.get(position).getEventTimeEnd());
        mEventData.setEventDescription(mEventList.get(position).getEventDescription());
        mEventData.setEventLocation(mEventList.get(position).getEventLocation());
        mEventData.setWithData(true);
        startActivity(Constants.ACTIVITYEVENTSDETAILVIEWCLASS, true);
        mEventData.getActivity().overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
    }

    public void onTodoListItemClicked(int position)
    {
        mTodoData.setToDoTitle(mTodoList.get(position).getTitle());
        startActivity(Constants.ACTIVITYTODODETAILVIEWCLASS, true);
        mTodoData.getActivity().overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
    }

    public void onMenuItemSelected(MenuItem item)
    {
        int id = item.getItemId();

        if (id == R.id.menuNotes) {

            startActivity(Constants.ACTIVITYNOTEOVERVIEWCLASS, false);
            mEventData.getActivity().overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);

        } else if (id == R.id.menuTodo) {

            startActivity(Constants.ACTIVITYTODOOVERVIEWCLASS, false);
            mEventData.getActivity().overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
        }

        else if (id==R.id.menuEvent){
            startActivity(Constants.ACTIVITYEVENTSOVERVIEWCLASS, false);
            mEventData.getActivity().overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
        }

        DrawerLayout drawer = (DrawerLayout) mActivity.findViewById(R.id.drawer_homepage);
        drawer.closeDrawer(GravityCompat.START);
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

    public void onButtonDeleteTodoClicked(View view)
    {
        View v = (View)view.getParent().getParent().getParent();
        TextView title = v.findViewById(R.id.listviewitem_textview_title_todo);
        TextView checkbox1 = v.findViewById(R.id.todoCheckBox1);
        TextView checkbox2 = v.findViewById(R.id.todoCheckBox2);
        TextView dueDate = v.findViewById(R.id.todoDuedate);

        ToDoOverview_Mona todoToBeDeleted = mDb.todoDao().getToDoByToDoElements(title.getText().toString());
        mDb.todoDao().deleteToDos(todoToBeDeleted);

        mActivity.recreate();
    }

    public void onTitleEventClicked(View view){
        View v = (View)view.getParent().getParent().getParent();
        startActivity(Constants.ACTIVITYEVENTSOVERVIEWCLASS, false);
    }

    public void onTitleTodoClicked(View view){
        View v = (View)view.getParent().getParent().getParent();
        startActivity(Constants.ACTIVITYTODOOVERVIEWCLASS, false);
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
                    mEventData.readIntentParametersOrSetDefaultValues(intent);
                    dataToGui();
                    break;
            }
        }
    }

    public void startActivity(Class<?> activityClass, boolean withData) //?: Elementtyp der Klasse ist offen
    {
        Intent intent = new Intent();
        intent.setClass(mEventData.getActivity(), activityClass);

        if(withData){ intent.putExtra(Constants.KEYDATABUNDLE, mEventData.getDataBundle());}
        intent.putExtra(Constants.KEYWITHDATA, withData);
        Log.d("LOGTAG", "withData: "+withData+"!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        mEventData.getActivity().startActivityForResult(intent, Constants.REQUESTCODEONE);
    }

    private void finishActivityResultOk()
    {
        Intent intent = new Intent();
        intent.putExtra(Constants.KEYDATABUNDLE, mEventData.getDataBundle());
        mEventData.getActivity().setResult(Activity.RESULT_OK, intent);
        Log.d("LOGTAG", "finishActivityResultOk");
        mEventData.getActivity().finish();
    }

    private void finishActivityResultCanceled()
    {
        Intent intent = new Intent();
        intent.putExtra(Constants.KEYDATABUNDLE, mEventData.getDataBundle());
        mEventData.getActivity().setResult(Activity.RESULT_CANCELED, intent);
        Log.d("LOGTAG", "finishActivityResultCancel");
        mEventData.getActivity().finish();
    }
}

