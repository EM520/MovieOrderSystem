package com.elena.casestudy.movieordersystem.service;

import java.util.Optional;
import java.util.Set;

import com.elena.casestudy.movieordersystem.entity.ShoppingCart;

public interface CartService {
	Optional<ShoppingCart> findById(Long id);
	
	ShoppingCart findByUserId(Long userid);
	
    //ShoppingCart addShoppingCartFirstTime(Long id,int quantity);
	
}
