package com.elena.casestudy.movieordersystem.serviceImplTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.context.SpringBootTest;

import com.elena.casestudy.movieordersystem.entity.Movie;
import com.elena.casestudy.movieordersystem.entity.ShoppingCart;
import com.elena.casestudy.movieordersystem.entity.User;
import com.elena.casestudy.movieordersystem.repository.MovieRepository;
import com.elena.casestudy.movieordersystem.service.MovieService;





@SpringBootTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class MovieServiceTest {
	
	@Autowired 
	MovieService userServ;
	@Autowired
	MovieRepository movieRepo;
	
     @Test
     public void testFindAllMovies() {
    	    Movie m =movieRepo.findById((long)5).get();
    	 	List<Movie> expected=  new ArrayList<>();
    	 	expected.add(m);
    	 	movieRepo.saveAll(expected);
    	 	List<Movie> actual = userServ.findAllMovies("rosa");
    	 	assertEquals(expected,actual);
    	 	
     }
     
  
  
}   

 	

