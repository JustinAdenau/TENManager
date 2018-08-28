package wip.me.fhdw.de.tenmanager.Events;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import wip.me.fhdw.de.tenmanager.Events.Event;

@Dao
public interface EventDao_Lena {

    @Query("SELECT * from event order by SUBSTR(event_date_start, 7, 4), SUBSTR(event_date_start, 4, 2), SUBSTR(event_date_start, 1, 2)")
    List<Event> getAllEvents();

    @Query("SELECT COUNT(*) from event where event_title like :title and event_date_start like :dateStart and event_time_start like :timeStart")
    int eventExists(String title, String dateStart, String timeStart);

    @Query("SELECT * from event where id like :id")
    Event getEventById(String id);

    @Query("SELECT * from event where event_title like :title and event_date_start like :dateStart and event_time_start like :timeStart")
    Event getEventByTitleDateTime(String title, String dateStart, String timeStart);

    @Query("SELECT id from event where event_title like :title and event_date_start like :dateStart and event_time_start like :timeStart")
    int getEventIdByTitleDateTime(String title, String dateStart, String timeStart);


    @Insert
    void insertAll(Event... events);


    @Query("DELETE from event")
    void deleteAll();

    @Delete
    void deleteEvents(Event... events);

    @Query("SELECT * from event " +
            "where event_date_start like :dateToday " +
            "OR event_date_end like :dateToday " +
            "OR((SUBSTR(event_date_start,7,4) < SUBSTR(:dateToday, 7,4)) " +
                    "OR (SUBSTR(event_date_start,7,4) like SUBSTR(:dateToday, 7,4 ) AND SUBSTR(event_date_start, 4,2) < SUBSTR(:dateToday, 4,2))" +
                    "OR (SUBSTR(event_date_start, 7,4) like SUBSTR(:dateToday, 7,4 ) AND SUBSTR(event_date_start, 4,2) like SUBSTR(:dateToday, 4,2) AND SUBSTR(event_date_start, 1,2) < SUBSTR(:dateToday, 1,2)))" +
                "AND (SUBSTR(event_date_end, 7,4) > SUBSTR(:dateToday, 7,4)" +
                    "OR SUBSTR(event_date_end, 7,4) like SUBSTR(:dateToday, 7,4) AND SUBSTR(event_date_end, 4,2) > SUBSTR(:dateToday, 4,2)" +
                    "OR SUBSTR(event_date_end, 7,4) like SUBSTR(:dateToday, 7,4 ) AND SUBSTR(event_date_end, 4,2) like SUBSTR(:dateToday, 4,2) AND SUBSTR(event_date_end, 1,2) > SUBSTR(:dateToday, 1,2))")
    List<Event> getEventsToday(String dateToday);
}
