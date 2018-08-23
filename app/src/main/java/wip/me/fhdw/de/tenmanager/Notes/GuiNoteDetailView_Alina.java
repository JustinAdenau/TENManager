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
    private ImageButton btnCamera;

    private TextInputLayout mTextInputLayoutTitle;
    private TextInputLayout mTextInputLayoutContent;
    private ImageView mImageView1,mImageView2,mImageView3,mImageView4,mImageView5;
    private ImageButton mImageButton;

    private FloatingActionButton mFabSave;
    private NavigationView mNavigationView;





    public GuiNoteDetailView_Alina(final InitNoteDetailView_Alina activity){
        activity.setContentView(R.layout.menu_alina_und_mona);
        stub = (ViewStub) activity.findViewById(R.id.viewStub);
        stub.setLayoutResource(R.layout.notesdetailview_alina);
        inflated = stub.inflate();

        mEditTextTitle = activity.findViewById(R.id.noteTitleEditText);
        mEditTextContent = activity.findViewById(R.id.noteContentEditText);
        mTextInputLayoutTitle = activity.findViewById(R.id.noteTitle);
        mTextInputLayoutContent = activity.findViewById(R.id.noteContent);
        mImageButton = activity.findViewById(R.id.btnCamera);

        mFabSave = activity.findViewById(R.id.fab);
        mFabSave.setImageResource(android.R.drawable.ic_menu_save);
        mNavigationView = activity.findViewById(R.id.nav_view);

        btnCamera = activity.findViewById(R.id.btnCamera);
        mImageView1 = activity.findViewById(R.id.imageView1);
        mImageView2 = activity.findViewById(R.id.imageView2);
        mImageView3 = activity.findViewById(R.id.imageView3);
        mImageView4 = activity.findViewById(R.id.imageView4);
        mImageView5 = activity.findViewById(R.id.imageView5);


    }



    public EditText getEditTextTitle(){return mEditTextTitle; }

    public EditText getEditTextContent(){return mEditTextContent; }

    public TextInputLayout getTextInputLayoutTitle() {
        return mTextInputLayoutTitle;
    }

    public TextInputLayout getTextInputLayoutContent() {
        return mTextInputLayoutContent;
    }

    public ImageView getImageView1() {return mImageView1; }
    public ImageView getImageView2() {return mImageView2; }
    public ImageView getImageView3() {return mImageView3; }
    public ImageView getImageView4() {return mImageView4; }
    public ImageView getImageView5() {return mImageView5; }


    public ImageButton getCameraButton(){return btnCamera;}

    public FloatingActionButton getFabSave() {return mFabSave;}

    public NavigationView getNavigationView(){return mNavigationView;}


    public ImageButton getBtnCamera(){return mImageButton;}
}
