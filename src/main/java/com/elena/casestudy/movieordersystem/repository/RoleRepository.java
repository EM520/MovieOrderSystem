package com.elena.casestudy.movieordersystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.elena.casestudy.movieordersystem.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long>{
	Role findByName(String name);

}
