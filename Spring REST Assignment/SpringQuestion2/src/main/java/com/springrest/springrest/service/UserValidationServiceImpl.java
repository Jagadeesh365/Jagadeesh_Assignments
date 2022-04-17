package com.springrest.springrest.service;

import org.springframework.stereotype.Service;

@Service
public class UserValidationServiceImpl implements UserValidationService {

	@Override
	public boolean isUserValid(String user, String password) {
		if (user.equals("Jagadeesh") && password.equals("Jagadeesh")) {
			return true;
		}
		return false;
	}

}
