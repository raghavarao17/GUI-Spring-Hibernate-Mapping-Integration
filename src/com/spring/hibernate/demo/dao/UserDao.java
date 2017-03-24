package com.spring.hibernate.demo.dao;

import java.util.List;

import com.spring.hibernate.demo.domain.UserTest;

public interface UserDao {
public void saveUser ( UserTest user );
public List<UserTest> getUser();
}
