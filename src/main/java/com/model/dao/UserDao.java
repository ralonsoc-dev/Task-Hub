package com.model.dao;

import org.springframework.data.repository.CrudRepository;

import com.model.entity.User;

public interface UserDao extends CrudRepository<User, Integer>{

}
