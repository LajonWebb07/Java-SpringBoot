package com.LajonWebb.javatest.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.LajonWebb.javatest.models.Show;

@Repository
public interface ShowRep extends CrudRepository<Show, Long> {
	List<Show> findAll();
}