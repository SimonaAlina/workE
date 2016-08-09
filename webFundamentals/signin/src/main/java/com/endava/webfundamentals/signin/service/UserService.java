package com.endava.webfundamentals.signin.service;

import java.util.List;

import com.endava.webfundamentals.signin.dto.UserRegisterDTO;

public interface UserService {

	UserRegisterDTO saveUser(UserRegisterDTO userRegisterDTO);
	List<UserRegisterDTO> findAll();
	UserRegisterDTO findByUsername(String username);
	UserRegisterDTO findByUsernameAndPassword(String username, String password);
}
