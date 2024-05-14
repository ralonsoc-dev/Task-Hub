package com.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.model.dto.UserDto;
import com.model.entity.User;
import com.service.IUserService;

/**
 * Controller for operations with User entity
 * 
 * @autor Raul Alonso Calvarro [raul.ac-97@hotmail.com]
 * @since 1.0.0
 */
@RestController
@RequestMapping(path = "/api/v1")
public class UserController {

	@Autowired
	private IUserService iUserService;

	@PostMapping("user")
	@ResponseStatus(HttpStatus.CREATED)
	public UserDto create(@RequestBody UserDto userDto) {
		User userSave = iUserService.saveUser(userDto);

		return UserDto.builder()
				.id(userSave.getId())
				.firstName(userSave.getFirstName())
				.lastName(userSave.getLastName())
				.email(userSave.getEmail())
				.username(userSave.getUsername())
				.password(userSave.getPassword())
				.build();
	}

	@PutMapping("user")
	@ResponseStatus(HttpStatus.CREATED)
	public UserDto update(@RequestBody UserDto userDto) {
		User userUpdate = iUserService.saveUser(userDto);

		return UserDto.builder()
				.id(userUpdate.getId())
				.firstName(userUpdate.getFirstName())
				.lastName(userUpdate.getLastName())
				.email(userUpdate.getEmail())
				.username(userUpdate.getUsername())
				.password(userUpdate.getPassword())
				.build();
	}

	@DeleteMapping("user/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<?> delete(@PathVariable Integer id) {
		Map<String, Object> response = new HashMap<>();
		try {
			User userDelete = iUserService.findByIdUser(id);
			iUserService.deleteUser(userDelete);
			return new ResponseEntity<>(userDelete, HttpStatus.NO_CONTENT);
		} 
		catch (DataAccessException exDt) {
			response.put("Mensaje", exDt.getMessage());
			response.put("Usuario", null);
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("user/{id}")
	@ResponseStatus(HttpStatus.OK)
	public UserDto showById(@PathVariable Integer id) {
		User user = iUserService.findByIdUser(id);

		return UserDto.builder()
				.id(user.getId())
				.firstName(user.getFirstName())
				.lastName(user.getLastName())
				.email(user.getEmail())
				.username(user.getUsername())
				.password(user.getPassword())
				.build();
	}
}
