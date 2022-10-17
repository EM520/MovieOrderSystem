package com.elena.casestudy.movieordersystem.service;

import java.util.Optional;
import com.elena.casestudy.movieordersystem.entity.ShoppingCart;

public interface CartService {
	Optional<ShoppingCart> findById(Long id);
	
	ShoppingCart findByUserId(Long id);
	
//public List<Employee> findAll();
//	
//	public Employee findById(int theId);
//	
//	public void save(Employee theEmployee);
//	
//	public void deleteById(int theId);
	
}
