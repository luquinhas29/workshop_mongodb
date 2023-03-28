package com.lucaswilliams.workshopmongodb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucaswilliams.workshopmongodb.domain.User;
import com.lucaswilliams.workshopmongodb.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository repository;
	
	public List<User> findAll(){
		List<User> list = repository.findAll();
		return list;
	}

}
