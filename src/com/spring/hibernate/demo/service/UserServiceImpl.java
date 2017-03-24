package com.spring.hibernate.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.hibernate.demo.dao.UserDao;
import com.spring.hibernate.demo.domain.UserTest;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;

	@Override
	public void addUser(UserTest user) {
		userDao.saveUser(user);
	}

	@Override
	public List<UserTest> getUser() {
		return userDao.getUser();
	}

}
