package com.sacral.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Project {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Long projectId;
    private Long userStoriesId;
    
    public Project() {
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public Long getProjectId() {
        return projectId;
    }
    
    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }
    
    public Long getUserStoriesId() {
        return userStoriesId;
    }
    
    public void setUserStoriesId(Long userStoriesId) {
        this.userStoriesId = userStoriesId;
    }
    
}