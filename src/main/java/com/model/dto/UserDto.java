package com.model.dto;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Builder
public class UserDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

	private String email;

	private String password;

	private String firstName;

	private String lastName;

	private String username;

}
