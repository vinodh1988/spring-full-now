package com.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.entities.Project;
import com.rest.services.ProjectService;

@RestController
@RequestMapping("/api/v1/projects")
public class ProjectAPI {
@Autowired
	private ProjectService projectService;
	@RequestMapping("")
	public List<Project> getAllProjects() {
		// This method should return a list of projects
		// For now, returning an empty list as a placeholder
        return projectService.getAllProjects();
	}
}
