package com.elena.casestudy.movieordersystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.elena.casestudy.movieordersystem.entity.ShoppingCart;
import com.elena.casestudy.movieordersystem.entity.User;
import com.elena.casestudy.movieordersystem.repository.CartRepository;
import com.elena.casestudy.movieordersystem.repository.MovieRepository;
import com.elena.casestudy.movieordersystem.service.UserService;
import com.elena.casestudy.movieordersystem.service.impl.CartServiceImpl;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Controller
public class CartController {
	@Autowired
	CartRepository catRepo;
	@Autowired
	CartServiceImpl cartServ;
	@Autowired
	MovieRepository movieRepo;
	@Autowired
	private UserService userService;
	
@GetMapping("/shoppingcart")
public String showCart() {
	return "cart";
}

@PostMapping("/addMovie")
public String addMovie(Model model) {
	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	log.info(auth.getName());
	
	//Get the login user id to find the cart for this user
    Long loginUserId = userService.findUserByEmail(auth.getName()).getId();
    ShoppingCart cart = cartServ.findByUserId(loginUserId);
    if(cart==null) {
    		cart=new ShoppingCart();
    }
    
    //add the movie to this user's cart
    
	return "cart";
}
	
}
