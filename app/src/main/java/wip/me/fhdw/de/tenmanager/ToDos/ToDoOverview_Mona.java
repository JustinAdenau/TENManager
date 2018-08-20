package wip.me.fhdw.de.tenmanager.ToDos;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class ToDoOverview_Mona {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "todo_id")
    private int mId;
    @ColumnInfo(name = "todo_title")
    private String mTitle;
    @ColumnInfo(name = "todo_content")
    private String mContent;
    @ColumnInfo(name = "todo_duedate")
    private String mDueDate;
    @ColumnInfo(name = "todo_status")
    private int mStatus;



    public ToDoOverview_Mona(String title, String content, String dueDate, int status){
        mTitle = title;
        mContent = content;
        mDueDate = dueDate;
        mStatus = status;
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
    public String getDueDate(){return mDueDate;}
    public int getStatus(){return mStatus;}



    public void setTitle(String title){
        mTitle = title;
    }
    public void setContent(String content){
        mContent = content;
    }
    public void setId(int id){mId = id;}
    public void setDueDate(String dueDate){mDueDate = dueDate;}
    public void setStatus(int status){mStatus = status;}


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

}
