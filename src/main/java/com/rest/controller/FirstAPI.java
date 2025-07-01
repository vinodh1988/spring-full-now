package com.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.entities.Person;
import com.rest.services.DataService;

@RestController
@RequestMapping("/api/v1/people")
public class FirstAPI {
  @Autowired
  private DataService dataService;
	@GetMapping("")
  public List<Person> getPeople() {
	  return dataService.getPersons();
  }
}
