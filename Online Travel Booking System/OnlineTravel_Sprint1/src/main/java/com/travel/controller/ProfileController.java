package com.travel.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.travel.dto.ErrorDTO;
import com.travel.dto.MyDTO;
import com.travel.dto.UserDefaultResponseDTO;
import com.travel.entity.Profile;
import com.travel.entity.User;
import com.travel.service.ProfileService;
import com.travel.service.UserService;
import com.travel.util.UserDTOConvertor;

@RestController
@RequestMapping("/travel/profile")
@Validated
public class ProfileController {
	@Autowired
	ProfileService profileService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	UserDTOConvertor dtoConvertor;
	
	private final Logger mylogs = LoggerFactory.getLogger(this.getClass());
	
	@PostMapping("/add")
	public ResponseEntity<MyDTO> doProfileThings(@RequestBody @Valid Profile profile,@RequestParam String userName){
		User alreadySavedUser = null;
		try {
			System.out.println(" --- > "+mylogs);
			mylogs.info("---->>>Inside try of doprofile things");
			Profile savedProfile = profileService.addProfile(profile);
			if(savedProfile.getProfileId() != 0) {
				alreadySavedUser =userService.getUserByUserName(userName);
				if(alreadySavedUser!=null) {
					User profileAddUser = userService.linkProfile(savedProfile, alreadySavedUser);
					UserDefaultResponseDTO dtoResponse =dtoConvertor.getUserDefaultDTO(profileAddUser);
					return new ResponseEntity<>(dtoResponse, HttpStatus.OK);
				}
				else
				{
					mylogs.error("User not found in post mapping uri : add");
					throw new Exception("User not found ,  "+alreadySavedUser+" for "+userName);
				}
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
			ErrorDTO errorDTo = new ErrorDTO(e.getMessage());
			return new ResponseEntity<>(errorDTo, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return null;
	}
	
	
	

}
