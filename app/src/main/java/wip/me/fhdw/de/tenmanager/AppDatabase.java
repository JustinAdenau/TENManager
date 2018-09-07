package wip.me.fhdw.de.tenmanager;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import wip.me.fhdw.de.tenmanager.Events.Event_Lena;
import wip.me.fhdw.de.tenmanager.Events.EventDao_Lena;
import wip.me.fhdw.de.tenmanager.Notes.NoteDao_Julius;
import wip.me.fhdw.de.tenmanager.Notes.Note_Julius;
import wip.me.fhdw.de.tenmanager.ToDos.ToDoDao_Mona;
import wip.me.fhdw.de.tenmanager.ToDos.ToDo_Mona;

@Database(entities = {Event_Lena.class, Note_Julius.class, ToDo_Mona.class}, version = 8)
public abstract class AppDatabase extends RoomDatabase {

    // DAO - Data Excess Object
    public abstract EventDao_Lena eventDao();
    public abstract NoteDao_Julius noteDao();
    public abstract ToDoDao_Mona todoDao();

}

