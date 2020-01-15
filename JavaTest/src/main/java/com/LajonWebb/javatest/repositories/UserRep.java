package com.LajonWebb.javatest.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.LajonWebb.javatest.models.User;

@Repository
public interface UserRep extends CrudRepository<User, Long> {
	List<User> findAll();
    User findByEmail(String email);
}