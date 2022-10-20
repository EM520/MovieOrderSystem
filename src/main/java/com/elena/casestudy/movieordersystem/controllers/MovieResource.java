package com.elena.casestudy.movieordersystem.controllers;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.client.RestTemplate;

import com.elena.casestudy.movieordersystem.dto.MovieDto;
import com.elena.casestudy.movieordersystem.entity.Movie;
import com.elena.casestudy.movieordersystem.repository.MovieRepository;
import com.elena.casestudy.movieordersystem.service.MovieService;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;

@Slf4j
@Controller
@RequestMapping("/api")
@SessionAttributes("m")
@NoArgsConstructor
public class MovieResource {	
	@Autowired
	private MovieRepository movieRepo;

	private MovieService movieService;



	public MovieResource  (MovieService movieService) {
		this.movieService = movieService;
	}
	
	
	@GetMapping("/moviesHome")
	
       public String getMovies(Movie m,Model model){
		 	
		    // This Movies from my DB not Api
		    List <Movie> listMovies = movieRepo.findAll();
		    for (Movie item : listMovies) {
	  			  System.out.println("&&&"+item+"&&&************");
	  			}
		    model.addAttribute("movieVariable", listMovies);
		    	
	        return "profile_movie";
	}	
	
}
