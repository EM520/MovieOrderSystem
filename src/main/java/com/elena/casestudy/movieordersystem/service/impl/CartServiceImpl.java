package com.elena.casestudy.movieordersystem.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.elena.casestudy.movieordersystem.entity.Movie;
import com.elena.casestudy.movieordersystem.entity.ShoppingCart;
import com.elena.casestudy.movieordersystem.repository.CartRepository;
import com.elena.casestudy.movieordersystem.repository.MovieRepository;
import com.elena.casestudy.movieordersystem.repository.UserRepository;
import com.elena.casestudy.movieordersystem.service.CartService;
import com.elena.casestudy.movieordersystem.service.MovieService;

import lombok.extern.slf4j.Slf4j;
@Transactional
@Service
public class CartServiceImpl implements CartService{

	@Autowired
	private CartRepository cartRepo;
	@Autowired
	private MovieRepository movieRepo;
	@Autowired
	UserRepository userRepo;
	
	@Autowired
    EntityManager entityManager;
	
	public CartServiceImpl(CartRepository cartRepo) {
		super();
		this.cartRepo=cartRepo;	
	}


	@Override
	public ShoppingCart findByUserId(Long userId) {
		
//		Query query = entityManager.createNativeQuery("SELECT c.* FROM movieordersys.cart as c"+
//		"WHERE user_id = ?", ShoppingCart.class);              
//		query.setParameter(1, userId);
//		@SuppressWarnings("unchecked")
//		List<ShoppingCart> cart =query.getResultList();
//		if(cart.isEmpty()) {
//			ShoppingCart cart2 =new ShoppingCart();
//			cart2.setUser(userRepo.findById(userId).get());
//			cartRepo.save(cart2);
//		}
//		return (ShoppingCart) query.getSingleResult(); 
		ShoppingCart cart=cartRepo.findByUserId(userId);
		if(cart==null) {
			ShoppingCart newCart = new ShoppingCart();
			newCart.setUser(userRepo.findById(userId).get());
			return cartRepo.save(newCart);
		}
		return cart;
	}
	
	

	@Override
	public Optional<ShoppingCart> findById(Long id) {
		
		return cartRepo.findById(id);
	}
//
//	public void addMovie(Movie movie) {
//	getMovieItems().add(movie);
//	moviesNum++;
//	movie.setCart((List<ShoppingCart>) this);
//}
//
// public void deleteMovie(Movie movie){
//	 getMovieItems().remove(movie);
//		movie.setCart((List<ShoppingCart>) this);;
 //   }
//	@Override
//	public ShoppingCart addShoppingCartFirstTime(Long id, int quantity) {
//
//		ShoppingCart cart=new ShoppingCart();
//		Movie cartItem = movieRepo.findById(id).get();
//		cartItem.setQuantity(quantity);
//		cart.getMovieItems().add(cartItem);
//		return cartRepo.save(cart);			
//		
//	}
//
//
//	public ShoppingCart addToExistShopingCart(Long id, Long userId,int quantity) {
//		
//		ShoppingCart existCart=cartRepo.findByUserId(userId);
//		Movie m=movieRepo.findById(id).get();
//		Boolean MovieIsNotExistCart =false;
//		if(existCart!=null) {
//			Set<Movie> items=existCart.getMovieItems();
//			for (Movie item:items) {
//				log.info(item.getId().toString());
//				if(m.getId().equals(item.getId())) {
//					MovieIsNotExistCart =true;
//					item.setQuantity(item.getQuantity()+quantity);	
//					return cartRepo.saveAndFlush(existCart);
//				}
//			}
//		}
//		
//		if(!MovieIsNotExistCart&&existCart!=null) {
//			Movie item = movieRepo.findById(id).get();;
//			item.setQuantity(quantity);
//			existCart.getMovieItems().add(item);
//			return cartRepo.saveAndFlush(existCart);
//		}
//		return this.addShoppingCartFirstTime(userId, quantity);
//}
}


