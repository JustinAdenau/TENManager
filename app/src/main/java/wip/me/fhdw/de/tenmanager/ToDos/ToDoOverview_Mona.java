package wip.me.fhdw.de.tenmanager.ToDos;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.util.Date;
import java.util.List;

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
    private String mDuedate;
    @ColumnInfo(name = "todo_status")
    private int mStatus;
    @ColumnInfo(name="todo_checkboxactivated")
    private String mCheckboxActivated;



    public ToDoOverview_Mona(String title, String content, String duedate, int status , String checkboxActivated){
        mTitle = title;
        mContent = content;
        mDuedate = duedate;
        mStatus = status;
        mCheckboxActivated = checkboxActivated;
    }

    // Get / Set Methods

    public int getId(){
        return mId;
    }
    public String getTitle(){
        return mTitle;
    }
    public String getContent(){return mContent;}

    public String getDuedate(){
        return mDuedate;
    }

    public int getStatus(){
        return mStatus;
    }
    public String getCheckboxActivated(){return mCheckboxActivated;}


    public void setTitle(String title) {
        mTitle = title;
    }
    public void setContent(String content){
        mContent = content;
    }
    public void setId ( int id){
        mId = id;
    }

    public void setDuedate (String date){
        mDuedate = date;
    }

    public void setStatus ( int status){
        status = mStatus;
    }
    public void setCheckboxActivated(String checkboxActivated){mCheckboxActivated = checkboxActivated;}

}
