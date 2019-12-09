package com.ncit.minor.futsalbookingapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ncit.minor.futsalbookingapp.model.User;
import com.ncit.minor.futsalbookingapp.service.impl.UserServiceImpl;

@Controller
@RequestMapping("/user")
public class RegisterController {

	@Autowired
	UserServiceImpl userService;
	@Autowired
	PasswordEncoder passwordEncoder;

	@GetMapping("/add")
	public String signUp(Model model) {
		model.addAttribute("user", new User());
		return "signup";
	}

	@PostMapping("/add")
	public String doSignUp(@ModelAttribute("user") User user, Model model) {
		
		if (userService.findByUsername(user.getUsername()) != null) {
			model.addAttribute("usernameExists", true);
			return "signup";
		}
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		model.addAttribute("user", user);
		userService.save(user);
		System.out.println(user);
		return "redirect:/";
	}
}
