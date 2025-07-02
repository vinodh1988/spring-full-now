package com.rest.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.rest.entities.Project;

public interface ProjectRepository extends JpaRepository<Project, Integer> {

  public Project findByPno(Integer pno); // Custom query method to find a project by its project number	
  // Custom query method to find a project by its name
  
  @Query("SELECT p FROM Project p WHERE p.teamsize >= :min AND p.teamsize <= :max")
  public List<Project> findBySize(@Param("min") int min,@Param("max") int max);
}
