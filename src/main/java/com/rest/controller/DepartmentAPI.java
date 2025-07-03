package com.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.entities.Department;
import com.rest.services.DepartmentService;

@RestController
@RequestMapping("/api/v1/departments")
public class DepartmentAPI {

	@Autowired
	private DepartmentService departmentService;
	
	@GetMapping("")
	public List<Department> getAllDepartments() {
		return departmentService.getAllDepartments();
	}
	@PostMapping("")
	public ResponseEntity<Department> addDepartment(@RequestBody Department department) {
		departmentService.addDepartment(department);
		return ResponseEntity.status(201).body(department);
	}
}
