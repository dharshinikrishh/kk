package com.travel.util;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.travel.dto.UserDefaultResponseDTO;
import com.travel.entity.User;

@Component
@Scope("singleton")
public class UserDTOConvertor {
	public static UserDefaultResponseDTO getUserDefaultDTO(User user) {
		UserDefaultResponseDTO dto = new UserDefaultResponseDTO(user.getUserName(), user.getUserId(),
				user.getUserProfile().getEmail(),
				"User Profile Created , Profile Id : " + user.getUserProfile().getProfileId());

		return dto;
	}

}
