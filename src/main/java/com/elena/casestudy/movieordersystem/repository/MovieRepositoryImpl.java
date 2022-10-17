package com.elena.casestudy.movieordersystem.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.elena.casestudy.movieordersystem.entity.Movie;
@Repository
@Transactional(readOnly = true)
public class MovieRepositoryImpl implements MovieRepositoryCustom{
	  @PersistenceContext
	    EntityManager entityManager;

	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Movie> getNamesLike(String name) {

		Query query = entityManager.createNativeQuery("SELECT m.* FROM movieordersys.movies as m " +
                "WHERE m.name LIKE ?", Movie.class);
        query.setParameter(1, "%"+name + "%");
		return query.getResultList();
	}



	

}
