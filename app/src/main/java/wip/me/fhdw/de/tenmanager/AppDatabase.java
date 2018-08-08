package wip.me.fhdw.de.tenmanager;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.provider.ContactsContract;

import wip.me.fhdw.de.tenmanager.Notes.NoteDao_Julius;
import wip.me.fhdw.de.tenmanager.Notes.Note_Julius;

@Database(entities = {Event.class, Note_Julius.class}, version = 5)
public abstract class AppDatabase extends RoomDatabase {

    public abstract EventDao_Lena eventDao();
    public abstract NoteDao_Julius noteDao();
    // DAO - Data Excess Object
}

