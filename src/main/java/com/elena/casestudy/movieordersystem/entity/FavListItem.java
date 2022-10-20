//package com.elena.casestudy.movieordersystem.entity;
//
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@Entity(name="Favlistitem")
//public class FavListItem {
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long id;
//	@ManyToOne(fetch = FetchType.EAGER)
//	@JoinColumn(name="movieId",nullable=false)
//	private Movie movie;
//}	
