package com.elena.casestudy.movieordersystem.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Setter
@Getter
@Data
@Table(name="cart")
@Entity
//Create ShoppingCart Entity and table
public class ShoppingCart {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Transient
	private Double totalPrice;


//	private static HashMap<Movie,Integer> moviesMap;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
			name="carts_movies",
			joinColumns = {@JoinColumn(name = "cart_id",referencedColumnName = "id")},
			inverseJoinColumns = {@JoinColumn(name = "movie_id",referencedColumnName = "id")}
			)
	private Set<Movie> movieItems ; // either create a Class CartMovie which include movie quantity and reference;Or change this to 
	@ToString.Exclude
	@OneToOne(cascade=CascadeType.ALL)
	private User user;
	
	public ShoppingCart() {
//		movies=(Set<Movie>) new ArrayList<Movie>();
	}     //TODO:productsMap = new HashMap<>(); 
	
	public ShoppingCart(Long id) {
		super();
		this.id=id;
	}
	

	 
//	 public HashMap<Movie,Integer> getMoviesMap(){
//			return moviesMap;

//	}
	public Double getTotalPrice() {
		Double total =0.0;
		for(Movie item :this.movieItems) {
			total = total + item.getPrice();
		}
		return total;
	}
//	
	public int getMoviesNum() {
		return this.movieItems.size();
	}

	

	
	public Set<Movie> getMovieItems() {
		if(this.movieItems==null) {
			this.movieItems= new HashSet<>();
		}
		return this.movieItems;
	}

	public void setMovieItems(Optional<Movie> m) {
		// TODO Auto-generated method stub
		
	}
	

	
}
