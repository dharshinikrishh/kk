package com.travel.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.travel.entity.User;

@Repository
public interface IUserCustomRepository {
	public User getUserByUserName(String userName)throws Exception;
	public List<User> getUserByRole(String role)throws Exception;

	
}
