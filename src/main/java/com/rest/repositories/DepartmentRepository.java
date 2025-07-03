package com.rest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest.entities.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
	// Custom query methods can be defined here if needed
}
