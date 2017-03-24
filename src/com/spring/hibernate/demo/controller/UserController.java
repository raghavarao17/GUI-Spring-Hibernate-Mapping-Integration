package com.spring.hibernate.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.hibernate.demo.domain.DeptTest;
import com.spring.hibernate.demo.domain.UserTest;
import com.spring.hibernate.demo.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping("/register")
	public ModelAndView getRegisterForm(@ModelAttribute("user") UserTest user,
			BindingResult result) {
		ArrayList<String> gender = new ArrayList<String>();
		gender.add("Male");
		gender.add("Female");
		ArrayList<String> city = new ArrayList<String>();
		city.add("Delhi");
		city.add("Kolkata");
		city.add("Chennai");
		city.add("Bangalore");
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("gender", gender);
		model.put("city", city);
		System.out.println("Register Form");
		return new ModelAndView("Register", "model", model);
	}

	@RequestMapping("/saveUser")
	public ModelAndView saveUserData(@ModelAttribute("user") UserTest user,
			BindingResult result) {
		System.out.println(" Teting @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@  :  "+user.getDeptTest().getDeptId());
		userService.addUser(user);
		System.out.println("Save User Data");
		return new ModelAndView("redirect:/userList.html");
	}

	@RequestMapping("/userList")
	public ModelAndView getUserList() {
		System.out.println("getUserList : 1111111111111111");
		Map<String, Object> model = new HashMap<String, Object>();
		List<UserTest> userList = userService.getUser();
		System.out.println("getUserList : 222222222222222222222");
		for(UserTest userTest : userList){
			System.out.println("getUserList : 33333333333333");
			if("Chow".equals(userTest.getLastName())){
				System.out.println("getUserList : 444444444444444");
				DeptTest d = userTest.getDeptTest();
				System.out.println("Dept number :"+d.getDeptName());
			}
		}
		model.put("user",userList);
		return new ModelAndView("UserDetails", model);

	}
}
