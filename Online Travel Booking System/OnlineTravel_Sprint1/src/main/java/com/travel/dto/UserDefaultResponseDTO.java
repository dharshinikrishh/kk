package com.travel.dto;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class UserDefaultResponseDTO implements MyDTO
{
	private String userName;
	private int userId;
	private String registeredEmail;
	private String remarks;
}
