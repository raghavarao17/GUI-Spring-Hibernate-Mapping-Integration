package com.spring.hibernate.demo.service;

import java.util.List;

import com.spring.hibernate.demo.domain.UserTest;

public interface UserService {
	public void addUser(UserTest user);

	public List<UserTest> getUser();
}
