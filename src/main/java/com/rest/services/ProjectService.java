package com.rest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.entities.Project;
import com.rest.repositories.ProjectRepository;
import com.rest.utilities.RecordAlreadyExistsException;
import com.rest.utilities.RecordNotFoundException;

@Service
public class ProjectService {
  @Autowired
  private ProjectRepository projectRepository; 
  //the implementation of this interface is provided by Spring Data JPA at runtime
  
  public List<Project> getAllProjects() {
	return projectRepository.findAll();
  }
  
  public void addProject(Project project) throws RecordAlreadyExistsException {
	  
	  Project p=projectRepository.findByPno(project.getPno());

	  if(p != null) 
		  throw new RecordAlreadyExistsException();
	projectRepository.save(project); 
	// it works for both insert and update operations
	  //We dont want to use it for update here
  }
  
  public Project getProjectByPno(int pno) throws RecordNotFoundException {
	 
	  Project p=projectRepository.findByPno(pno);
	  if(p == null)
		  throw new RecordNotFoundException();
	  return p;
	  
  }
  
  public void deleteProject(int pno) throws RecordNotFoundException {
	  Project p=projectRepository.findByPno(pno);
	  if(p == null)
		  throw new RecordNotFoundException();
	  projectRepository.delete(p);
  }
  
  public Project updateProject(Project project) throws RecordNotFoundException {
	  Project p=projectRepository.findByPno(project.getPno());
	  if(p == null)
		  throw new RecordNotFoundException();
	  project.setPname(project.getPname()==null ? p.getPname() : project.getPname());
	  project.setTeamsize(project.getTeamsize() == null ? p.getTeamsize() : project.getTeamsize());
	  project.setTechnology(project.getTechnology() == null ? p.getTechnology() : project.getTechnology());
	  return projectRepository.save(project);
  }
}
