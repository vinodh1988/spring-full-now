package com.rest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.entities.Project;
import com.rest.repositories.ProjectRepository;

@Service
public class ProjectService {
  @Autowired
  private ProjectRepository projectRepository; 
  //the implementation of this interface is provided by Spring Data JPA at runtime
  
  public List<Project> getAllProjects() {
	return projectRepository.findAll();
  }
}
