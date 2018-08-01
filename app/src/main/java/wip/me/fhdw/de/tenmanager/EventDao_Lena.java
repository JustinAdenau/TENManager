package wip.me.fhdw.de.tenmanager;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface EventDao_Lena {

    @Query("SELECT * from event order by event_date_start")
    List<Event> getAllEvents();

    @Query("SELECT * from event where id like :id")
    Event getEventById(String id);

    @Query("SELECT * from event where event_title like :title and event_date_start like :date and event_time_start like :time")
    Event getEventByTitleDateTime(String title, String date, String time);

    @Query("SELECT event_description from event where event_title like :title and event_date_start like :date and event_time_start like :time")
    String getEventDescriptionByTitleDateTime(String title, String date, String time);

    @Query("SELECT event_location from event where event_title like :title and event_date_start like :date and event_time_start like :time")
    String getEventLocationByTitleDateTime(String title, String date, String time);



    @Insert
    void insertAll(Event... events);

    @Query("DELETE from event")
    void deleteAll();

    @Delete
    void deleteEvents(Event... events);

    @Query("DELETE from event where id like :id")
    void deleteEventById(int id);

}
