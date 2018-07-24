package wip.me.fhdw.de.tenmanager;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface EventDao_Lena {

    @Query("SELECT * from event")
    List<Event> getAllEvents();

    @Insert
    void insertAll(Event... events);

}
