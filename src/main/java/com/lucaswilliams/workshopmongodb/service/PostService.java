package com.lucaswilliams.workshopmongodb.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucaswilliams.workshopmongodb.domain.Post;
import com.lucaswilliams.workshopmongodb.repository.PostRepository;
import com.lucaswilliams.workshopmongodb.service.exception.EntityNotFoundException;

@Service
public class PostService {
	
	@Autowired
	PostRepository repository;
	
	public Post findById(String id) {
		Optional<Post> user = repository.findById(id);
		return	user.orElseThrow(() -> new EntityNotFoundException("User not found"));
	}
	
}
