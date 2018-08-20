package wip.me.fhdw.de.tenmanager.Notes;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputLayout;
import android.view.View;
import android.view.ViewStub;
import android.widget.EditText;
import android.widget.ImageView;

import wip.me.fhdw.de.tenmanager.R;

public class GuiNoteDetailView_Alina {

    private ViewStub stub;
    private View inflated;

    private EditText mEditTextTitle;
    private EditText mEditTextContent;
    private ImageView mImageView;

    private TextInputLayout mTextInputLayoutTitle;
    private TextInputLayout mTextInputLayoutContent;
    private FloatingActionButton mFabSave;


    public GuiNoteDetailView_Alina(InitNoteDetailView_Alina activity){
        activity.setContentView(R.layout.activity_main);
        stub = (ViewStub) activity.findViewById(R.id.viewStub);
        stub.setLayoutResource(R.layout.notesdetailview_alina);
        inflated = stub.inflate();

        mEditTextTitle = activity.findViewById(R.id.noteTitleEditText);
        mEditTextContent = activity.findViewById(R.id.noteContentEditText);
        mTextInputLayoutTitle = activity.findViewById(R.id.noteTitle);
        mTextInputLayoutContent = activity.findViewById(R.id.noteContent);
        mImageView = activity.findViewById(R.id.imageView);

        mFabSave = activity.findViewById(R.id.fab);
        mFabSave.setImageResource(android.R.drawable.ic_menu_save);
    }



    public EditText getEditTextTitle(){return mEditTextTitle; }

    public EditText getEditTextContent(){return mEditTextContent; }

    public TextInputLayout getTextInputLayoutTitle() {
        return mTextInputLayoutTitle;
    }

    public TextInputLayout getTextInputLayoutContent() {
        return mTextInputLayoutContent;
    }

    public ImageView getImageView() {return mImageView; }

    public FloatingActionButton getFabSave() {return mFabSave;}
}
