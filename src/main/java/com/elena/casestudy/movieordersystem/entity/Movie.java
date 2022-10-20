package com.elena.casestudy.movieordersystem.entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Data

@AllArgsConstructor
@RequiredArgsConstructor

@EqualsAndHashCode
//@ToString(includeFieldNames=true)
@Entity
@Table(name="movies")
//Create Movie Entity and table
public class Movie {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false,insertable = true, updatable = true)
	@ColumnDefault("null")
	@EqualsAndHashCode.Exclude 
	private Long id;
	@Column(nullable = false)
	@EqualsAndHashCode.Exclude 
	private String name;
	@Column(columnDefinition="LONGTEXT")
	@EqualsAndHashCode.Exclude 
	private String description;
	@Column
	@EqualsAndHashCode.Exclude 
	private String poster;
	@Column
	@EqualsAndHashCode.Exclude 
	private int quantity;
	@Column
	@EqualsAndHashCode.Exclude 
	private Double price;
	
	@ManyToMany(cascade =CascadeType.ALL)
//	@JoinTable(
//			name="movies_carts",
//			joinColumns = {@JoinColumn(name = "movie_id",referencedColumnName = "id")},
//			inverseJoinColumns = {@JoinColumn(name = "cart_id",referencedColumnName = "id")}
//			)
	@ToString.Exclude
	@EqualsAndHashCode.Exclude 
    private List<ShoppingCart> cart = new ArrayList<>() ;
	
	public Movie(Long id, String name, String description, String poster) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.poster = poster;
	}
	public Movie(String name, String description, String poster, int quantity, Double price) {
		super();
		this.name = name;
		this.description = description;
		this.poster = poster;
		this.quantity = quantity;
		this.price = price;
	}
	
	public void addQty(int qty) {
		this.quantity+=qty;
	}
	
	public void reduceQty(int qty) {
		this.quantity-=qty;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movie other = (Movie) obj;
		return Objects.equals(description, other.description) && Objects.equals(id, other.id)
				&& Objects.equals(name, other.name) && Objects.equals(poster, other.poster)
				&& Objects.equals(price, other.price) && quantity == other.quantity;
	}
	@Override
	public int hashCode() {
		return Objects.hash(description, id, name, poster, price, quantity);
	}
	
}

