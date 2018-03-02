package com.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rest.domain.UserProfile;
import com.rest.repository.UserProfileRepository;

@Controller
@RequestMapping(path = "IFAR")
public class UserProfileController {
	@Autowired
	private UserProfileRepository userProfileRepository;

	@PostMapping(path = "getUserProfile")
	public String getUserProfile(
			@RequestParam(value = "userAccountUsername", required = true) String userAccountUsername) {
		System.out.println("user " + userAccountUsername);
		UserProfile userProfile = userProfileRepository.getUserProfile(userAccountUsername);
		System.out.println(userProfile.getUserAccountUsername());
		System.out.println(userProfile.getFullname());
		System.out.println(userProfile.getAddress());
		return "anc";
	}
}
