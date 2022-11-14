package com.travel.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.travel.entity.Profile;
import com.travel.entity.User;

@Service
public interface UserService {

	public User insertUser(User user)throws Exception;
	public List<User> getAllUsers()throws Exception;
	public User getUserByUserName(String userName)throws Exception;
	public List<User> getUserByRole(String role)throws Exception;
	public void delete(int id);
	public User linkProfile(Profile profile,User user);
	

	

}
