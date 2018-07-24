package wip.me.fhdw.de.tenmanager;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Event {

    @PrimaryKey(autoGenerate = true)
    private int mId;
    @ColumnInfo(name = "event_title")
    private String mEventTitle;
    @ColumnInfo(name = "event_date")
    private String mEventDate;
    @ColumnInfo(name = "event_time")
    private String mEventTime;
    @ColumnInfo(name = "event_description")
    private String mEventDescription;

    public Event(String eventTitle, String eventDate, String eventTime, String eventDescription){
        mEventTitle=eventTitle;
        mEventDate=eventDate;
        mEventTime=eventTime;
        mEventDescription=eventDescription;
    }

    public int getId() {
        return mId;
    }

    public void setId(int Id) {
        this.mId = Id;
    }

    public String getEventTitle() {
        return mEventTitle;
    }

    public void setEventTitle(String EventTitle) {
        this.mEventTitle = EventTitle;
    }

    public String getEventDate() {
        return mEventDate;
    }

    public void setEventDate(String EventDate) {
        this.mEventDate = EventDate;
    }

    public String getEventTime() {
        return mEventTime;
    }

    public void setEventTime(String EventTime) {
        this.mEventTime = EventTime;
    }

    public String getEventDescription() {
        return mEventDescription;
    }

    public void setEventDescription(String EventDescription) {
        this.mEventDescription = EventDescription;
    }
}
