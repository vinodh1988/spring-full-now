package com.rest.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.rest.entities.Person;

import lombok.RequiredArgsConstructor;

@Service
public class DataService {
	List<Person> persons = new ArrayList<>();
	
   	{
		persons.add(new Person(1, "John", "New York"));
		persons.add(new Person(2, "Jane", "Los Angeles"));
		persons.add(new Person(3, "Doe", "Chicago"));
		persons.add(new Person(4, "Smith", "Houston"));
		persons.add(new Person(5, "Emily", "Phoenix"));
		persons.add(new Person(6, "Michael", "Philadelphia"));
		persons.add(new Person(7, "Sarah", "San Antonio"));
		persons.add(new Person(8, "David", "San Diego"));
		persons.add(new Person(9, "Laura", "Dallas"));
		persons.add(new Person(10, "James", "San Jose"));
	}
  
	 public String[] geNames() {
		 return new String[] {"John", "Jane", "Doe", "Smith", "Emily", 
				 "Michael", "Sarah", "David", "Laura", "James",
				 "Linda", "Robert", "Patricia", "William", "Jennifer"};
	
	 }
	 
	 public List<Person> getPersons() {
		 return persons;
	 }
}
