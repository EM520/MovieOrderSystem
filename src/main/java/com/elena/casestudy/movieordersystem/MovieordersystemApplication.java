package com.elena.casestudy.movieordersystem;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.stereotype.Component;

import com.elena.casestudy.movieordersystem.entity.Role;
import com.elena.casestudy.movieordersystem.repository.RoleRepository;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class MovieordersystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieordersystemApplication.class, args);
		
		
	}

}
@Component
class DemoCommandLineRunner implements CommandLineRunner{
	@Autowired
	private RoleRepository roleRepository;
	@Override
	public void run(String... args) throws Exception {
		
		
//		Role roleDef=roleRepository.findByName(null);
//		
//			
//			roleRepository.save(roleDef);
			
		 
//		        Role role = new Role();
//		        role.setName("ROLE_ADMIN");
//		        roleRepository.save(role);
//		        Role role1=roleRepository.findByName("ROLE_ADIMIN");
////		        if(role1==null) {role1=addMissingRole("admin");}
////		        roles.add(role1);

		
	}

}