package com.elena.casestudy.movieordersystem.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.elena.casestudy.movieordersystem.entity.Movie;
import com.elena.casestudy.movieordersystem.repository.MovieRepository;

@Service
public class MovieService {
	
	@Autowired
	private MovieRepository repo;
	
	public List<Movie> findAllMovies(String name){
		if(name!=null) {
			return repo.getNamesLike(name);
		}
		return repo.findAll();
	}
	
	
	
}
