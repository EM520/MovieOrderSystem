package com.elena.casestudy.movieordersystem.entity;

import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@Data
@Entity
@Table(name = "cart")
public class ShoppingCart {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Transient
	private Double totalPrice;
	@Transient
	private int moviesNum;
	@OneToMany(targetEntity = Movie.class)
	private Set<Movie> movies ;
	@OneToOne(cascade=CascadeType.ALL)
	private User user;
	
	public ShoppingCart() {}     //TODO:productsMap = new HashMap<>(); 
	
	public ShoppingCart(Long id) {
		super();
		this.id=id;
	}
	

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Double getTotalPrice() {
		Double total =0.0;
		for(Movie item :this.movies) {
			total = total + item.getPrice();
		}
		return total;
	}
	
	public int getmoviesNum() {
		return this.movies.size();
	}
	
	public Set<Movie> getmovies() {
		return movies;
	}
	public void setmovies(Set<Movie> movies) {
		this.movies = movies;
	}
	
}
