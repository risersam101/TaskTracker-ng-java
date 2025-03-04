package com.TaskTracker.rest.webservices.restful_web_services.jpa;

import org.springframework.stereotype.Repository;

import com.TaskTracker.rest.webservices.restful_web_services.taskTrackerServ.Tasks;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class TaskJpaRepository {

    @PersistenceContext
   private EntityManager entityManager;

   public void insert(Tasks task){
        entityManager.merge(task);
   }

   public void deleteById(long id){
    Tasks task = entityManager.find(Tasks.class, id);
     entityManager.remove(task);
}
   public Tasks findById(long id){
        return entityManager.find(Tasks.class, id);
   }
    
}
