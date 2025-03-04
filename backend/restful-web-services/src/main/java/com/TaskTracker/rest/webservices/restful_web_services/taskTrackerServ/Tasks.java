/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.TaskTracker.rest.webservices.restful_web_services.taskTrackerServ;

import java.util.Date;

import org.springframework.boot.context.properties.bind.DefaultValue;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity(name="Tasks")
 public class Tasks {

    @Id
    @GeneratedValue
    private Long id;

  
    private String userName;

    
    private String description;

    
    private Date targetDate;

    @Column(columnDefinition="BOOLEAN default false")
    private Boolean isDone;

    public Tasks(){   }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(Date targetDate) {
        this.targetDate = targetDate;
    }

    public boolean isIsDone() {
        return isDone;
    }

    public void setIsDone(boolean isDone) {
        this.isDone = isDone;
    }
    
    
    public Tasks( long id, String userName, String description, Date targetDate,boolean isDone) {
        this.description = description;
        this.id = id;
        this.isDone = isDone;
        this.targetDate = targetDate;
        this.userName = userName;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + (int) (this.id ^ (this.id >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Tasks other = (Tasks) obj;
        return this.id == other.id;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Tasks{");
        sb.append("id=").append(id);
        sb.append(", userName=").append(userName);
        sb.append(", description=").append(description);
        sb.append(", targetDate=").append(targetDate);
        sb.append(", isDone=").append(isDone);
        sb.append('}');
        return sb.toString();
    }

    
}
