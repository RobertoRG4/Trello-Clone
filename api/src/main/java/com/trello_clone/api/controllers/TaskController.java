package com.trello_clone.api.controllers;

import com.trello_clone.api.dao.Implement.TaskDaoImplement;
import com.trello_clone.api.entity.Task;
import com.trello_clone.api.service.UploadFileService;
import com.trello_clone.api.utils.ApiResponse;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api")
public class TaskController {
	@Autowired
	private TaskDaoImplement taskDaoImplement;

	@Autowired
	private UploadFileService uploadFileService;
	
	@GetMapping("/tasks")	
	public List<Task> getTasks(){
		List<Task> response = taskDaoImplement.getTasks();
		return response;
	}
	@PostMapping("/task")
	public void postTask(@RequestBody Task task){
		taskDaoImplement.postTask(task);
	}

	@PostMapping("/uploadFile")
	public ResponseEntity<ApiResponse<String>> uploadFile(@RequestParam("file") MultipartFile file){

		if(!file.isEmpty()) {
            try {
                uploadFileService.saveFile(file);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return new ResponseEntity(new ApiResponse<>("Uploaded file success.", LocalDateTime.now(), 200), HttpStatus.OK);
		}
			return new ResponseEntity( new ApiResponse("Not file uploaded",LocalDateTime.now(),400), HttpStatus.BAD_REQUEST);
	}


	/*@GetMapping("/response")
	public ApiResponse<Task> getResponse() {
            Task tarea = new Task(1241L, "Descripción de ejemplo", "En progreso");
            ApiResponse<Task> response = new ApiResponse<>(tarea, LocalDateTime.now(),HttpStatusCode.valueOf(200).value());
            return response;
	}*/
}
