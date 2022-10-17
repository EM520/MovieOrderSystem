package com.elena.casestudy.movieordersystem.service.impl;

import java.util.Optional;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.elena.casestudy.movieordersystem.entity.ShoppingCart;
import com.elena.casestudy.movieordersystem.repository.CartRepository;
import com.elena.casestudy.movieordersystem.service.CartService;
@Service
public class CartServiceImpl implements CartService{

	@Autowired
	private CartRepository cartRepo;
	@PersistenceContext
    EntityManager entityManager;
	
	public CartServiceImpl(CartRepository cartRepo) {
		super();
		this.cartRepo=cartRepo;	
	}


	@Override
	public ShoppingCart findByUserId(Long userId) {
		
		Query query = entityManager.createNativeQuery("SELECT c.* FROM movieordersys.cart as c " +
                "WHERE user.id = ?", ShoppingCart.class);              
		query.setParameter(1, userId);
		return (ShoppingCart) query.getSingleResult();
	}

	@Override
	public Optional<ShoppingCart> findById(Long id) {
		
		return cartRepo.findById(id);
	}

	
}

//public class EmployeeServiceImpl implements EmployeeService {
//
//	private EmployeeRepository employeeRepository;
//	
//	@Autowired
//	public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository) {
//		employeeRepository = theEmployeeRepository;
//	}
//	
//	@Override
//	public List<Employee> findAll() {
//		return employeeRepository.findAll();
//	}
//
//	@Override
//	public Employee findById(int theId) {
//		Optional<Employee> result = employeeRepository.findById(theId);
//		
//		Employee theEmployee = null;
//		
//		if (result.isPresent()) {
//			theEmployee = result.get();
//		}
//		else {
//			// we didn't find the employee
//			throw new RuntimeException("Did not find employee id - " + theId);
//		}
//		
//		return theEmployee;
//	}
//
//	@Override
//	public void save(Employee theEmployee) {
//		employeeRepository.save(theEmployee);
//	}
//
//	@Override
//	public void deleteById(int theId) {
//		employeeRepository.deleteById(theId);
//	}
//
//}
