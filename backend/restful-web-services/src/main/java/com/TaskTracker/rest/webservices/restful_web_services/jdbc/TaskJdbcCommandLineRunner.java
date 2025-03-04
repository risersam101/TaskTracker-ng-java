package com.TaskTracker.rest.webservices.restful_web_services.jdbc;



import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.TaskTracker.rest.webservices.restful_web_services.jpa.TaskJpaRepository;
import com.TaskTracker.rest.webservices.restful_web_services.jpa.TaskSpringJpaRepository;
import com.TaskTracker.rest.webservices.restful_web_services.taskTrackerServ.Tasks;


public class TaskJdbcCommandLineRunner implements CommandLineRunner {

    // @Autowired
    // private TaskDataRepository taskDataRepository;

    // @Autowired
    // private TaskJpaRepository taskJpaRepository;

    // @Autowired
    // private TaskSpringJpaRepository taskSpringJpaRepository;

    @Override
    public void run(String... args) throws Exception {
        // // taskDataRepository.insert()
        // taskSpringJpaRepository.save(new Tasks(1, "Sam", "Angular learn", new Date(), false));
        // taskSpringJpaRepository.save(new Tasks(2, "Sam", "Learn SQL", new Date(), false));
        // taskSpringJpaRepository.save(new Tasks(3, "Sam", "Learn JDBC", new Date(), false));
        
        // taskSpringJpaRepository.deleteById(2l);

        // System.out.println(taskSpringJpaRepository.findById(1l));
        // System.out.println(taskSpringJpaRepository.findAll());
        // System.out.println(taskSpringJpaRepository.count());
        // System.out.println(taskSpringJpaRepository.findByUserName("Sam"));
        // System.out.println(taskSpringJpaRepository.findByTargetDate(new Date()));
    }
    
}
