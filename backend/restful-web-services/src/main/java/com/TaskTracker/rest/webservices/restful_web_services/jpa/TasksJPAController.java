package com.TaskTracker.rest.webservices.restful_web_services.jpa;

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

import com.TaskTracker.rest.webservices.restful_web_services.taskTrackerServ.Tasks;
import com.TaskTracker.rest.webservices.restful_web_services.taskTrackerServ.TasksHardcodedService;

@CrossOrigin(origins= "http://localhost:4200")
@RestController
public class TasksJPAController{

    @Autowired
    private TaskSpringJpaRepository taskJpaRepo;

    // @Autowired
    // private TasksHardcodedService taskService;

   
    //Get the tasks
    @GetMapping("/jpa/users/{userName}/getTasks")
    public List<Tasks> getUserTasks(@PathVariable String userName){
        
        return taskJpaRepo.findByUserName(userName);
    }

@DeleteMapping("/jpa/users/{userName}/tasks/{id}")
public ResponseEntity<Void> removeTask(@PathVariable String userName, @PathVariable long id){
       taskJpaRepo.deleteById(id);
    return  ResponseEntity.noContent().build();
        // return ResponseEntity.notFound().build();
}

@GetMapping("/jpa/users/{userName}/tasks/{id}")
public Tasks getTaskbyId(@PathVariable String userName, @PathVariable long id){
    return taskJpaRepo.findById(id).get();
}
    
@PutMapping("/jpa/users/{userName}/tasks/{id}")
public ResponseEntity<Tasks> updateTaskById(@PathVariable String userName, @PathVariable long id, @RequestBody Tasks task){
   Tasks taskUpdated = taskJpaRepo.save(task);
   return new ResponseEntity<>(taskUpdated, HttpStatus.OK);
}

@PostMapping("/jpa/users/{userName}/tasks")
public ResponseEntity<Void> addTask(@PathVariable String userName, @RequestBody Tasks task){
    task.setUserName(userName);
    task.setId(null);   
   
    Tasks createdTask = taskJpaRepo.save(task);

   URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
   path("/{id}").buildAndExpand(createdTask.getId()).toUri();

   return ResponseEntity.created(uri).build();
}

    
}
