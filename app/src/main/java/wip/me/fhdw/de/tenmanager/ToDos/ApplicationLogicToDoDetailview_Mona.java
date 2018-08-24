package wip.me.fhdw.de.tenmanager.ToDos;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import wip.me.fhdw.de.tenmanager.Constants;
import wip.me.fhdw.de.tenmanager.NavigationItemSelectListener;
import wip.me.fhdw.de.tenmanager.R;

public class ApplicationLogicToDoDetailview_Mona {

    private DatepickerToDoDetailview_Mona mDatepicker;
    private static final String TAG = "AppLogic_Sebastian";

    private wip.me.fhdw.de.tenmanager.ToDos.GuiToDoDetailview_Mona mGui;
    private wip.me.fhdw.de.tenmanager.ToDos.ToDoData_Mona mData;
    private Activity mActivity;
    private Context mContext;


    public ApplicationLogicToDoDetailview_Mona(Activity activity, ToDoData_Mona data, GuiToDoDetailview_Mona gui, Context context){
        mActivity = activity;
        mData = data;
        mGui = gui;
        mContext = context;
        initDatepicker();
        initGui();
        initListener();
    }

    public void initDatepicker(){
        mDatepicker = new DatepickerToDoDetailview_Mona(mGui);
    }

    public void initListener()
    {
        ToDoFloatingActionButtonClickListener_Mona fabClickListener = new ToDoFloatingActionButtonClickListener_Mona(this);
        mGui.getFabSave().setOnClickListener(fabClickListener);
        NavigationItemSelectListener navigationItemSelectListener = new NavigationItemSelectListener(this);
        mGui.getNavigationView().setNavigationItemSelectedListener(navigationItemSelectListener);
        ButtonNewTaskClickListener_Lena buttonNewTaskClickListener = new ButtonNewTaskClickListener_Lena(this);
        mGui.getTodoButtonNew().setOnClickListener(buttonNewTaskClickListener);
    }

    public void onFabSaveClicked()
    {
        boolean todoExists = false;
        String titleOld = mData.getToDoTitle();
        String title = mGui.getMtodotitle().getText().toString();
        if(mData.getDb().todoDao().todoExists(title) != 0) todoExists = true;
        if(!todoExists || mData.getWithData())
        {
            mData.setToDoTitle(mGui.getMtodotitle().getText().toString());
            String content="";
            for(int i=0; i< mGui.getListView().getCount(); i++)
            {
                Log.d("LOGTAG", "content: "+mGui.getListView().getAdapter().getItem(i)+"!!!!!!!!!!!!!!!!!!!!!");
                content = content+(String)mGui.getListView().getAdapter().getItem(i);
                content = content+",";
            }
            Log.d("LOGTAG", "content: "+content+"!!!!!!!!!!!!!!!!!!!!!");
            if(!mGui.getTodoEdittextNew().getText().toString().isEmpty()) content = content+", "+mGui.getTodoEdittextNew().getText().toString();
            mData.setToDoContent(content);
            Log.d("LOGTAG", "content: "+mData.getToDoContent()+"!!!!!!!!!!!!!!!!!!!!!");
            mData.setToDoDuedate(mGui.getMtodoDetailviewDueDate().getText().toString());
            mData.setToDoStaus(Integer.parseInt(mGui.getMtodoDetailviewStatus().getText().toString()));
        }
        if(mData.getWithData())
        {
            Log.d("LOGTAG", "Update wird aufgerufen!!!!!!!!!!!!!!!!!!!!!!!");
            mData.updateTodo(titleOld);
        }
        else
        {
            if(todoExists)
            {
                Toast.makeText(mData.getActivity().getApplicationContext(), "Es gibt bereits ein ToDo mit diesem Titel!", Toast.LENGTH_LONG).show();
                return;
            }
            mData.createAndSaveNewTodo();
        }
        finishActivityResultOk();
    }

    public void onButtonNewTaskClicked()
    {
        Log.d("LOGTAG", "Content: "+mData.getToDoContent().toString()+"!!!!!!!!!!!!!!!!!!");
        mData.setToDoContent(mData.getToDoContent()+mGui.getTodoEdittextNew().getText().toString()+", ");
        Log.d("LOGTAG", "Content: "+ mData.getToDoContent().toString()+"!!!!!!!!!!!!!!!!!!");
        mData.updateTodo(mData.getToDoTitle());
        mGui.getTodoEdittextNew().setText("");
        dataToGui();
    }

    public void onMenuItemSelected(MenuItem item)
    {
        int id = item.getItemId();

        if (id == R.id.menuNotes) {

            startActivity(Constants.ACTIVITYNOTEOVERVIEWCLASS, false);
            mData.getActivity().overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);

        } else if (id == R.id.menuEvent) {

            startActivity(Constants.ACTIVITYEVENTSOVERVIEWCLASS, false);
            mData.getActivity().overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);

        } else if (id == R.id.menuTodo) {

            startActivity(Constants.ACTIVITYTODOOVERVIEWCLASS, false);
            mData.getActivity().overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
        }

        DrawerLayout drawer = (DrawerLayout) mActivity.findViewById(R.id.drawer);
        drawer.closeDrawer(GravityCompat.START);
    }


    public void onBackPressed() {
        Log.d("LOGTAG", "onBackPress called");
        finishActivityResultCancelled();
    }

    public void startActivity(Class<?> activityClass, boolean withData) //?: Elementtyp der Klasse ist offen
    {
        Intent intent = new Intent();
        intent.setClass(mData.getActivity(), activityClass);

        if(withData){ intent.putExtra(Constants.KEYDATABUNDLE, mData.getDataBundle());}

        mData.getActivity().startActivityForResult(intent, Constants.REQUESTCODEONE);
    }

    //finish Activities
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

    private void dataToGui() {
        mGui.getMtodotitle().setText(mData.getToDoTitle());

        if(mData.getWithData()) {
            ToDoDetailviewAdapter_Lena adapter = new ToDoDetailviewAdapter_Lena(mContext);
            List<String> contentList = new ArrayList<>();
            int startindex = 0;
            String content = mData.getToDoContent();
            Log.d("LOGTAG", "content der ausgelesen wird: "+content+"!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            for (int i = 0; i < content.length(); i++) {
                if (content.charAt(i) == ',') {
                    contentList.add(content.substring(startindex, i));
                    startindex = i + 1;
                }
            }
            adapter.setContentList(contentList);
            mGui.getListView().setAdapter(adapter);
        }

        mGui.getMtodoDetailviewDueDate().setText(mData.getToDoDuedate());
        mGui.getMtodoDetailviewStatus().setText(String.valueOf(mData.getToDoStatus()));
    }

    private void initGui() {
        dataToGui();
    }


    private void finishActivityResultOk()
    {
        Intent intent = new Intent();
        intent.putExtra(Constants.KEYDATABUNDLE, mData.getDataBundle());
        mData.getActivity().setResult(Activity.RESULT_OK, intent);
        Log.d("LOGTAG", "finishActivityResultOk");
        mData.getActivity().finish();
    }



    private void finishActivityResultCancelled() {
        Intent intent = new Intent();
        intent.putExtra(Constants.KEYDATABUNDLE, mData.getDataBundle());
        mData.getActivity().setResult(Activity.RESULT_CANCELED, intent);
        Log.d("LOGTAG", "finishActivityResultCancel");
        mData.getActivity().finish();
    }
}
