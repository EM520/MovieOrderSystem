package com.elena.casestudy.movieordersystem.dto;


import java.util.Date;
import java.util.List;

import com.elena.casestudy.movieordersystem.entity.ShoppingCart;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderDto {
	private List<ShoppingCart> cartItems;
	private String userEmail;
	private String userName;
	private Date date;
}
