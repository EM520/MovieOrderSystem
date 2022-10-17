package com.elena.casestudy.movieordersystem.service;
import java.util.List;
import com.elena.casestudy.movieordersystem.dto.UserDto;
import com.elena.casestudy.movieordersystem.entity.User;
public interface UserService {
    
    void saveUser(UserDto userDto);
	User findUserByEmail(String email);
	List<UserDto> findAllUsers();
}


