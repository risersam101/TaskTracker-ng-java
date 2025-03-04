package com.TaskTracker.rest.webservices.restful_web_services.taskTrackerServ;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TasksHardcodedService {

    private static List<Tasks> taskList = new ArrayList<>();
    private static long idCounter = 0;
    static{
        taskList.add(new Tasks( ++idCounter, "Sam","Learn Angular", new Date(), false));
        taskList.add(new Tasks( ++idCounter, "Sam","Learn Microservices", new Date(), false));
        taskList.add(new Tasks( ++idCounter, "Sam","Learn AWS", new Date(), false)); 
    }

    public List<Tasks> findAll(){
        return taskList;
    }

    public Tasks deleteById(long id){
        Tasks task = findById(id);
        if(task ==null) return null;
        if(taskList.remove(task)){
                return task;
        }
        return null;
    }

    public Tasks findById(long id){
        
        for(Tasks task:taskList){
            if(task.getId()==id)
                return task;
        }
        return null;
    }

    public Tasks save(Tasks task){
        if(task.getId()==-1 || task.getId()==0){
            task.setId(++idCounter);
            taskList.add(task);
        }else{
            deleteById(task.getId());
            taskList.add(task);
        }
        return task;
    }
}
