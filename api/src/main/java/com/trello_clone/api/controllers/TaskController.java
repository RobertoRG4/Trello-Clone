package com.trello_clone.api.controllers;

import com.trello_clone.api.dao.Implement.TaskDaoImplement;
import com.trello_clone.api.entity.Task;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author cds3h
 */
@RestController
@RequestMapping("/api")
public class TaskController {
	@Autowired
	private TaskDaoImplement taskDaoImplement;
	
	@GetMapping("/tasks")	
	public List<Task> getTasks(){
		List<Task> response = taskDaoImplement.getTareas();
		return response;
	}
}
