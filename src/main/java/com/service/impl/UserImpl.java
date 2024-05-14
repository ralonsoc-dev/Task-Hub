package com.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.model.dao.UserDao;
import com.model.dto.UserDto;
import com.model.entity.User;
import com.service.IUserService;

@Service
public class UserImpl implements IUserService{

	@Autowired
	private UserDao userDao;
	
	@Transactional
	@Override
	public User saveUser(UserDto userDto) {
		User user = User.builder()
				.id(userDto.getId())
				.firstName(userDto.getFirstName())
				.lastName(userDto.getLastName())
				.email(userDto.getEmail())
				.username(userDto.getUsername())
				.password(userDto.getPassword())
				.build();
		return userDao.save(user);
	}

	@Transactional(readOnly = true)
	@Override
	public User findByIdUser(Integer id) {
		return userDao.findById(id).orElse(null);
	}

	@Transactional
	@Override
	public void deleteUser(User user) {
		userDao.delete(user);
	}

}
