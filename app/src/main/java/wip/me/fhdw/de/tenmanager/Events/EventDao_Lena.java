package wip.me.fhdw.de.tenmanager.Events;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface EventDao_Lena {

    //gets List of all Events from database ordered by startDate
    @Query("SELECT * from Event_Lena order by SUBSTR(event_date_start, 7, 4), SUBSTR(event_date_start, 4, 2), SUBSTR(event_date_start, 1, 2)")
    List<Event_Lena> getAllEvents();


    //gets boolean whether the Event with attributes of parameters (title, dateStart, timeStart) exists
    @Query("SELECT COUNT(*) from Event_Lena where event_title like :title and event_date_start like :dateStart and event_time_start like :timeStart")
    int eventExists(String title, String dateStart, String timeStart);


    //gets Event which attributes title, dateStart and timeStart are like the given parameters
    @Query("SELECT * from Event_Lena where event_title like :title and event_date_start like :dateStart and event_time_start like :timeStart")
    Event_Lena getEventByTitleDateTime(String title, String dateStart, String timeStart);


    //gets the id of the Event that has attributes title, dateStart and timeStart like the given parameters
    @Query("SELECT id from Event_Lena where event_title like :title and event_date_start like :dateStart and event_time_start like :timeStart")
    int getEventIdByTitleDateTime(String title, String dateStart, String timeStart);


    //inserts given Event or Events in database
    @Insert
    void insertAll(Event_Lena... events);


    //deletes the given Event or Events from database
    @Delete
    void deleteEvents(Event_Lena... events);


    //gives a List of the Events that have the startDate like the given parameter or which have a span of time that contains the given date
    @Query("SELECT * from Event_Lena " +
            "where event_date_start like :dateToday " +
            "OR event_date_end like :dateToday " +
            "OR((SUBSTR(event_date_start,7,4) < SUBSTR(:dateToday, 7,4)) " +
                    "OR (SUBSTR(event_date_start,7,4) like SUBSTR(:dateToday, 7,4 ) AND SUBSTR(event_date_start, 4,2) < SUBSTR(:dateToday, 4,2))" +
                    "OR (SUBSTR(event_date_start, 7,4) like SUBSTR(:dateToday, 7,4 ) AND SUBSTR(event_date_start, 4,2) like SUBSTR(:dateToday, 4,2) AND SUBSTR(event_date_start, 1,2) < SUBSTR(:dateToday, 1,2)))" +
                "AND (SUBSTR(event_date_end, 7,4) > SUBSTR(:dateToday, 7,4)" +
                    "OR SUBSTR(event_date_end, 7,4) like SUBSTR(:dateToday, 7,4) AND SUBSTR(event_date_end, 4,2) > SUBSTR(:dateToday, 4,2)" +
                    "OR SUBSTR(event_date_end, 7,4) like SUBSTR(:dateToday, 7,4 ) AND SUBSTR(event_date_end, 4,2) like SUBSTR(:dateToday, 4,2) AND SUBSTR(event_date_end, 1,2) > SUBSTR(:dateToday, 1,2))")
    List<Event_Lena> getEventsToday(String dateToday);
}
