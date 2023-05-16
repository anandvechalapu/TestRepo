package com.sacral.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectUserStoriesRepository extends JpaRepository<Project, Long>{
    
    Project findByProjectIdAndUserStoriesId(Long projectId, Long userStoriesId);
    
    List<Project> findAllByProjectIdAndUserStoriesId(Long projectId, Long userStoriesId);
    
    List<Project> findAllByUserStoriesId(Long userStoriesId);
    
    List<Project> findAllByProjectId(Long projectId);
    
    List<Project> findAllByProjectIdAndUserStoriesIdIn(Long projectId, List<Long> userStoriesIds);
    
    void deleteByProjectIdAndUserStoriesId(Long projectId, Long userStoriesId);
}