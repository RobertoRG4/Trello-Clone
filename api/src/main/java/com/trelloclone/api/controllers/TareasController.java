package com.trelloclone.api.controllers;


import com.trelloclone.api.dao.TareaDaoImpl;
import com.trelloclone.api.models.Tarea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TareasController {
    @Autowired
    private TareaDaoImpl tareaDao;

    @GetMapping("/tasks")
    public List<Tarea> getTasks (){
        return tareaDao.getTareas();
    }
    @DeleteMapping("/task/{id}")
    public void deleteTask(@PathVariable long id){
        tareaDao.deleteTarea(id);
    }
    @PostMapping("/task")
    public void createTask(@RequestBody Tarea tarea){
        tareaDao.createTarea(tarea);
    }
}
