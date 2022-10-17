package com.elena.casestudy.movieordersystem.entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;

import javax.persistence.Column;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

@Data

@AllArgsConstructor
@RequiredArgsConstructor

@EqualsAndHashCode
//@ToString(includeFieldNames=true)
@Entity
@Table(name="movies")
//@NamedQuery(name = "Movies.findByName",
//query = "SELECT m FROM movies m WHERE m.name = :name "
//)
public class Movie {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false,insertable = true, updatable = true)
	@ColumnDefault("null")
	private Long id;
	@Column(nullable = false)
	private String name;
	@Column(columnDefinition="LONGTEXT")
	private String description;
	@Column
	private String poster;
	@Column
	private int quantity;
	@Column
	private Double price;
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
}
