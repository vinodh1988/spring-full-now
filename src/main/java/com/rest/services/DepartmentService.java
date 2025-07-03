package com.rest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.entities.Department;
import com.rest.entities.Employee;
import com.rest.repositories.DepartmentRepository;

@Service
public class DepartmentService {
  @Autowired
  private DepartmentRepository departmentRepository;
  
  public List<Department> getAllDepartments() {
	return departmentRepository.findAll();
  }
  
  public void addDepartment(Department department) {
	  for(Employee employee : department.getEmployees()) {
		  employee.setDepartment(department); 
	  }
	departmentRepository.save(department);//it also works for update.
  }
  //department will also carry employees
  //but the employee department will be null ( you need to set it explicitly),to set the department for an employee, you need to set the department in the employee entity and then save the employee entity.
}
