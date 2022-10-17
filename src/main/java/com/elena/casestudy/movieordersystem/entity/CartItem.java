//package com.elena.casestudy.movieordersystem.entity;
//
//import java.util.HashSet;
//import java.util.Objects;
//import java.util.Set;
//
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.ManyToOne;
//import javax.persistence.OneToMany;
//import javax.persistence.Table;
//
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//@Entity
//@Table(name="cart_items")
//public class CartItem {	
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long id;
//	
//	private int quantity;
//	
//	@ManyToOne
//	private Movie movie;
//	
//	@Override
//	public int hashCode() {
//		return Objects.hash(id);
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		CartItem other = (CartItem) obj;
//		return Objects.equals(id, other.id);
//	}
//  
//}
