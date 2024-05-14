package com.service;

import com.model.dto.UserDto;
import com.model.entity.User;

public interface IUserService {

	User saveUser(UserDto user);
	
	User findByIdUser(Integer id);
	
	void deleteUser(User user);
	
	
}
