package com.springrest.springrest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springrest.springrest.service.UserValidationService;

@Controller
public class UserLoginController {

	@Autowired
	private UserValidationService userValidationService;

	public UserLoginController(UserValidationService userValidationService) {
		super();
		this.userValidationService = userValidationService;
	}

	@GetMapping("loginForm")
	public String getForm() {
		return "login";
	}

	@PostMapping("/checkDetails")
	public String handleLoginRequest(@RequestParam("userName") String userName,
			@RequestParam("password") String password, ModelMap modelMap) {
		if (userValidationService.isUserValid(userName, password)) {
			modelMap.put("userName", userName);
			modelMap.put("password", password);
			return "welcome";
		} else {
			modelMap.put("errorMessage", "Invalid User");
			return "login";
		}
	}
}
