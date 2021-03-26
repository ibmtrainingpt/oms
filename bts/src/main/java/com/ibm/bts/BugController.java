package com.ibm.bts;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.bts.entity.Bug;
import com.ibm.bts.service.BugService;

@RestController
public class BugController {
	@Autowired
	BugService bugService; // Dependency Injection

	/**
	 * method to create a bug
	 * 
	 * @param bug
	 * @param bindingResult
	 * @return the bugId and response code 201
	 */
	@PostMapping("/bug")
	@ResponseStatus(code = HttpStatus.CREATED)
	String createBug(@RequestBody @Valid Bug bug, BindingResult bindingResult) {
		validateBug(bindingResult);
		return bugService.createBug(bug);
	}

	private void validateBug(Errors bindingResult) {
		if (bindingResult.hasErrors()) {
			throw new IllegalArgumentException("Something went wrong, please retry.");
		}
	}

	/**
	 * method to get all bugs
	 * 
	 * @return list of bugs
	 */
	@GetMapping("/bug")
	List<Bug> getBugs() {
		return bugService.getBugs();
	}

	/**
	 * method to search for a bug
	 * 
	 * @param bugId
	 * @return zero or matching bug
	 */
	@GetMapping("/bug/{id}")
	Optional<Bug> getBug(@PathVariable("id") String bugId) {
		return bugService.getBug(bugId);
	}

	/**
	 * method to update bug
	 * 
	 * @param bug
	 * @param bindingResult
	 * @param bugId
	 */
	@PutMapping("/bug/{id}")
	void updateBug(@RequestBody @Valid Bug bug, BindingResult bindingResult, @PathVariable("id") String bugId) {
		validateBug(bindingResult);
		bug.setId(bugId);
		bugService.updateOrder(bug);
	}

	/**
	 * method to delete bug
	 * 
	 * @param bugId
	 */
	@DeleteMapping("/bug/{id}")
	void deleteBug(@PathVariable("id") String bugId) {
		bugService.deleteBug(bugId);
	}
}
