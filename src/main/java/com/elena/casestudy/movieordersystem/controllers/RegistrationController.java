package com.elena.casestudy.movieordersystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.elena.casestudy.movieordersystem.entity.UserData;
import com.elena.casestudy.movieordersystem.service.UserService;

import javax.validation.Valid;
//public class RegistrationController {
//	  @Autowired
//	    private UserService userService;
//
//	    @GetMapping("/register")
//	    public String register(final Model model){
//	        model.addAttribute("userData", new UserData());
//	        return "account/register";
//	    }
//
//	    @PostMapping("/register")
//	    public String userRegistration(final @Valid  UserData userData, final BindingResult bindingResult, final Model model){
//	        if(bindingResult.hasErrors()){
//	            model.addAttribute("registrationForm", userData);
//	            return "account/register";
//	        }
//	        try {
//	            userService.register(userData);
//	        }catch (Exception e){
//	            bindingResult.rejectValue("email", "userData.email","An account already exists for this email.");
//	            model.addAttribute("registrationForm", userData);
//	            return "account/register";
//	        }
//	        return REDIRECT+"/starter";
//	    }
//}
