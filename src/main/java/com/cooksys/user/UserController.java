package com.cooksys.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("users")
public class UserController {
	
	private final UserService userService;
	
	@Autowired
	public UserController (UserService userService) {
		super();
		this.userService = userService;
	}

}
