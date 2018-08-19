package wip.me.fhdw.de.tenmanager.Notes;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import wip.me.fhdw.de.tenmanager.AppDatabase;
import wip.me.fhdw.de.tenmanager.R;

public class InitNoteDetailView_Alina extends AppCompatActivity{

    private static final String TAG = "InitNoteDetailView_Alina";


    private GuiNoteDetailView_Alina mGui;
    private ApplicationLogicNoteDetailView_Alina mApplicationLogic;
    private NoteData_Julius mData;
    private AppDatabase mDb;

    private Intent mIntent;
    private ImageView imageView;

    //todo ApplicationLogic inizialisieren

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mIntent = this.getIntent();
        initData(savedInstanceState);
        initGui();
        initApplicationLogic(mIntent);
        //initDb();
        setContentView(R.layout.notesdetailview_alina);

        ImageButton btnCamera = (ImageButton)findViewById(R.id.btnCamera);
        imageView = (ImageView)findViewById(R.id.imageView);
        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, 0);

            }
        });

    }


    private void initGui(){
        mGui = new GuiNoteDetailView_Alina(this);
        initToolbar();
    }
    public void initData(Bundle savedInstanceState)
    {
        mData = new NoteData_Julius(savedInstanceState, this);
    }


    private void initApplicationLogic(Intent intent){
        mApplicationLogic = new ApplicationLogicNoteDetailView_Alina(mData, mGui);
    }

    public void initToolbar(){Toolbar toolbar = findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        TextView toolbarTextview = toolbar.findViewById(R.id.toolbar_textview);
        toolbarTextview.setText("Note");
    }


    @Override
    protected void onSaveInstanceState (Bundle outState) {
        //mData.saveDataInBundle(outState);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // super.onActivityResult(requestCode, resultCode, data);
        mApplicationLogic.onActivityReturned(requestCode, resultCode, data);
        Bitmap bitmap = (Bitmap)data.getExtras().get("data");
        imageView.setImageBitmap(bitmap);
}

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        mApplicationLogic.onBackPressed();
    }
}
