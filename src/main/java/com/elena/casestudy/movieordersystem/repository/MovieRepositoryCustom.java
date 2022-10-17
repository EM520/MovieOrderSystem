package com.elena.casestudy.movieordersystem.repository;

import java.util.List;





import com.elena.casestudy.movieordersystem.entity.Movie;

public interface MovieRepositoryCustom {
	List<Movie> getNamesLike(String name);

}
