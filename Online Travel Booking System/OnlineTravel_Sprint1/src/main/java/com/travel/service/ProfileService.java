package com.travel.service;

import org.springframework.stereotype.Service;

import com.travel.entity.Profile;

@Service
public interface ProfileService {
	public Profile addProfile(Profile profile);
}
