package com.elena.casestudy.movieordersystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elena.casestudy.movieordersystem.entity.ShoppingCart;

public interface CartRepository extends JpaRepository<ShoppingCart,Long>{

}
