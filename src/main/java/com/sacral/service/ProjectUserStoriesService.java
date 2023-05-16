package com.sacral.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sacral.repository.ProjectUserStoriesRepository;
import com.sacral.model.Project;

@Service
public class ProjectUserStoriesService {

    @Autowired
    private ProjectUserStoriesRepository projectUserStoriesRepository;

    public Project findByProjectIdAndUserStoriesId(Long projectId, Long userStoriesId) {
        return projectUserStoriesRepository.findByProjectIdAndUserStoriesId(projectId, userStoriesId);
    }
    
    public List<Project> findAllByProjectIdAndUserStoriesId(Long projectId, Long userStoriesId) {
        return projectUserStoriesRepository.findAllByProjectIdAndUserStoriesId(projectId, userStoriesId);
    }
    
    public List<Project> findAllByUserStoriesId(Long userStoriesId) {
        return projectUserStoriesRepository.findAllByUserStoriesId(userStoriesId);
    }
    
    public List<Project> findAllByProjectId(Long projectId) {
        return projectUserStoriesRepository.findAllByProjectId(projectId);
    }
    
    public List<Project> findAllByProjectIdAndUserStoriesIdIn(Long projectId, List<Long> userStoriesIds) {
        return projectUserStoriesRepository.findAllByProjectIdAndUserStoriesIdIn(projectId, userStoriesIds);
    }
    
    public void deleteByProjectIdAndUserStoriesId(Long projectId, Long userStoriesId) {
        projectUserStoriesRepository.deleteByProjectIdAndUserStoriesId(projectId, userStoriesId);
    }
}