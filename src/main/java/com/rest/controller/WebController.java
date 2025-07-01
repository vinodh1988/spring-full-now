package com.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rest.services.DataService;

@Controller
@RequestMapping("/web")
public class WebController {
  @Autowired
  private DataService dataService;
  @RequestMapping("/greet")
  public String greet(ModelMap map) {
	map.addAttribute("names", dataService.geNames());
	return "home"; // This will resolve to greet.html in the templates directory
  }
  
  
}
