package com.elena.casestudy.movieordersystem.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.elena.casestudy.movieordersystem.entity.Movie;

@Repository
//
public interface MovieRepository extends JpaRepository<Movie,Long>,MovieRepositoryCustom{
	//Movie-->Entity type  and  Long -->primary key
	
     List<Movie> findByName(String name);

}
