package wip.me.fhdw.de.tenmanager;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface EventDao_Lena {

    @Query("SELECT * from event")
    List<Event> getAllEvents();

    @Query("SELECT * from event where event_title like :title")
    Event getEventByTitle(String title);

    @Insert
    void insertAll(Event... events);

    @Delete
    void deleteEvents(Event... events);

    @Query("DELETE from event where id like :id")
    void deleteEventById(int id);

}
