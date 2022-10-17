package com.elena.casestudy.movieordersystem.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.elena.casestudy.movieordersystem.entity.Movie;
import com.elena.casestudy.movieordersystem.repository.MovieRepository;
import com.elena.casestudy.movieordersystem.service.MovieService;

@Controller
//@RequestMapping("/api")
public class MovieTestController {
	@Autowired
	private MovieRepository movieRepository;
	@Autowired
	private MovieService movieService;
	
	@RequestMapping("/movie")
	public List<Movie> getMovie(){
		return movieRepository.findAll();
	}
	
	@RequestMapping("/moviesearch/")

	public String viewSearchPage(Model model,@RequestParam("name") String name) {
		//List<Movie> listMovies =movieService.findAllMovies(name);
		
       List<Movie> listMovies =movieRepository.getNamesLike(name);
		for (Movie item : listMovies) {
			  System.out.println("%%%"+item+"***********************");
			}
		model.addAttribute("listMovies", listMovies);
        model.addAttribute("name", name);
        //return "name"+name;
       return "searchMovie";
	}
	
}
