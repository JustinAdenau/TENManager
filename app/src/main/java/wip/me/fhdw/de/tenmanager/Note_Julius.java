package wip.me.fhdw.de.tenmanager;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.PrimaryKey;

import java.util.List;

@Entity
public class Note_Julius {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "ID")
    private int mId;

    @ColumnInfo(name = "Title")
    private String mTitle;

    @ColumnInfo(name = "Content")
    private List<String> mContent;


    public Note_Julius(String title, List<String> content){
        mTitle = title;
        mContent = content;

    }



    // Get / Set Methods

    public int getNoteId(){
        return mId;
    }

    public void setNoteTitle(String title){
        mTitle = title;
    }

    public String getNoteTitle(){
        return mTitle;
    }


    public void setNoteContent(List<String> content){
        mContent = content;
    }

    public List<String> getNoteContent(){
        return mContent;
    }

    public String getFirstTwoContentRows(){
        return "- " + mContent.get(0) + "\n " + "- " + mContent.get(1);
    }




}
