package com.elena.casestudy.movieordersystem.controllers;

import java.util.Optional;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.annotation.ModelAndViewResolver;

import com.elena.casestudy.movieordersystem.entity.Movie;
import com.elena.casestudy.movieordersystem.entity.ShoppingCart;
import com.elena.casestudy.movieordersystem.entity.User;
import com.elena.casestudy.movieordersystem.repository.CartRepository;
import com.elena.casestudy.movieordersystem.repository.MovieRepository;
import com.elena.casestudy.movieordersystem.service.MovieService;
import com.elena.casestudy.movieordersystem.service.UserService;
import com.elena.casestudy.movieordersystem.service.impl.CartServiceImpl;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class CartController {
	@Autowired
	CartRepository cartRepo;
	@Autowired
	CartServiceImpl cartServ;
	@Autowired
	MovieService movieServ;
	@Autowired
	MovieRepository movieRepo;
	@Autowired
	private UserService userService;

	@GetMapping("/shoppingCart")
	public String ShoppingCartHome() {
		return "cart_home";
	}

	@PostMapping("/addMovieToCart/{id}")
//@RequestParam("quantity")int quantity  ,@RequestParam("id")Long id,@RequestParam("quantity")int quantity
	public String addMovieToCart(Model model, @PathVariable("id") Long moiveid) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		log.info("@@" + auth.getName());

		// Get the login user id to find the cart for this user
		User loginUser = userService.findUserByEmail(auth.getName());
		Long loginUserId = userService.findUserByEmail(auth.getName()).getId();
		log.info("@@" + loginUserId.toString());
		ShoppingCart cart = cartServ.findByUserId(loginUserId);
		if (cart == null) { // addShoppingCartFirstTime
			cart = new ShoppingCart();
		}
		Movie cartItem = movieRepo.findById(moiveid).get();

		if (cart.getMovieItems().contains(cartItem)) {
			log.info("movie exists in the cart!");// increment the ticket quantiy
		}
		try {
			cart.getMovieItems().add(cartItem);
			log.info("+++++" + cart.toString());
			cartRepo.save(cart);
		} catch (RuntimeException e) {
			e.getMessage();
		}

		model.addAttribute("cart", cart);
		return "cart";
	}

	@GetMapping("/orderConfirm")
	public String orderConfirmPage(Model model) {
		return "order_confirm";
	}
//@GetMapping("/shoppingcart")
//public ShoppingCart cartView(Model m) {
//	  ShoppingCart cart=cartServ.findById((long) 1).get();
//      m.addAttribute("cart",cart);
//	
//	return cart;
//}

	@PostMapping("/delMovieFromCart/{id}")
	public String delMovieFromCart(Model model, @PathVariable("id") Long moiveid) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		log.info("@@" + auth.getName());
		// Get the login user id to find the cart for this user
		User loginUser = userService.findUserByEmail(auth.getName());
		Long loginUserId = userService.findUserByEmail(auth.getName()).getId();
		log.info("@@" + loginUserId.toString());
		ShoppingCart cart = cartServ.findByUserId(loginUserId);
		try {
			Movie cartItem = movieRepo.findById(moiveid).get();
			cart.getMovieItems().remove(cartItem);
		} catch (RuntimeException e) {
			e.getMessage();
		}
		log.info("=====" + cart.toString());
		cartRepo.save(cart);
		model.addAttribute("cart", cart);
		return "cart";
	}

	@PostMapping("/clearCart")
	public String clearCart(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		log.info("@@" + auth.getName());
		// Get the login user id to find the cart for this user
		Long loginUserId = userService.findUserByEmail(auth.getName()).getId();
		log.info("@@" + loginUserId.toString());
		ShoppingCart cart = cartServ.findByUserId(loginUserId);
		log.info("==before" + cart.toString());
		cart.getMovieItems().clear();
		log.info("==after" + cart.toString());
		cartRepo.save(cart);
		log.info("%$^&*" +cartRepo.toString());
		model.addAttribute("cart", cart);
		return "cart";
	}
}
