package com.rest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest.entities.Project;

public interface ProjectRepository extends JpaRepository<Project, Integer> {


}
