package com.trello_clone.api.dao.Implement;

import com.trello_clone.api.dao.TaskDao;
import com.trello_clone.api.entity.Task;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 *
 * @author cds3h
 */

@Repository
public class TaskDaoImplement implements TaskDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public List<Task> getTareas() {
        String query = "FROM Task";
        return entityManager.createQuery(query,Task.class).getResultList();
    }
}
