package com.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rest.entities.Project;
import com.rest.services.ProjectService;
import com.rest.utilities.RecordAlreadyExistsException;
import com.rest.utilities.RecordNotFoundException;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v1/projects")
@Tag(name = "Project API", description="All the operations of projects entity")
public class ProjectAPI {
@Autowired
	private ProjectService projectService;
	@GetMapping("")

	public List<Project> getAllProjects(@RequestParam(required = false) Integer min,
			@RequestParam(required=false) Integer max) {
		// This method should return a list of projects
		// For now, returning an empty list as a placeholder
		if(min == null && max == null) 
             return projectService.getAllProjects();
		else if(min != null && max != null) {
			return projectService.getProjectsBySize(min, max);
		} else if(min != null) {
			return projectService.getProjectsBySize(min,Integer.MAX_VALUE);
		} else  {
			System.out.println("max is");
			return projectService.getProjectsBySize(0,max);
		}
	}
	@Operation(
			   summary="Get project by pno",
			   description="Get Project by passing pno "
			)
			@ApiResponses(
				 value = {
						 @ApiResponse(responseCode="200", description="Project found with given pno"),
						 @ApiResponse(responseCode="400", description="if No Project found with given pno"),
						 @ApiResponse(responseCode="500", description="Server related error")
				 }	
				)
	@GetMapping("/{pno}")
	public Project getProjectById(@PathVariable("pno") int pno) throws RecordNotFoundException  // Custom exception to handle record not found scenario
	{
		return projectService.getProjectByPno(pno);
	}
	@PostMapping("")
	public ResponseEntity<Project> addProject(@RequestBody Project project) throws RecordAlreadyExistsException  // Custom exception to handle record already exists scenario
	{
	
		
		projectService.addProject(project);
		 return new ResponseEntity<>(project, HttpStatus.CREATED);
		
	}
	@DeleteMapping("/{pno}")
	public ResponseEntity<String> deleteProject(@PathVariable("pno") int pno) throws RecordNotFoundException {
		projectService.deleteProject(pno);
		return new ResponseEntity<>("Record Deleted",HttpStatus.OK); // 204 No Content
	}
	@RequestMapping(value="",method= {RequestMethod.PUT, RequestMethod.PATCH})
	public ResponseEntity<Object> updateProject(@RequestBody Project project) throws RecordNotFoundException {
		if (project.getPno() == null) {
			return new ResponseEntity<>("PNO not attached",HttpStatus.BAD_REQUEST); // 400 Bad Request
		}
		Project updatedProject = projectService.updateProject(project);
		return new ResponseEntity<>(updatedProject, HttpStatus.OK); // 200 OK
	}
}
