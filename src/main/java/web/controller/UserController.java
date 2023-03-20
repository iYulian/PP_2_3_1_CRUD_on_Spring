package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import web.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;


	public UserController() {
	}

	@GetMapping(value = "/")
	public String getUsers(ModelMap model) {
		userService.saveUser("123", "123", (byte) 32);
		model.addAttribute("users", userService.getAllUsers());
		return "users";

	}
	
}