package wip.me.fhdw.de.tenmanager;

import android.app.Activity;
import android.content.Intent;
import android.provider.ContactsContract;
import android.provider.SyncStateContract;
import android.support.annotation.NonNull;
import android.util.Log;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ApplicationLogicNoteOverview_Julius {

    private Data mData;
    private GuiNoteOverview_Julius mGui;
    private AppDatabase mDb;
    private List<Note_Julius> mNoteList;
    private NoteAdapter_Julius mNoteAdapter;

    public ApplicationLogicNoteOverview_Julius(Data data, GuiNoteOverview_Julius gui, AppDatabase db, NoteAdapter_Julius noteAdapter){
        mData = data;
        mGui = gui;
        mDb = db;
        mNoteAdapter = noteAdapter;
        initGui();
        initListener();
    }

    public void initGui(){
        dataToGui();

    }

    public void initListener(){
        ListViewItemClickListener_Lena listViewItemClickListener = new ListViewItemClickListener_Lena(this);
        mGui.getListView().setOnItemClickListener(listViewItemClickListener);
        FloatingActionButtonClickListener_Lena floatingActionButtonClickListener = new FloatingActionButtonClickListener_Lena(this);
        if(mGui.getFabCreateNew() == null)Log.d("LOGTAG", "FAB ist null !!!!");
        mGui.getFabCreateNew().setOnClickListener(floatingActionButtonClickListener);
    }

    public void dataToGui(){
        mDb.eventDao().deleteAll();
        List<String> einkaufslist = new ArrayList<String>();
        einkaufslist.add("- Eier");
        einkaufslist.add("- Milsch");
        einkaufslist.add("- Klopapier");
        Note_Julius einkaufsliste = new Note_Julius("Einkaufsliste", einkaufslist);

        List<String> serien = new ArrayList<String>();
        serien.add("- Game of Thrones");
        serien.add("- Lucifer");
        serien.add("- How I Met Your Mother");
        Note_Julius serienSchauen = new Note_Julius("Noch zu schauende Serien!", serien);

        mDb.noteDao().insertAll(einkaufsliste, serienSchauen);
        mNoteList = mDb.noteDao().getAllNotes();

        mNoteAdapter.setNoteList(mNoteList);
        mGui.getListView().setAdapter(mNoteAdapter);

    }

    public void onListItemClicked(int position)
    {
        mData.setEventTitle(mNoteList.get(position).getNoteTitle());
        startActivity(Constants.ACTIVITYEVENTSDETAILVIEWCLASS, true);
    }

    public void onFabCreateNewClicked()
    {
        startActivity(Constants.ACTIVITYEVENTSDETAILVIEWCLASS, false);
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
                    mData.readIntentParametersOrSetDefaultValues(intent);
                    dataToGui();
                    break;
            }
        }
    }

    public void startActivity(Class<?> activityClass, boolean withData) //?: Elementtyp der Klasse ist offen
    {
        Intent intent = new Intent();
        intent.setClass(mData.getActivity(), activityClass);

        if(withData){ intent.putExtra(Constants.KEYDATABUNDLE, mData.getDataBundle());}

        mData.getActivity().startActivityForResult(intent, Constants.REQUESTCODEONE);
    }

    private void finishActivityResultOK() {
        Intent intent = new Intent();
        intent.putExtra(Constants.KEYDATABUNDLE, mData.getDataBundle());
        mData.getActivity().setResult(Activity.RESULT_OK, intent);
        Log.d("LOGTAG", "finishAktivityResultOK");
        mData.getActivity().finish();
    }

    private void finishActivityResultCanceled() {
        Intent intent = new Intent();
        intent.putExtra(Constants.KEYDATABUNDLE, mData.getDataBundle());
        mData.getActivity().setResult(Activity.RESULT_CANCELED, intent);
        Log.d("LOGTAG", "finishAktivityResultCanceled");
        mData.getActivity().finish();

    }
}

