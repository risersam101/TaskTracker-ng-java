package com.TaskTracker.rest.webservices.restful_web_services.jpa;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.TaskTracker.rest.webservices.restful_web_services.taskTrackerServ.Tasks;

@Repository
public interface TaskSpringJpaRepository extends JpaRepository<Tasks, Long>{

    public List<Tasks> findByUserName(String userName);

    public List<Tasks> findByTargetDate(Date date);
    
}
