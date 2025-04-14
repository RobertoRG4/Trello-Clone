package com.trello_clone.api.dao;

import com.trello_clone.api.entity.Task;
import java.util.List;
import org.springframework.http.ResponseEntity;

public interface TaskDao {
    List<Task> getTasks();
    ResponseEntity<Task> postTask(Task tarea);
    //void deleteTarea(long id);
}
