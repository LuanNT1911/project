package com.rest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rest.domain.ImageTest;
import com.rest.domain.Role;
import com.rest.domain.UserAccount;
import com.rest.domain.UserAccountRespone;
import com.rest.domain.UserProfile;
import com.rest.repository.UserAccountRepository;
import com.rest.repository.UserProfileRepository;

import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;

@Controller
@RequestMapping(path = "IFAR")
public class UserAccountController {
	@Autowired
	private UserAccountRepository userAccountRepository;
	@Autowired
	private UserProfileRepository userProfileRepository;

	@PostMapping(path = "addUserAccount")
	public @ResponseBody String addUserAccount(@RequestParam String username, @RequestParam String password) {
		// @ResponseBody means the returned String is the response, not a view
		// name
		// @RequestParam means it is a parameter from the GET or POST request
		Role role = new Role("admin");
		UserAccount userAccount = new UserAccount();
		userAccount.setUsername(username);
		userAccount.setPassword(password);
		userAccount.setRole(role);
		// userAccountRepository.save(userAccount);
		return "Saved";
	}

	@PostMapping(path = "checkLogin")
	public ResponseEntity<UserAccountRespone> login(@RequestParam(value = "username", required = true) String username,
			@RequestParam(value = "password", required = true) String password) {
		UserAccount userAccount = userAccountRepository.login(username, password);
		UserProfile userProfile = userProfileRepository.getUserProfile(username);

		if (userAccount != null) {
			UserAccountRespone userAccountRespone = new UserAccountRespone(username, userProfile.getFullname(),
					userProfile.getBirth(), userProfile.getAddress(), userProfile.getCity(), userProfile.getEmail(),
					userProfile.getPhone(), userProfile.getSexual(), userProfile.getCreatedAt(),
					userProfile.getUpdatedAt(), userAccount.getRole().getId(), userAccount.getRole().getName());

			return new ResponseEntity<UserAccountRespone>(userAccountRespone, HttpStatus.OK);
		} else {
			return new ResponseEntity<UserAccountRespone>(new UserAccountRespone(), HttpStatus.OK);
		}
	}

	@SuppressWarnings("deprecation")
	@PostMapping(path = "/checkLoginMobile")
	public ResponseEntity<UserAccountRespone> loginMobile(@RequestBody String account) throws ParseException {

		JSONParser parser = new JSONParser();

		JSONObject json = (JSONObject) parser.parse(account);
		String username = json.get("username").toString();
		String password = json.get("password").toString();
		UserAccount userAccount = userAccountRepository.login(username, password);
		UserProfile userProfile = userProfileRepository.getUserProfile(username);

		if (userAccount != null) {
			UserAccountRespone userAccountRespone = new UserAccountRespone(username, userProfile.getFullname(),
					userProfile.getBirth(), userProfile.getAddress(), userProfile.getCity(), userProfile.getEmail(),
					userProfile.getPhone(), userProfile.getSexual(), userProfile.getCreatedAt(),
					userProfile.getUpdatedAt(), userAccount.getRole().getId(), userAccount.getRole().getName());

			return new ResponseEntity<UserAccountRespone>(userAccountRespone, HttpStatus.OK);
		} else {
			return new ResponseEntity<UserAccountRespone>(new UserAccountRespone(), HttpStatus.OK);
		}
	}

	@GetMapping(path = "allUser")
	public @ResponseBody Iterable<UserAccount> getAllUsers() {
		// This returns a JSON or XML with the users
		return userAccountRepository.getAll();
	}

	@GetMapping(path = "getLink")
	public ResponseEntity<List<ImageTest>> getLink() {
		List<ImageTest> result = new ArrayList<>();
		result.add(new ImageTest("file1", "https://s3.amazonaws.com/3dimagetest/binhco/IMG_3809.JPG"));
		result.add(new ImageTest("file2", "https://s3.amazonaws.com/3dimagetest/binhco/IMG_3810.JPG"));
		result.add(new ImageTest("file3", "https://s3.amazonaws.com/3dimagetest/binhco/IMG_3811.JPG"));
		result.add(new ImageTest("file4", "https://s3.amazonaws.com/3dimagetest/binhco/IMG_3812.JPG"));
		return new ResponseEntity<List<ImageTest>>(result, HttpStatus.OK);

	}

	@GetMapping(path = "getParam")
	public ResponseEntity<String> getParam(@RequestParam String param, @RequestBody String pram) {

		return new ResponseEntity<String>(param, HttpStatus.OK);

	}
}
