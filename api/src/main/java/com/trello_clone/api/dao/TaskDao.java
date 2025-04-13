package com.trello_clone.api.dao;

import com.trello_clone.api.entity.Task;
import java.util.List;

public interface TaskDao {
    List<Task> getTareas();
    //void deleteTarea(long id);
    //void createTarea(Task tarea);
}
