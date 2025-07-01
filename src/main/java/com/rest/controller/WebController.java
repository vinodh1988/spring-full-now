package com.rest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/web")
public class WebController {
  @RequestMapping("/greet")
  public String greet() {
	return "home"; // This will resolve to greet.html in the templates directory
  }
}
