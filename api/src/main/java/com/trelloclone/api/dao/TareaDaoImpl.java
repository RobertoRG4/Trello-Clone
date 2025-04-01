package com.trelloclone.api.dao;

import com.trelloclone.api.models.Tarea;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
@Transactional
public class TareaDaoImpl implements TareaDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public List<Tarea> getTareas() {
        String query = "FROM Tarea";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void deleteTarea(long id) {
        Tarea tarea = entityManager.find(Tarea.class,id);
        entityManager.remove(tarea);
    }

    @Override
    public void createTarea(Tarea tarea) {
        entityManager.merge(tarea);
    }
}

