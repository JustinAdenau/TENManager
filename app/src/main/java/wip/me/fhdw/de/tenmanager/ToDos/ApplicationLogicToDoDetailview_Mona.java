package wip.me.fhdw.de.tenmanager.ToDos;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import wip.me.fhdw.de.tenmanager.Constants;
import wip.me.fhdw.de.tenmanager.NavigationItemSelectListener_Lena;
import wip.me.fhdw.de.tenmanager.R;

public class ApplicationLogicToDoDetailview_Mona {

    private DatepickerToDoDetailview_Mona mDatepicker;

    private wip.me.fhdw.de.tenmanager.ToDos.GuiToDoDetailview_Mona mGui;
    private wip.me.fhdw.de.tenmanager.ToDos.ToDoData_Mona mData;
    private Activity mActivity;
    private Context mContext;
    private ToDoDetailviewAdapter_Lena mAdapter;
    private List<String> mContentList;


    public ApplicationLogicToDoDetailview_Mona(Activity activity, ToDoData_Mona data, GuiToDoDetailview_Mona gui, Context context){
        mActivity = activity;
        mData = data;
        mGui = gui;
        mContext = context;
        initDatepicker();
        initGui();
        initDatepicker();
        initListener();
    }


    //init

    private void initGui() {
        mContentList = new ArrayList<>();
        mAdapter = new ToDoDetailviewAdapter_Lena(mContext);
        mAdapter.setContentList(mContentList);
        mAdapter.setActivity(mActivity);
        mAdapter.setApplicationLogic(this);
        dataToGui();
    }

    public void initDatepicker()
    {
        mDatepicker = new DatepickerToDoDetailview_Mona(mGui);
        mDatepicker.buildDateStartDuedatepicker();
        mDatepicker.setDuedateToButton();
    }

    private void initCurrentDate() {
        if (mGui.getTodoDetailviewButtonDuedate().getText().toString().matches("\\d{2}.\\d{2}.\\d{4}")){Log.d("LOGTAG", "Button schon mit Datum befüllt!!!!!!!!!!!!!!!!!!!!!!!!"); return;}
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        month = month + 1;

        mGui.getTodoDetailviewButtonDuedate().setText(String.format("%02d.%02d.%04d", day, month, year));
        mGui.getTodoDetailviewButtonDuedate().setText(String.format("%02d.%02d.%04d", day, month, year));
    }

    public void initListener()
    {
        ToDoFloatingActionButtonClickListener_Mona fabClickListener = new ToDoFloatingActionButtonClickListener_Mona(this);
        mGui.getFabSave().setOnClickListener(fabClickListener);
        NavigationItemSelectListener_Lena navigationItemSelectListener = new NavigationItemSelectListener_Lena(this);
        mGui.getNavigationView().setNavigationItemSelectedListener(navigationItemSelectListener);
        ButtonNewTaskClickListener_Lena buttonNewTaskClickListener = new ButtonNewTaskClickListener_Lena(this);
        mGui.getTodoButtonNew().setOnClickListener(buttonNewTaskClickListener);
    }




    private void dataToGui() {
        mGui.getTodoDetailviewTitle().setText(mData.getToDoTitle());
        if(mData.getWithData()) {
            mContentList = buildContentList(mData.getToDoContent());
            mAdapter.setContentList(mContentList);
            mAdapter.setCheckboxActivated(mData.getToDoCheckboxActivated());
        }
        mGui.getListView().setAdapter(mAdapter);
        mGui.getTodoDetailviewButtonDuedate().setText(mData.getToDoDuedate());
        mGui.getTodoDetailviewTextviewStatus().setText(String.valueOf(mData.getToDoStatus())+"/100%");
        initCurrentDate();
    }



    //build data attributes

    public String buildContentStringFromGui()
    {
        String content = "";
        for(int i=0; i< mGui.getListView().getCount(); i++)
        {
            content = content+(String)mGui.getListView().getAdapter().getItem(i);
            content = content+",";
        }
        if(!mGui.getTodoEdittextNew().getText().toString().isEmpty()) content = content+mGui.getTodoEdittextNew().getText().toString()+",";
        return content;
    }

    public String buildCheckboxActivated()
    {
        String checkboxActivated = "";
        for (int i=0; i<mGui.getListView().getCount(); i++)
        {
            CheckBox checkbox = mAdapter.getCheckboxList().get(i);
            if(checkbox.isChecked()) checkboxActivated = checkboxActivated+"1";
            else checkboxActivated = checkboxActivated+"0";
        }
        return checkboxActivated;
    }

    public List<String> buildContentList(String content)
    {
        int startindex = 0;
        List<String> contentList = new ArrayList<>();
        for (int i = 0; i < content.length(); i++) {
            if (content.charAt(i) == ',') {
                contentList.add(content.substring(startindex, i));
                startindex = i + 1;
            }
        }
        return contentList;
    }

    public double calculateStatus()
    {
        double status =0;
        int count =0;
        for(int i=0; i<mData.getToDoCheckboxActivated().length(); i++)
        {
            if(mData.getToDoCheckboxActivated().charAt(i)=='1') status++;
            count++;
        }
        return status/count;
    }




    public void restoreInstanceState(Bundle outState)
    {
        mGui.getTodoDetailviewButtonDuedate().setText(outState.getString("TodoDuedate"));
        mAdapter.setCheckboxActivated(outState.getString("CheckboxActivated"));
        mData.setToDoCheckboxActivated(outState.getString("CheckboxActivated"));
        mData.setToDoContent(outState.getString("TodoContent"));
        mAdapter.refresh(buildContentList(outState.getString("TodoContent")));
        mGui.getListView().setAdapter(mAdapter);
        mGui.getTodoDetailviewTextviewStatus().setText(String.valueOf((int)(calculateStatus()*100))+"/100%");
        mData.setWithData(outState.getBoolean("WithData"));
    }




