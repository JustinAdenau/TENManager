package wip.me.fhdw.de.tenmanager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

public class InitNoteOverview_Julius extends Activity{

    private GuiNoteOverview_Julius mGui;
    private ApplicationLogicNoteOverview_Julius mApplicationLogic;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        initGui();
        initApplicationLogic();
    }

    public void initData(Bundle savedInstanceState){

    }

    public void initGui(){
        mGui = new GuiNoteOverview_Julius(this);
    }

    public void initApplicationLogic(){
        mApplicationLogic = new ApplicationLogicNoteOverview_Julius(mData, mGui);
    }

    @Override
    protected void onSaveInstanceState(Bundle ourState){
        super.onSaveInstanceState(ourState);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        mApplicationLogic.onActivityReturned(requestCode, resultCode, data);
    }

    @Override
    public void onBackPressed(){
        mApplicationLogic.onBackPressed();
    }
}
