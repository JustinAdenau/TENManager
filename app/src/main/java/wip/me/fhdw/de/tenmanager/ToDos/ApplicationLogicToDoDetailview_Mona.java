package wip.me.fhdw.de.tenmanager.ToDos;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import wip.me.fhdw.de.tenmanager.Constants;
import wip.me.fhdw.de.tenmanager.NavigationItemSelectListener;
import wip.me.fhdw.de.tenmanager.R;

public class ApplicationLogicToDoDetailview_Mona {

    private DatepickerToDoDetailview_Mona mDatepicker;
    private static final String TAG = "AppLogic_Sebastian";

    private wip.me.fhdw.de.tenmanager.ToDos.GuiToDoDetailview_Mona mGui;
    private wip.me.fhdw.de.tenmanager.ToDos.ToDoData_Mona mData;
    private Activity mActivity;


    public ApplicationLogicToDoDetailview_Mona (Activity activity, ToDoData_Mona data, GuiToDoDetailview_Mona gui){
        mActivity = activity;
        mData = data;
        mGui = gui;
        initDatepicker();
        initGui();
        initListener();
    }

    public void initDatepicker(){
        mDatepicker = new DatepickerToDoDetailview_Mona(mGui);
    }

    public void initListener()
    {
        NavigationItemSelectListener navigationItemSelectListener = new NavigationItemSelectListener(this);
        mGui.getNavigationView().setNavigationItemSelectedListener(navigationItemSelectListener);
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
        mGui.getMtodoCheckBox1().setText(mData.getToDoContent());
        mGui.getMtodoCheckBox2().setText(mData.getToDoContent());
        mGui.getMtodoCheckBox3().setText(mData.getToDoContent());
        mGui.getMtodoDetailviewDueDate().setText(mData.getmToDoDateTime());
        mGui.getMtodoDetailviewStatus().setText(mData.getToDoStatus());
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
