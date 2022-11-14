package com.travel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.travel.entity.User;
import com.travel.service.UserService;

@RestController
@RequestMapping("/travel/admin")
public class AdminController {

	@Autowired
	UserService userService;
	
	@PostMapping("/addadmin")
	public ResponseEntity<String> addUser(@RequestBody User user) {
		try {
			User savedUser = userService.insertUser(user);
			String responseMsg = savedUser.getUserName() + " save with Id " + savedUser.getUserId();
			return new ResponseEntity<String>(responseMsg, HttpStatus.OK);
		} catch (Exception e) {
			String errorMsg = "Contact to customer care 1800-250-960 or mail us :- care@capg.com";
			return new ResponseEntity<String>(errorMsg, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/users")
	public List<User> getAllUsers() {
		try {
			List<User> allExtractedUsers = userService.getAllUsers();

			return allExtractedUsers;

		} catch (Exception e) {
			System.out.println(e);

		}

		return null;
	}
	@GetMapping("/user/{searchUserName}")
	public User abc(@PathVariable String searchUserName)throws Exception
	{
		return userService.getUserByUserName(searchUserName);
	}
	@GetMapping("/role/{searchRole}")
	public List<User>abc1(@PathVariable String searchRole)throws Exception
	{
		System.out.println("----->> 1 Inside Controller"+searchRole);
		return userService.getUserByRole(searchRole);
	}
	
}
