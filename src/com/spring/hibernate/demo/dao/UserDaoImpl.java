package com.spring.hibernate.demo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.hibernate.demo.domain.UserTest;

@Repository("userDao")
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionfactory;

	@Override
	@Transactional
	public void saveUser(UserTest user) {
		System.out.println("Saving User");
		sessionfactory.getCurrentSession().save(user);
		sessionfactory.getCurrentSession().flush();
		
	}

	@Override
	@Transactional
	public List<UserTest> getUser() {
		System.out.println("Get User");
		
		Session session = sessionfactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<UserTest> userlist = session.createCriteria(UserTest.class).list();
		sessionfactory.close();
		return userlist;
	}

}
