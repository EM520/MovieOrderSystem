package com.elena.casestudy.movieordersystem.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.elena.casestudy.movieordersystem.entity.Movie;

@Repository
//
public interface MovieRepository extends JpaRepository<Movie,Long>,MovieRepositoryCustom{
	//Movie-->Entity type  and  Long -->primary key
	//findByNameis a custom method()
	//@Query("select m from Movie m where m.name = ?1")
     List<Movie> findByName(String name);
//	@Query( "SELECT m.* FROM movieordersys.movies as m WHERE m.name LIKE %?1%")
//	List<Movie> getNamesLike(String name);
}
