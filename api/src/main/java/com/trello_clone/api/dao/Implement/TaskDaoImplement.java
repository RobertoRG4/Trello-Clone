package com.trello_clone.api.dao.Implement;

import com.trello_clone.api.dao.TaskDao;
import com.trello_clone.api.entity.Task;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class TaskDaoImplement implements TaskDao {
    @PersistenceContext 
    private EntityManager entityManager;

    @Override
    public List<Task> getTasks() {
        String query = "FROM Task";
        return entityManager.createQuery(query,Task.class).getResultList();
    }
    @Override
    public ResponseEntity<Task> postTask( Task tarea){
	Task taskSaved = entityManager.merge(tarea);
	return ResponseEntity.ok(taskSaved);
    }
}
