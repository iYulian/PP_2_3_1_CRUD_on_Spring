package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import web.model.User;
import web.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;


	public UserController() {
	}

	@GetMapping(value = "/")
	public String getUsers(ModelMap model) {
		model.addAttribute("users", userService.getAllUsers());
		return "users";

	}

	@RequestMapping(value = "/addUser")
	public String addUser(ModelMap model) {
		model.addAttribute("user", new User());
		return "saveUser";
	}

	@RequestMapping(value = "/saveUser")
	public String saveUser(@ModelAttribute("user") User user) {
		userService.saveUser(user);
		return "redirect:/";
	}

	@RequestMapping(value = "/updateUser", produces = "text/html; charset=utf-8")
	public String updateUser(@ModelAttribute("id") long id, ModelMap model) {
		model.addAttribute("user", userService.getUserById(id));
		return "saveUser";
	}

	@RequestMapping(value = "/deleteUser")
	public String deleteUser(@ModelAttribute("id") long id) {
		userService.removeUserById(id);
		return "redirect:/";
	}

	
}