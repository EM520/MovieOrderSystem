//package com.elena.casestudy.movieordersystem.entity;
//
//import java.util.Set;
//
//import javax.persistence.CascadeType;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.OneToMany;
//
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@Entity(name="Favlist")
//public class FavList {
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long id;
//	@OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
//	private Set<FavListItem> items ;
//	@Column
//	private User user;
//	
//}
