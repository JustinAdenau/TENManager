package wip.me.fhdw.de.tenmanager;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface NoteDao_Julius {

    @Query("SELECT * FROM note_julius ORDER BY note_id")
    List<Note_Julius> getAllNotes();

    @Insert
    void insertAll(Note_Julius... note);

    @Query("DELETE from note_julius")
    void deleteAllNotes();

    @Delete
    void deleteNote(Note_Julius... note);
}
