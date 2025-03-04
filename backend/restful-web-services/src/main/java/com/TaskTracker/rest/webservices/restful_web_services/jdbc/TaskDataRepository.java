package com.TaskTracker.rest.webservices.restful_web_services.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.TaskTracker.rest.webservices.restful_web_services.taskTrackerServ.Tasks;

@Repository
public class TaskDataRepository {
   @Autowired 
   private JdbcTemplate jdbcTemplate;
    private static final String INSERT_QUERY = """
            insert into task(id,userName,description,targetDate)
            values(?,?,?,?);
            """;//1,'Sam','Learn Angular','2025-11-11'

      private static final String DELETE_QUERY = """
            delete task where id =?;
            """;

      private static final String SELECT_QUERY = """
            Select * from task where id =?;
            """;
   public void insert(){
        jdbcTemplate.update(INSERT_QUERY,1,"Sam","Learn Angular","2025-11-11");
   }

   public void delete(){
      jdbcTemplate.update(DELETE_QUERY, 1);
 }

 public Tasks findById(int id){
  return  jdbcTemplate.queryForObject(SELECT_QUERY, 
  new BeanPropertyRowMapper<>(Tasks.class),id);
 }

}
