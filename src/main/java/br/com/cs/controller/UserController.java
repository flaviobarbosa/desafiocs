package br.com.cs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

	@RequestMapping("/user")
	public String main() {
		System.out.println("UserController!");
		return "index";
	}
}
