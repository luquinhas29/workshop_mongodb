package com.lucaswilliams.workshopmongodb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucaswilliams.workshopmongodb.domain.User;
import com.lucaswilliams.workshopmongodb.repository.UserRepository;
import com.lucaswilliams.workshopmongodb.service.exception.EntityNotFoundException;

@Service
public class UserService {
	
	@Autowired
	UserRepository repository;
	
	public List<User> findAll(){
		List<User> list = repository.findAll();
		return list;
	}
	
	public User findById(String id) {
		Optional<User> user = repository.findById(id);
		return	user.orElseThrow(() -> new EntityNotFoundException("User not found"));
	}

}
