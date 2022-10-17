package com.elena.casestudy.movieordersystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.elena.casestudy.movieordersystem.entity.Order;
import com.elena.casestudy.movieordersystem.service.MovieService;
import com.elena.casestudy.movieordersystem.service.OrderService;
import com.elena.casestudy.movieordersystem.service.UserService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
//@Slf4j
//@Controller
//@AllArgsConstructor
//public class OrderController {
//	@Autowired
//	private OrderService orderServ;
//	@Autowired
//	private UserService userServ;
//	@Autowired
//	private MovieService movieServ;
//	
//	
//	
//	@GetMapping("/getOrder/{orderId}")
//	public Order getOrder(@PathVariable int orderId) {
////		Order order=orderServ.get(orderId);
//		return null;
//	}
//	
//}
