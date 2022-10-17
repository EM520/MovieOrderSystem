package com.elena.casestudy.movieordersystem.controller;

import java.io.StringReader;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.elena.casestudy.movieordersystem.dto.UserDto;
import com.elena.casestudy.movieordersystem.entity.Movie;
import com.elena.casestudy.movieordersystem.entity.Role;
import com.elena.casestudy.movieordersystem.entity.User;
import com.elena.casestudy.movieordersystem.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class AuthController {
	private UserService userService;

	// @Autowired
	public AuthController(UserService userService) {
		this.userService = userService;
	}

	// handler method to handle home page request
	@GetMapping("/")
	public String home(@ModelAttribute("m")Movie m,Model model) {
		try {
		    String uri="https://api.themoviedb.org/3/trending/movie/day?api_key=3a7d43027da9e11dabcd838edf59a812";
		    RestTemplate restTemplate = new RestTemplate();
		    String result = restTemplate.getForObject(uri, String.class);
		    String responseStr = new ResponseEntity<> (result,HttpStatus.OK).getBody();
		    JsonReader jsonReader = Json.createReader(new StringReader(responseStr));
		    JsonObject resultList = jsonReader.readObject();
		    JsonArray moviesObj=resultList.getJsonArray("results");
		    jsonReader.close();
		    JsonObject	movieObj = null;
		    
	        Set<Movie> movieSet = new HashSet<Movie>();
		    for (int i=0 ;i<10 && i<moviesObj.size();i++) {
		    		movieObj = moviesObj.getJsonObject(i);
		       	Long id = Long.valueOf(movieObj.getInt("id"));
		    		String name = movieObj.getString("title");
		    		String decription = movieObj.getString("overview");
		    		String poster ="https://image.tmdb.org/t/p/w200"+ movieObj.getString("poster_path");
		    		log.info(poster);
		    		///String poster = movieObj.getString("poster_path");
		    		Movie movie = new Movie(id,name,decription,poster);
		    		movieSet.add(movie);
		   
		    }
		    for (Movie item : movieSet) {
  			  System.out.println(item+"***********************");
  			}
		   
		    	model.addAttribute("movieVariable", movieSet);
	        return "movieHome";
	        
		}catch (Exception e) {
			e.printStackTrace();
		   return "Error!Please try again";
	      }
	}
	
	// handler method to handle login request
	@GetMapping("/login")
	public String loginPage() {
		return "login";
	}

	// handler method to handle user registration form request
	@GetMapping("/register")
	public String showRegistrationForm(Model model) {
		// create model object to store form data
		UserDto user = new UserDto();
		model.addAttribute("user", user);
		return "register";
	}

	// handler method to handle user registration form submit request
	@PostMapping("/register/save")
	public String registration(@Valid @ModelAttribute("user") UserDto userDto, BindingResult result, Model model) {

		User existingUser = userService.findUserByEmail(userDto.getEmail());

		if (existingUser != null && existingUser.getEmail() != null && !existingUser.getEmail().isEmpty()) {
			result.rejectValue("email", null, "There is already account registered with the same email");
		}

		if (result.hasErrors()) {
			model.addAttribute("user", userDto);
			return "/register";
		}

//   	 	 Set<String> roleNames = new HashSet<>();   //add admin options from front end drop down table
// 	 	 
//   	 	 if(isAdmin) {
//   	 		 roleNames.add("Admin");
//  	 	 }else{
//  	 		 roleNames.add("User");
//   	 	 }
		// TODO:
		// userService.saveUser(userDto,Role.class); // a set of string roles
		userService.saveUser(userDto);
		return "redirect:/register?success";
	}

	 //handler method is used to handle a list of users
    @GetMapping("/userslist")
    public String userslist(Model model) {
    		List<UserDto> users = userService.findAllUsers();
    		model.addAttribute("users", users);
            return "usersinfo";
    }

	// @PreAuthorize("hasRole('ROLE_ADMIN')")

	@GetMapping("/users")
	public String userInfo(@ModelAttribute("u")  UserDto userDto, Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		log.info(auth.getName());
	    User loginUser = userService.findUserByEmail(auth.getName());
      	log.info("&&&&&&&&&&&&&&&" + loginUser.getName() );
//		
//		//get user data from DB
        model.addAttribute("loginUser",loginUser);
		return "profilemain";
	}
	

	
}
