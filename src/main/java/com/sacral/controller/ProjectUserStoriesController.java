package com.sacral.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sacral.model.Project;
import com.sacral.service.ProjectUserStoriesService;

@RestController
@RequestMapping("/project-user-stories")
public class ProjectUserStoriesController {
    
    @Autowired
    private ProjectUserStoriesService projectUserStoriesService;
    
    @GetMapping("/project/{projectId}/user-stories/{userStoriesId}")
    public ResponseEntity<Project> getProjectByProjectIdAndUserStoriesId(@PathVariable Long projectId, 
                                                                        @PathVariable Long userStoriesId) {
        Project project = projectUserStoriesService.findByProjectIdAndUserStoriesId(projectId, userStoriesId);
        return new ResponseEntity<>(project, HttpStatus.OK);
    }
    
    @GetMapping("/project/{projectId}/user-stories")
    public ResponseEntity<List<Project>> getProjectByProjectIdAndUserStoriesIdIn(@PathVariable Long projectId, 
                                                                                @RequestParam List<Long> userStoriesIds) {
        List<Project> projectList = projectUserStoriesService.findAllByProjectIdAndUserStoriesIdIn(projectId, userStoriesIds);
        return new ResponseEntity<>(projectList, HttpStatus.OK);
    }
    
    @GetMapping("/user-stories/{userStoriesId}")
    public ResponseEntity<List<Project>> getProjectByUserStoriesId(@PathVariable Long userStoriesId) {
        List<Project> projectList = projectUserStoriesService.findAllByUserStoriesId(userStoriesId);
        return new ResponseEntity<>(projectList, HttpStatus.OK);
    }
    
    @GetMapping("/project/{projectId}")
    public ResponseEntity<List<Project>> getProjectByProjectId(@PathVariable Long projectId) {
        List<Project> projectList = projectUserStoriesService.findAllByProjectId(projectId);
        return new ResponseEntity<>(projectList, HttpStatus.OK);
    }
}