    //onClick methods

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

    public void onButtonNewTaskClicked()
    {
        mContentList = mAdapter.getContentList();
        if(mGui.getTodoEdittextNew().getText().toString().contains(","))
        {
            mGui.getTodoEdittextNew().setError("Eine Aufgabe darf kein Komma enthalten");
            return;
        }
        if(mGui.getTodoEdittextNew().getText().toString().isEmpty())
        {
            mGui.getTodoEdittextNew().setError("Bitte eine neue Aufgabe eingeben, die hinzugefügt werden soll");
            return;
        }
        if(mData.getToDoContent() != null) mData.setToDoContent(mData.getToDoContent()+mGui.getTodoEdittextNew().getText().toString()+", ");
        else mData.setToDoContent(mGui.getTodoEdittextNew().getText().toString()+", ");
        mContentList.add(mGui.getTodoEdittextNew().getText().toString());
        if(mData.getToDoCheckboxActivated() != null) mData.setToDoCheckboxActivated(mData.getToDoCheckboxActivated()+"0");
        else mData.setToDoCheckboxActivated("0");
        ((ToDoDetailviewAdapter_Lena)mGui.getListView().getAdapter()).setCheckboxActivated(mData.getToDoCheckboxActivated());
        ((ToDoDetailviewAdapter_Lena)mGui.getListView().getAdapter()).setContentList(mContentList);
        ((ToDoDetailviewAdapter_Lena)mGui.getListView().getAdapter()).refresh(mContentList);
        mGui.getTodoDetailviewTextviewStatus().setText(String.valueOf((int)(calculateStatus()*100))+"/100%");
        mGui.getTodoEdittextNew().setText("");
    }

    public void onCheckboxClicked(View view, int position)
    {
        int add = 0;
        int subtract = 0;
        double status=0;
        int count = 0;
        if(!mAdapter.getCheckboxList().get(position).isChecked())
        {
            mAdapter.getCheckboxList().get(position).setChecked(true);
            add++;
        }
        else
        {
            mAdapter.getCheckboxList().get(position).setChecked(false);
            subtract--;
        }
        for(int i=0; i<mData.getToDoCheckboxActivated().length(); i++)
        {
            if(mData.getToDoCheckboxActivated().charAt(i)=='1') status++;
            count++;
        }
        status = status + add + subtract;
        status = (status / count) *100;
        mData.setToDoStaus((int)status);
        mData.setToDoCheckboxActivated(buildCheckboxActivated());
        mGui.getTodoDetailviewTextviewStatus().setText(String.valueOf((int)status) +"/100%");
    }

    public void onFabSaveClicked()
    {
        if(mGui.getTodoDetailviewTitle().getText().toString().trim().isEmpty()) {mGui.getTodoDetailviewTitle().setError("Bitte einen Titel eingeben"); return;}
        if(mGui.getTodoEdittextNew().getText().toString().contains(",")){mGui.getTodoEdittextNew().setError("Eine Aufgabe darf kein Komma enthalten"); return;}
        boolean todoExists = false;
        String titleOld = mData.getToDoTitle();
        String title = mGui.getTodoDetailviewTitle().getText().toString();
        if(mData.getDb().todoDao().todoExists(title) != 0) todoExists = true;
        if(!todoExists || mData.getWithData())
        {
            mData.setToDoTitle(mGui.getTodoDetailviewTitle().getText().toString());
            mData.setToDoContent(buildContentStringFromGui());
            mData.setToDoDuedate(mGui.getTodoDetailviewButtonDuedate().getText().toString());
            String statusString = mGui.getTodoDetailviewTextviewStatus().getText().toString();
            int status = 0;
            if(statusString.length() == 7) status = Integer.parseInt(statusString.substring(0,2));
            else if(statusString.length() == 8) status = Integer.parseInt(statusString.substring(0,3));
            else if(statusString.length() == 6) status = Integer.parseInt(statusString.substring(0,1));
            mData.setToDoStaus(status);
            String checkboxActivated = buildCheckboxActivated();

            if(!mGui.getTodoEdittextNew().getText().toString().isEmpty()) checkboxActivated = checkboxActivated+"0";
            mData.setToDoCheckboxActivated(checkboxActivated.trim());
        }
        if(mData.getWithData())
        {
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

    public void onBackPressed() {
        Log.d("LOGTAG", "onBackPress called");
        finishActivityResultCancelled();
    }




    //activity methods

    public void startActivity(Class<?> activityClass, boolean withData) //?: Elementtyp der Klasse ist offen
    {
        Intent intent = new Intent();
        intent.setClass(mData.getActivity(), activityClass);

        if(withData){ intent.putExtra(Constants.KEYDATABUNDLE, mData.getDataBundle());}

        mData.getActivity().startActivityForResult(intent, Constants.REQUESTCODEONE);
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

    private void finishActivityResultOk()
    {
        Intent intent = new Intent();
        intent.putExtra(Constants.KEYDATABUNDLE, mData.getDataBundle());
        mData.getActivity().setResult(Activity.RESULT_OK, intent);
        Log.d("LOGTAG", "finishActivityResultOk");
        mData.getActivity().finish();
        mData.getActivity().overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right);
    }

    private void finishActivityResultCancelled() {
        Intent intent = new Intent();
        intent.putExtra(Constants.KEYDATABUNDLE, mData.getDataBundle());
        mData.getActivity().setResult(Activity.RESULT_CANCELED, intent);
        Log.d("LOGTAG", "finishActivityResultCancel");
        mData.getActivity().finish();
        mData.getActivity().overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right);
    }
}
