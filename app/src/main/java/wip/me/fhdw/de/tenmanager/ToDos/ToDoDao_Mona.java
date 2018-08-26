package wip.me.fhdw.de.tenmanager.ToDos;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import wip.me.fhdw.de.tenmanager.Event;

@Dao
public interface ToDoDao_Mona {

    @Query("SELECT * FROM todooverview_mona")
    List<ToDoOverview_Mona> getAllToDos();

    @Insert
    void insertAll(ToDoOverview_Mona... toDoOverview_monas);

    //@Query("INSERT INTO todooverview_mona(todo_title, todo_content, todo_duedate, todo_status, todo_checkboxactivated) VALUES(:title, :content, :duedate, :status, :checkboxactivated)")
    //void insertToDo(String title, String content, String duedate, int status, String checkboxactivated);

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

    @Query("SELECT * from todooverview_mona " +
            "where todo_duedate like :dateToday " +
            "OR((SUBSTR(todo_duedate,7,4) < SUBSTR(:dateToday, 7,4)) " +
            "OR (SUBSTR(todo_duedate,7,4) like SUBSTR(:dateToday, 7,4 ) AND SUBSTR(todo_duedate, 4,2) < SUBSTR(:dateToday, 4,2))" +
            "OR (SUBSTR(todo_duedate, 7,4) like SUBSTR(:dateToday, 7,4 ) AND SUBSTR(todo_duedate, 4,2) like SUBSTR(:dateToday, 4,2) AND SUBSTR(todo_duedate, 1,2) < SUBSTR(:dateToday, 1,2)))")
    List<ToDoOverview_Mona> getToDosToday(String dateToday);
}
