package wip.me.fhdw.de.tenmanager.Notes;

import android.content.Intent;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TextInputLayout;
import android.view.View;
import android.view.ViewStub;
import android.widget.EditText;
import android.widget.ImageButton;
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
    private NavigationView mNavigationView;
    private ImageView imageView;



    public GuiNoteDetailView_Alina(final InitNoteDetailView_Alina activity){
        activity.setContentView(R.layout.menu_alina_und_mona);
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
        mNavigationView = activity.findViewById(R.id.nav_view);

        ImageButton btnCamera = (ImageButton)activity.findViewById(R.id.btnCamera);
        imageView = (ImageView)activity.findViewById(R.id.imageView);
        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                activity.startActivityForResult(intent, 0);

            }
        });
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

    public NavigationView getNavigationView(){return mNavigationView;}
}
