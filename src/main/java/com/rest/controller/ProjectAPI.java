package com.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.entities.Project;
import com.rest.services.ProjectService;
import com.rest.utilities.RecordAlreadyExistsException;

@RestController
@RequestMapping("/api/v1/projects")
public class ProjectAPI {
@Autowired
	private ProjectService projectService;
	@GetMapping("")
	public List<Project> getAllProjects() {
		// This method should return a list of projects
		// For now, returning an empty list as a placeholder
        return projectService.getAllProjects();
	}
	@PostMapping("")
	public ResponseEntity<Project> addProject(@RequestBody Project project) throws RecordAlreadyExistsException  // Custom exception to handle record already exists scenario
	{
	
		
		projectService.addProject(project);
		 return new ResponseEntity<>(project, HttpStatus.CREATED);
		
	}
}
