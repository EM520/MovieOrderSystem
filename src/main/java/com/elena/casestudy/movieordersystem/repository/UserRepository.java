package com.elena.casestudy.movieordersystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.elena.casestudy.movieordersystem.entity.User;
@Repository
public interface UserRepository extends JpaRepository<User,Long>{
	
	// method indByEmail
	User findByEmail(String email);
}
