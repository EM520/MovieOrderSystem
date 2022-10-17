package com.elena.casestudy.movieordersystem.service.impl;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;import org.springframework.security.crypto.password.PasswordEncoder;
import com.elena.casestudy.movieordersystem.dto.UserDto;
import com.elena.casestudy.movieordersystem.entity.Role;
import com.elena.casestudy.movieordersystem.entity.User;
import com.elena.casestudy.movieordersystem.repository.RoleRepository;
import com.elena.casestudy.movieordersystem.repository.UserRepository;
import com.elena.casestudy.movieordersystem.service.UserService;
import com.elena.casestudy.movieordersystem.service.impl.UserServiceImpl;



@Service
public class UserServiceImpl implements UserService{
	@Autowired
	 private UserRepository userRepository;
	    private RoleRepository roleRepository;
	    private PasswordEncoder passwordEncoder;

	    public UserServiceImpl(UserRepository userRepository,
	                           RoleRepository roleRepository,
	                           PasswordEncoder passwordEncoder) {
	        this.userRepository = userRepository;
	        this.roleRepository = roleRepository;
	        this.passwordEncoder = passwordEncoder;
	    }

	    @Override
	    //public void saveUser(UserDto userDto,Set<String> roleNames)
	    public void saveUser(UserDto userDto) {
	        User user = new User();
	        user.setName(userDto.getFirstName() + " " + userDto.getLastName());
	        user.setEmail(userDto.getEmail());

	        //encrypt the password once we integrate spring security
	        //user.setPassword(userDto.getPassword());
	        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
	        List<Role> roles = new ArrayList <>();
	        Role role=roleRepository.findByName("ROLE_USER");
	        if(role==null) {role=addMissingRole("user");}
	        roles.add(role);
//	        Role role1=roleRepository.findByName("ROLE_USER");
//	        if(role1==null) {role1=addMissingRole("admin");}
//	        roles.add(role1);
//	        for (String name:roleNames) {
//	        		Role role = roleRepository.findByName(
//	        				"ROLE_" + name.toUpperCase()
//	        				);
//	        		 if(role==null) {
//	        			 role=addMissingRole(name);
//	        		}
//	     	    roles.add(role);
//	        }
	        
	        user.setRoles(roles);
	        userRepository.save(user);
	    }

	    @Override
	    public User findUserByEmail(String email) {
	        return userRepository.findByEmail(email);
	    }

	    @Override
	    public List<UserDto> findAllUsers() {
	        List<User> users = userRepository.findAll();
	        return users.stream().map((user) -> convertEntityToDto(user))
	                .collect(Collectors.toList());
	    }

	    private UserDto convertEntityToDto(User user){
	        UserDto userDto = new UserDto();
	        String[] name = user.getName().split(" ");
	        userDto.setFirstName(name[0]);
	        userDto.setLastName(name[1]);
	        userDto.setEmail(user.getEmail());
	        return userDto;
	    }

	    private Role addMissingRole(String roleName) {
	        Role role = new Role();
	        role.setName("ROLE_"+roleName.toUpperCase());
	        return roleRepository.save(role);
	    }

		

}