package com.ibm.bts.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.bts.entity.Bug;
import com.ibm.bts.repo.BugRepository;

@Service
public class BugService {
	@Autowired
	BugRepository bugRepository;		//Dependency Injection

	public String createBug(@Valid Bug bug) {
		Bug savedBug = bugRepository.save(bug);
		return savedBug.getId();
	}

	public List<Bug> getBugs() {
		return bugRepository.findAll();
	}

	public Optional<Bug> getBug(String bugId) {
		return bugRepository.findById(bugId);
	}

	public void updateOrder(@Valid Bug bug) {
		bugRepository.save(bug);
	}
	
	public void deleteBug(String bugId) {
		bugRepository.deleteById(bugId);
	}
	
}
