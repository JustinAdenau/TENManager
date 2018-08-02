package wip.me.fhdw.de.tenmanager.Notes;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;

import java.util.List;

import wip.me.fhdw.de.tenmanager.AppDatabase;
import wip.me.fhdw.de.tenmanager.Constants;
import wip.me.fhdw.de.tenmanager.Events.EventFloatingActionButtonClickListener_Lena;

public class ApplicationLogicNoteOverview_Julius {

    private NoteData_Julius mNoteData;
    private GuiNoteOverview_Julius mGui;
    private AppDatabase mDb;
    private List<Note_Julius> mNoteList;
    private NoteAdapter_Julius mNoteAdapter;

    public ApplicationLogicNoteOverview_Julius(NoteData_Julius data, GuiNoteOverview_Julius gui, AppDatabase db, NoteAdapter_Julius noteAdapter){
        mNoteData = data;
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
        ListViewItemClickListener_Julius listViewItemClickListener = new ListViewItemClickListener_Julius(this);
        mGui.getListView().setOnItemClickListener(listViewItemClickListener);
        NoteFloatingActionButtonClickListener_Julius floatingActionButtonClickListener = new NoteFloatingActionButtonClickListener_Julius(this);
        if(mGui.getFabCreateNew() == null)Log.d("LOGTAG", "FAB ist null !!!!");
        mGui.getFabCreateNew().setOnClickListener(floatingActionButtonClickListener);
    }

    public void dataToGui(){
        mDb.noteDao().deleteAllNotes();
        String einkaufslist = "- Eier \n- Milsch \n- Klopapier";
        Note_Julius einkaufsliste = new Note_Julius("Einkaufsliste", einkaufslist);

        String serien = "- GoT \n- Lucifer \n- HIMYM";
        Note_Julius serienSchauen = new Note_Julius("Noch zu schauende Serien!", serien);
        mDb.noteDao().insertAll(einkaufsliste, serienSchauen);


        mNoteList = mDb.noteDao().getAllNotes();

        //ToDo Liste bearbeiten 2 Zeilen


        for (int i = 0 ; i < mNoteList.size(); i++)
        {
            mNoteList.get(i).setContent(mNoteList.get(i).getFirstTwoContentRows());
        }

        mNoteAdapter.setNoteList(mNoteList);
        mGui.getListView().setAdapter(mNoteAdapter);

    }

    public void onListItemClicked(int position)
    {
        mNoteData.setNoteTitle(mNoteList.get(position).getTitle());
        startActivity(Constants.ACTIVITYEVENTSDETAILVIEWCLASS, true);
    }

    public void onFabCreateNewClicked()
    {
        //TODO change constant
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
                    mNoteData.readIntentParametersOrSetDefaultValues(intent);
                    dataToGui();
                    break;
            }
        }
    }

    public void startActivity(Class<?> activityClass, boolean withData) //?: Elementtyp der Klasse ist offen
    {
        Intent intent = new Intent();
        intent.setClass(mNoteData.getActivity(), activityClass);

        if(withData){ intent.putExtra(Constants.KEYDATABUNDLE, mNoteData.getDataBundle());}

        mNoteData.getActivity().startActivityForResult(intent, Constants.REQUESTCODEONE);
    }

    private void finishActivityResultOK() {
        Intent intent = new Intent();
        intent.putExtra(Constants.KEYDATABUNDLE, mNoteData.getDataBundle());
        mNoteData.getActivity().setResult(Activity.RESULT_OK, intent);
        Log.d("LOGTAG", "finishAktivityResultOK");
        mNoteData.getActivity().finish();
    }

    private void finishActivityResultCanceled() {
        Intent intent = new Intent();
        intent.putExtra(Constants.KEYDATABUNDLE, mNoteData.getDataBundle());
        mNoteData.getActivity().setResult(Activity.RESULT_CANCELED, intent);
        Log.d("LOGTAG", "finishAktivityResultCanceled");
        mNoteData.getActivity().finish();

    }
}

