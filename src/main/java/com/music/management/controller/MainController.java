package com.music.management.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class MainController {

	@GetMapping("/")
	public String home() {
		return "Home";
	}
}
