package com.elena.casestudy.movieordersystem.serviceImplTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.longThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;

import com.elena.casestudy.movieordersystem.entity.User;
import com.elena.casestudy.movieordersystem.repository.UserRepository;
import com.elena.casestudy.movieordersystem.service.UserService;
import com.elena.casestudy.movieordersystem.service.impl.UserServiceImpl;




@SpringBootTest

@AutoConfigureTestDatabase(replace = Replace.NONE)

public class UserServiceImplTest {
	
	@Autowired 
	UserServiceImpl userServImpl;
	@Autowired 
	UserRepository userRepo;
	@Autowired 
	UserService userServ;
	
     @Test
 	
     public void testFindByEmail() {
   
	   
    	 	User expectedUser= new User();
	    	expectedUser.setName("Elena LIU");
    	 	expectedUser.setEmail("admin@gmail.com");
    	 	expectedUser.setPassword("123");
    	 	userRepo.save(expectedUser);
    	 
    	 	User actual = userServImpl.findUserByEmail("admin@gmail.com");
    	 	assertEquals(expectedUser,actual);
    	 	userRepo.delete(expectedUser);
     }
	

}
