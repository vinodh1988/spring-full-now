package com.rest.services;

import org.springframework.stereotype.Service;

@Service
public class DataService {
  
	 public String[] geNames() {
		 return new String[] {"John", "Jane", "Doe", "Smith", "Emily", 
				 "Michael", "Sarah", "David", "Laura", "James",
				 "Linda", "Robert", "Patricia", "William", "Jennifer"};
		 
	
	 }
}
