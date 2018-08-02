package wip.me.fhdw.de.tenmanager;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.provider.ContactsContract;

@Database(entities = {Event.class, Note_Julius.class}, version = 3)
public abstract class AppDatabase extends RoomDatabase {

    public abstract EventDao_Lena eventDao();
    public abstract NoteDao_Julius noteDao();
}

