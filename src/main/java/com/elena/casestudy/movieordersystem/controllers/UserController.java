package com.elena.casestudy.movieordersystem.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.elena.casestudy.movieordersystem.entity.User;
import com.elena.casestudy.movieordersystem.repository.UserRepository;

@Controller
public class UserController {
	@Autowired
	private UserRepository userRepo;
	
	@GetMapping("/userslisttest")
	public String showUserList(Model model) {
		List<User> listUsers= userRepo.findAll();
		model.addAttribute("listUsers",listUsers);
		return "userstest";
	}
}
