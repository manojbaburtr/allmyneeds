package com.example.simplelogin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.simplelogin.model.UserDetails;
import com.example.simplelogin.repository.UserRepository;

@Controller
public class FormController {
	
	private final UserRepository repo;

	public FormController(UserRepository repo) {
		this.repo = repo;
	}
	
	@GetMapping("/form")
	public String showForm(Model model) {
		model.addAttribute("user", new UserDetails());
		return "form";
	}
	
	@GetMapping("/login")
	public String showLoginPage(Model model) {
		return "login";
	}
	
	@PostMapping("/submit")
	public String submit(@ModelAttribute("user") UserDetails user, Model model) {
		repo.save(user);
		model.addAttribute("message", "Saved!");
		return "success";
	}

}
