package com.rest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.entities.Department;
import com.rest.repositories.DepartmentRepository;

@Service
public class DepartmentService {
  @Autowired
  private DepartmentRepository departmentRepository;
  
  public List<Department> getAllDepartments() {
	return departmentRepository.findAll();
  }
}
