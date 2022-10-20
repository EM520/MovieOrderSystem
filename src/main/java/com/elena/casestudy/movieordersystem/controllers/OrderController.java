//package com.elena.casestudy.movieordersystem.controllers;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//
//import com.elena.casestudy.movieordersystem.dto.OrderDto;
//import com.elena.casestudy.movieordersystem.entity.Order;
//import com.elena.casestudy.movieordersystem.service.MovieService;
//import com.elena.casestudy.movieordersystem.service.OrderService;
//import com.elena.casestudy.movieordersystem.service.UserService;
//
//import lombok.AllArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//@Slf4j
//@Controller
////@AllArgsConstructor
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
////	@GetMapping("/getOrder/{orderId}")
////	public ResponseEntity<Order> getOrderDetails(@PathVariable Long orderId) {
////		Order order=orderServ.getOrderDetails(orderId);
////		return ResponseEntity.ok(order);
////	}
//	
////	@PostMapping("/orderCheckout")
////	public ResponseEntity<ResponseOrderDto> 	orderCheckout(@RequestBody OrderDto orderDto){
////		log.info("Request Payload"+orderDto.toString());
////		ResponseOrderDto responseOrderDto = new ResponseOrderDto();
////	}
//}
