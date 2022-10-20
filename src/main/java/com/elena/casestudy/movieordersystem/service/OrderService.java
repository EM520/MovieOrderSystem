////package com.elena.casestudy.movieordersystem.service;
//
//import java.util.Optional;
//
//import org.springframework.stereotype.Service;
//
//import com.elena.casestudy.movieordersystem.entity.Order;
//import com.elena.casestudy.movieordersystem.repository.MovieRepository;
//import com.elena.casestudy.movieordersystem.repository.OrderRepository;
//
//import lombok.AllArgsConstructor;
//@AllArgsConstructor
//@Service
//public class OrderService {
//     private OrderRepository orderRepo;
//     private MovieRepository movieRepo;
//	
//     public Order getOrderDetails(Long orderId) {
//    	 Optional<Order> order = this.orderRepo.findById(orderId);
//    	 return order.isPresent()?order.get():null;
//     }
//     
//     
//}
