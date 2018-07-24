package wip.me.fhdw.de.tenmanager;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {Event.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract EventDao_Lena eventDao();
}

