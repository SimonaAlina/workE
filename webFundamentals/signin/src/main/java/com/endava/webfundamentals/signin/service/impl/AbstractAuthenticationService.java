package com.endava.webfundamentals.signin.service.impl;

import com.endava.webfundamentals.signin.dto.UserCredentialDTO;
import com.endava.webfundamentals.signin.service.AuthenticationService;
import com.endava.webfundamentals.signin.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractAuthenticationService implements AuthenticationService {

	protected static final String SESSION = "session";

	// @Value("#{'${users}'.split(',')}")
	// protected List<String> users;
	//
	// @Value("${password:password}")
	// private String password;

	@Autowired
	UserService userService;

	@Override
	public boolean isValid(UserCredentialDTO userCredentialDTO) {
		// return userCredentialDTO != null &&
		// usernames.contains(userCredentialDTO.getUsername().toLowerCase()) &&
		// password.equals(userCredentialDTO.getPassword());
		return userCredentialDTO != null && userService.findByUsernameAndPassword(userCredentialDTO.getUsername(),
				userCredentialDTO.getPassword()) != null;
	}

}
