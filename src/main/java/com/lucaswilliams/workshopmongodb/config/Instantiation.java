package com.lucaswilliams.workshopmongodb.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.lucaswilliams.workshopmongodb.domain.Post;
import com.lucaswilliams.workshopmongodb.domain.User;
import com.lucaswilliams.workshopmongodb.dto.AutorDTO;
import com.lucaswilliams.workshopmongodb.repository.PostRepository;
import com.lucaswilliams.workshopmongodb.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{
	
	@Autowired
	UserRepository repository;
	
	@Autowired
	PostRepository postRepository;

	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		repository.deleteAll();
		postRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		repository.saveAll(Arrays.asList(maria, alex, bob));
		
		Post post1 = new Post(null, sdf.parse("21/03/2018") ,"partiu viagem!" , "Vou viajar para sao paulo, abracos Maria",new AutorDTO (maria));
		Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom Dia!", "Acordei feliz hoje",new AutorDTO (maria));
		
		postRepository.saveAll(Arrays.asList(post1, post2));
		
	}

}
