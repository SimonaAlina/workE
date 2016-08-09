package com.endava.webfundamentals.signin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.endava.webfundamentals.signin.service.UserService;

@Controller
@RequestMapping("/users")
public class AllUsersController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String findAll(Model model) {
		model.addAttribute("userList", userService.findAll());
		return "users";
	}
}
