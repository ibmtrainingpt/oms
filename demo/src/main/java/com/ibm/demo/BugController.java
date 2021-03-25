package com.ibm.demo;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BugController {
	@PostMapping("/bug")
	String createBug() {
		return "Bug is created";
	}
	
	@GetMapping("/bug")
	String getBug() {
		return "Bug Details have been fetched";
	}
	
	@PutMapping("/bug/{id}")
	String updateOrder(@PathVariable("id")int bugId) {
		System.out.println(bugId);
		return "Bug Details updated";
	}
	
	@DeleteMapping("/bug/{id}")
	String deleteOrder(@PathVariable("id")int bugId) {
		System.out.println(bugId);
		return "Bug Deleted";
	}

}
