package wip.me.fhdw.de.tenmanager;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Event {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="id")
    private int mId;
    @ColumnInfo(name = "event_title")
    private String mEventTitle;
    @ColumnInfo(name = "event_date")
    private String mEventDate;
    @ColumnInfo(name = "event_time")
    private String mEventTime;
    @ColumnInfo(name = "event_description")
    private String mEventDescription;
    @ColumnInfo(name = "event_location")
    private String mEventLocation;


    public Event(String eventTitle, String eventDate, String eventTime, String eventDescription, String eventLocation){
        mEventTitle=eventTitle;
        mEventDate=eventDate;
        mEventTime=eventTime;
        mEventDescription=eventDescription;
        mEventLocation=eventLocation;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        this.mId = id;
    }

    public String getEventTitle() {
        return mEventTitle;
    }

    public void setEventTitle(String eventTitle) {
        this.mEventTitle = eventTitle;
    }

    public String getEventDate() {
        return mEventDate;
    }

    public void setEventDate(String eventDate) {
        this.mEventDate = eventDate;
    }

    public String getEventTime() {
        return mEventTime;
    }

    public void setEventTime(String eventTime) {
        this.mEventTime = eventTime;
    }

    public String getEventDescription() {
        return mEventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.mEventDescription = eventDescription;
    }

    public String getEventLocation(){ return mEventLocation; }

    public void setEventLocation(String eventLocation){this.mEventLocation = eventLocation;}
}
