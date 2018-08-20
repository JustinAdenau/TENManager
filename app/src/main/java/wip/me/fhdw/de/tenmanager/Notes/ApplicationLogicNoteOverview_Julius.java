package wip.me.fhdw.de.tenmanager.Notes;

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
import wip.me.fhdw.de.tenmanager.Event;
import wip.me.fhdw.de.tenmanager.Events.ButtonDeleteEventClickListener_Lena;
import wip.me.fhdw.de.tenmanager.NavigationItemSelectListener;
import wip.me.fhdw.de.tenmanager.R;

public class ApplicationLogicNoteOverview_Julius {

    private NoteData_Julius mNoteData;
    private GuiNoteOverview_Julius mGui;
    private AppDatabase mDb;
    private List<Note_Julius> mNoteList;
    private List<Note_Julius> mNoteListOverView;
    private NoteAdapter_Julius mNoteAdapter;
    private Activity mActivity;

    public ApplicationLogicNoteOverview_Julius(Activity activity,NoteData_Julius data, GuiNoteOverview_Julius gui, AppDatabase db, NoteAdapter_Julius noteAdapter){
        mActivity = activity;
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
        mGui.getFabCreateNew().setOnClickListener(floatingActionButtonClickListener);
        ButtonDeleteNoteClickListener_Julius buttonDeleteNoteClickListener = new ButtonDeleteNoteClickListener_Julius(this);
        mGui.getButtonDeleteNote().setOnClickListener(buttonDeleteNoteClickListener);
        NavigationItemSelectListener navigationItemSelectListener = new NavigationItemSelectListener(this);
        mGui.getNavigationView().setNavigationItemSelectedListener(navigationItemSelectListener);
    }

    public void dataToGui(){
        //mDb.noteDao().deleteAllNotes();

        //Note_Julius neu = new Note_Julius("Test", "-Eier \n-Wasser \n-Mehl");
        //mDb.noteDao().insertAll(neu);

        mNoteList = mDb.noteDao().getAllNotes();

        mNoteListOverView = mDb.noteDao().getAllNotes();
            for (int i = 0 ; i < mNoteListOverView.size(); i++)
            {
                Log.d("LOGTAG", "Content:" +mNoteListOverView.get(i).getContent());
                mNoteListOverView.get(i).setContent(mNoteList.get(i).getFirstTwoContentRows());
            }


        mNoteAdapter.setNoteList(mNoteListOverView);
        mNoteAdapter.setApplicationLogic(this);
        mGui.getListView().setAdapter(mNoteAdapter);

    }

    public void onListItemClicked(int position)
    {
        mNoteData.setNoteTitle(mNoteList.get(position).getTitle());
        mNoteData.setNoteContent(mNoteList.get(position).getContent());
        mNoteData.setWithData(true);
        startActivity(Constants.ACTIVITYNOTEDETAILVIEWCLASS, true);
        mNoteData.getActivity().overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
    }

    public void onMenuItemSelected(MenuItem item)
    {
        int id = item.getItemId();

        if (id == R.id.menuNotes) {

            startActivity(Constants.ACTIVITYNOTEOVERVIEWCLASS, false);
            mNoteData.getActivity().overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);

        } else if (id == R.id.menuEvent) {

            startActivity(Constants.ACTIVITYEVENTSOVERVIEWCLASS, false);
            mNoteData.getActivity().overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);

        } else if (id == R.id.menuTodo) {

            startActivity(Constants.ACTIVITYTODOOVERVIEWCLASS, false);
            mNoteData.getActivity().overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
        }

        DrawerLayout drawer = (DrawerLayout) mActivity.findViewById(R.id.drawer);
        drawer.closeDrawer(GravityCompat.START);
    }

    public void onFabCreateNewClicked()
    {
        startActivity(Constants.ACTIVITYNOTEDETAILVIEWCLASS, false);
        mNoteData.getActivity().overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
    }

    public void onButtonDeleteNoteClicked(View view)
    {
        View v = (View)view.getParent().getParent();
        TextView title = v.findViewById(R.id.listviewitem_textview_note_title);
        TextView content = v.findViewById(R.id.listviewitem_textview_content);
        Log.d("LOGTAG", "Title: " + title.getText().toString());
        Note_Julius noteToBeDeleted = mDb.noteDao().getNoteByTitleContent(title.getText().toString());
        mDb.noteDao().deleteNote(noteToBeDeleted);

        mActivity.recreate();
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
        mNoteData.getActivity().overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right);
    }

    private void finishActivityResultCanceled() {
        Intent intent = new Intent();
        intent.putExtra(Constants.KEYDATABUNDLE, mNoteData.getDataBundle());
        mNoteData.getActivity().setResult(Activity.RESULT_CANCELED, intent);
        Log.d("LOGTAG", "finishAktivityResultCanceled");
        mNoteData.getActivity().finish();
        mNoteData.getActivity().overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right);

    }
}

