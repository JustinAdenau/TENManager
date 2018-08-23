package wip.me.fhdw.de.tenmanager.Notes;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;

import java.io.ByteArrayOutputStream;

@Entity
public class Note_Julius {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "note_id")
    private int mId;
    @ColumnInfo(name = "note_title")
    private String mTitle;
    @ColumnInfo(name = "note_content")
    private String mContent;
    @ColumnInfo(name ="note_picture")
    private String mPicture;


    public Note_Julius(String title, String content, String picture){
        mTitle = title;
        mContent = content;
        mPicture = picture;

    }



    // Get / Set Methods

    public int getId(){
        return mId;
    }
    public String getTitle(){
        return mTitle;
    }
    public String getContent(){ return mContent;}
    public String getPicture(){ return mPicture;}


    public void setTitle(String title){
        mTitle = title;
    }
    public void setContent(String content){
        mContent = content;
    }
    public void setPicture (String picture) {mPicture = picture;}
    public void setId(int id){mId = id;}




    // ToDo
    public String getFirstTwoContentRows(){
        int z = 0;
        String contentSafe = mContent;
        String zweiZeilen = "";
        for(int i = 0; i < mContent.length(); i++){
            if(mContent.charAt(i) == '-')
            {
                z++;
            }
            if (z == 3)
            {
                zweiZeilen = mContent.substring(0,i);
                break;
            }

        }
        if(z == 1 || z ==2 ){
            zweiZeilen = mContent;
        }

        this.setContent(contentSafe);
        return zweiZeilen;
    }




}
