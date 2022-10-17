package com.elena.casestudy.movieordersystem.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.client.RestTemplate;

import com.elena.casestudy.movieordersystem.entity.Movie;

@Controller
@SessionAttributes("m")
public class ShowMovies {
	/**
	 * Add Movie in model attribute
	 */
    @ModelAttribute("m")
    public Movie setUpMovieForm() {
    		return new Movie();
    }
    
    @GetMapping("/getMovieForm")
    public String GetMovieForm(@ModelAttribute("m")Movie m, Model model) {
    		model.addAttribute("FormVar",m);
    		return "MovieForm";
    }
    
//    @GetMapping("/api/movies")
//    public String GetMovies(@M)
//    
//    
//    @GetMapping("/getMoviesfromapi")
//    public List<Object> getMovies(){
//    		String url ="https://api.themoviedb.org/3/trending/all/day?api_key=3a7d43027da9e11dabcd838edf59a812";
//    		RestTemplate restTemplate = new RestTemplate();
//    		Object[] movies = restTemplate.getForObject(url, Object[].class);
//    		return Arrays.asList(movies);
//    }
    
   
    
    @PostMapping("/GetMovie")
    public String movieInfo(@ModelAttribute("m") Movie movie,Model model) {
    		System.out.println("Movie Id: "+movie.getId());
    		System.out.println("Movie Name: "+movie.getName());
    		System.out.println("Movie Description: "+movie.getDescription());
    		model.addAttribute("Movie",movie);
    		return "movietest";
    }
    
}





