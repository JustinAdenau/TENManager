package wip.me.fhdw.de.tenmanager.ToDos;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.View;

import wip.me.fhdw.de.tenmanager.Constants;

public class ApplicationLogicToDoDetailview_Mona {

    private DatepickerToDoDetailview_Mona mDatepicker;
    private static final String TAG = "AppLogic_Sebastian";

    private wip.me.fhdw.de.tenmanager.ToDos.GuiToDoDetailview_Mona mGui;
    private wip.me.fhdw.de.tenmanager.ToDos.ToDoData_Mona mData;
    private View mView;

    public ApplicationLogicToDoDetailview_Mona (ToDoData_Mona data, GuiToDoDetailview_Mona gui){
        mData = data;
        mGui = gui;
        initDatepicker();
        initGui();
    }

    public void initDatepicker(){
        mDatepicker = new DatepickerToDoDetailview_Mona(mGui);
    }

    public void onBackPressed() {
        Log.d("LOGTAG", "onBackPress called");
        finishActivityResultCancelled();
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
