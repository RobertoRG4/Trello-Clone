package com.trelloclone.api.dao;

import com.trelloclone.api.models.Tarea;

import java.util.List;

public interface TareaDao {
    List<Tarea> getTareas();

    void deleteTarea(long id);
    void createTarea(Tarea tarea);
}
