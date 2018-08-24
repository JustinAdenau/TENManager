package wip.me.fhdw.de.tenmanager.ToDos;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface ToDoDao_Mona {

    @Query("SELECT * FROM todooverview_mona")
    List<ToDoOverview_Mona> getAllToDos();

    @Insert
    void insertAll(ToDoOverview_Mona... todo);

    @Query("DELETE from todooverview_mona")
    void deleteAllToDos();

    @Delete
    void deleteToDos(ToDoOverview_Mona... todo);

    @Query("SELECT * from todooverview_mona where todo_title like :title")
    ToDoOverview_Mona getToDoByToDoElements(String title);

    @Query("SELECT COUNT(*) from todooverview_mona where todo_title like :title")
    int todoExists(String title);

    @Query("SELECT * from todooverview_mona where todo_title like :title")
    ToDoOverview_Mona getTodoByTitle(String title);

    @Query("DELETE from todooverview_mona where todo_title like :title")
    void deleteToDoByTitle(String title);
}
