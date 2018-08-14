package wip.me.fhdw.de.tenmanager.ToDos;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class ToDoOverview_Mona {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "note_id")
    private int mId;
    @ColumnInfo(name = "note_title")
    private String mTitle;
    @ColumnInfo(name = "note_content")
    private String mContent;


    public ToDoOverview_Mona(String title, String content){
        mTitle = title;
        mContent = content;
    }

    // Get / Set Methods

    public int getId(){
        return mId;
    }
    public String getTitle(){
        return mTitle;
    }
    public String getContent(){
        return mContent;
    }


    public void setTitle(String title){
        mTitle = title;
    }
    public void setContent(String content){
        mContent = content;
    }
    public void setId(int id){mId = id;}

    // ToDo
    public String getFirstTwoContentRows(){
        int z = 0;
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
        return zweiZeilen;
    }

    public void insertAll(ToDoOverview_Mona todo) {

    }
}
