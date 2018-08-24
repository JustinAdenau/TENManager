package wip.me.fhdw.de.tenmanager;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import wip.me.fhdw.de.tenmanager.Notes.NoteDao_Julius;
import wip.me.fhdw.de.tenmanager.Notes.Note_Julius;
import wip.me.fhdw.de.tenmanager.ToDos.ToDoDao_Mona;
import wip.me.fhdw.de.tenmanager.ToDos.ToDoOverview_Mona;

@Database(entities = {Event.class, Note_Julius.class, ToDoOverview_Mona.class}, version = 7)
public abstract class AppDatabase extends RoomDatabase {

    // DAO - Data Excess Object
    public abstract EventDao_Lena eventDao();
    public abstract NoteDao_Julius noteDao();
    public abstract ToDoDao_Mona todoDao();

}

