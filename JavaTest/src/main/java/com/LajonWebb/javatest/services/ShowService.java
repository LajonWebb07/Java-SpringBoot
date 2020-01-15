package com.LajonWebb.javatest.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.LajonWebb.javatest.models.Show;
import com.LajonWebb.javatest.repositories.ShowRep;

@Service
public class ShowService {
	private final ShowRep showRep;
	public ShowService(ShowRep showRep) {
		this.showRep = showRep;
	}
	
	public Show findShowById(Long id) {
		Optional<Show> u = showRep.findById(id);
		
		if(u.isPresent()) {
	        return u.get();
		} else {
		    return null;
		}
	}
	
	    
}
