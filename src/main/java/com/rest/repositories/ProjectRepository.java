package com.rest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest.entities.Project;

public interface ProjectRepository extends JpaRepository<Project, Integer> {

  public Project findByPno(Integer pno); // Custom query method to find a project by its project number	
  // Custom query method to find a project by its name
}
