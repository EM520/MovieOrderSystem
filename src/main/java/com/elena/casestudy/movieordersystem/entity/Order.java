package com.elena.casestudy.movieordersystem.entity;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;
@Data
@Entity
//@JsonIdentityInfo(
//        generator = ObjectIdGenerators.PropertyGenerator.class,
//        property = "id")
//Create ORDER Entity and table
@Table(name = "orders")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="userId",referencedColumnName="id")
	private User user;
	
	@OneToMany(fetch=FetchType.EAGER,cascade = CascadeType.ALL,targetEntity=ShoppingCart.class)
	@JoinColumn(name="orderIdfromorder",referencedColumnName="id")
	private List<ShoppingCart> cartItems;
	
	public Order() {}

	public Order( User user, List<ShoppingCart> cartItems) {
		super();
		this.user = user;
		this.cartItems = cartItems;
	}

//	@Column(nullable = false)
//	private Long user_id;
	@Column(nullable = false)
	private BigDecimal price;
	@Column(nullable = false)
	private Date date;
	
}
