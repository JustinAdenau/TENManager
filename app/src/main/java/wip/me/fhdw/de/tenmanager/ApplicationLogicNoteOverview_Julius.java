package wip.me.fhdw.de.tenmanager;

import android.app.Activity;
import android.content.Intent;
import android.provider.SyncStateContract;
import android.util.Log;

public class ApplicationLogicNoteOverview_Julius {

    private Data mData;
    private GuiNoteOverview_Julius mGui;

    public ApplicationLogicNoteOverview_Julius(Data data, GuiNoteOverview_Julius gui){
        mData = data;
        mGui = gui;
        initGui();
        initListener();
    }

    public void initGui(){
        dataToGui();

    }

    public void initListener(){
        ListViewItemClickListener listViewItemClickListener = new ListViewItemClickListener(this);
    }

    public void dataToGui(){

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
                case SyncStateContract.Constants.REQUESTCODEONE:
                    mData.readIntentParametersOrSetDefaultValues(intent);
                    dataToGui();
                    break;
            }
        }
    }

    private void finishActivityResultOK() {
        Intent intent = new Intent();
        intent.putExtra(SyncStateContract.Constants.KEYDATABUNDLE, mData.getDataBundle());
        mData.getActivity().setResult(Activity.RESULT_OK, intent);
        Log.d("LOGTAG", "finishAktivityResultOK");
        mData.getActivity().finish();
    }

    private void finishActivityResultCanceled() {
        Intent intent = new Intent();
        intent.putExtra(SyncStateContract.Constants.KEYDATABUNDLE, mData.getDataBundle());
        mData.getActivity().setResult(Activity.RESULT_CANCELED, intent);
        Log.d("LOGTAG", "finishAktivityResultCanceled");
        mData.getActivity().finish();

    }
}

