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
    private String mEventDateStart;
    @ColumnInfo(name = "event_time")
    private String mEventTimeStart;
    @ColumnInfo(name = "event_date_end")
    private String mEventDateEnd;
    @ColumnInfo(name = "event_time_end")
    private String mEventTimeEnd;
    @ColumnInfo(name = "event_description")
    private String mEventDescription;
    @ColumnInfo(name = "event_location")
    private String mEventLocation;
    @ColumnInfo(name = "event_span")
    private String mEventSpan;

    public Event(String eventTitle, String eventDateStart, String eventTimeStart, String eventDateEnd, String eventTimeEnd, String eventDescription, String eventLocation, String eventSpan){
        mEventTitle=eventTitle;
        mEventDateStart=eventDateStart;
        mEventTimeStart=eventTimeStart;
        mEventDateEnd = eventDateEnd;
        mEventTimeEnd = eventTimeEnd;
        mEventDescription=eventDescription;
        mEventLocation=eventLocation;
        mEventSpan=eventSpan;
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

    public String getEventDateStart() {
        return mEventDateStart;
    }

    public void setEventDateStart(String eventDateStart) {
        this.mEventDateStart = eventDateStart;
    }

    public String getEventTimeStart() {
        return mEventTimeStart;
    }

    public void setEventTimeStart(String eventTimeStart) {
        this.mEventTimeStart = eventTimeStart;
    }

    public String getEventDateEnd() {
        return mEventDateEnd;
    }

    public void setEventDateEnd(String eventDateEnd) {
        this.mEventDateEnd = eventDateEnd;
    }

    public String getEventTimeEnd() {
        return mEventTimeEnd;
    }

    public void setEventTimeEnd(String eventTimeEnd) {
        this.mEventTimeEnd = eventTimeEnd;
    }

    public String getEventDescription() {
        return mEventDescription;
    }

    public void setEventDescription(String eventDescription) { this.mEventDescription = eventDescription;}

    public String getEventLocation(){ return mEventLocation; }

    public void setEventLocation(String eventLocation){this.mEventLocation = eventLocation;}

    public String getEventSpan(){return mEventSpan;}

    public void setEventSpan(String span){mEventSpan = span;}
}
