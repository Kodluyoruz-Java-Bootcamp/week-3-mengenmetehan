package com.emlakcepte.controller;


import com.emlakcepte.model.Realty;
import com.emlakcepte.model.User;
import com.emlakcepte.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/users")
public class UserController {
	
	// injection işlemi, spring tarafından oluşan objenin bağlanması. Default tanımı singleton.
	private final UserService service;

	public UserController(UserService service)
	{
		this.service = service;
	}

	// GET /users
	@GetMapping
	public List<User> getAll() {
		
		System.out.println("getAll - userService :: " + service);
		return service.getAllUser();
	}

	// POST /users
	// @RequestMapping(method = RequestMethod.POST, value = "/saveUser") --best
	// practise ters
	@PostMapping
	// @ResponseStatus(code = HttpStatus.CREATED)
	public ResponseEntity<User> create(@RequestBody User user) {
		//UserService service = new UserService();
		service.createUser(user);
		// return user;
		System.out.println("create - userService :: " + service);
		return new ResponseEntity<>(user, HttpStatus.CREATED);
	}

	// GET /users/{email} -> /users/cemdrman@gmail.com
	@GetMapping(value = "/{email}")
	public User getByEmail(@PathVariable String email) {
		System.out.println("gelen email request'i: " + email);
		//UserService service = new UserService();
		System.out.println("getByEmail - userService :: " + service);
		return service.getByEmail(email);
	}

	@GetMapping("recordedrealty")
	public List<Realty> getRecordedRealty(User user)
	{
		return service.getRecordedRealty(user);
	}

	@PostMapping("createuser")
	public ResponseEntity<Realty> saveRecordRealty(@RequestBody User user, @RequestBody Realty realty)
	{
		service.saveRecordedRealty(user, realty);
		System.out.printf("%s kullancısı %s realty'sini kaydetti", user, realty);

		return new ResponseEntity<>(realty, HttpStatus.OK);
	}




}
