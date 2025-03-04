package com.TaskTracker.rest.webservices.restful_web_services.taskTrackerServ;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@CrossOrigin(origins= "http://localhost:4200")
@RestController
public class TasksController{

    @Autowired
    private TasksHardcodedService taskService;

   
    //Get the tasks
    @GetMapping("/users/{userName}/getTasks")
    public List<Tasks> getUserTasks(@PathVariable String userName){
        return taskService.findAll();
    }

@DeleteMapping("/users/{userName}/tasks/{id}")
public ResponseEntity<Void> removeTask(@PathVariable String userName, @PathVariable long id){
       Tasks task = taskService.deleteById(id);
        if(task!=null)
            return  ResponseEntity.noContent().build();
        return ResponseEntity.notFound().build();
}

@GetMapping("/users/{userName}/tasks/{id}")
public Tasks getTaskbyId(@PathVariable String userName, @PathVariable long id){
    return taskService.findById(id);
}
    
@PutMapping("/users/{userName}/tasks/{id}")
public ResponseEntity<Tasks> updateTaskById(@PathVariable String userName, @PathVariable long id, @RequestBody Tasks task){
   Tasks taskUpdated = taskService.save(task);
   return new ResponseEntity<>(task, HttpStatus.OK);
}

@PostMapping("/users/{userName}/tasks")
public ResponseEntity<Void> addTask(@PathVariable String userName, @RequestBody Tasks task){
   Tasks createdTask = taskService.save(task);

   URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
   path("/{id}").buildAndExpand(createdTask.getId()).toUri();

   return ResponseEntity.created(uri).build();
}

    
}
