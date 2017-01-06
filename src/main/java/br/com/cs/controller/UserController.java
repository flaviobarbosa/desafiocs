package br.com.cs.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.cs.dao.UserDao;
import br.com.cs.model.User;

@Controller
public class UserController {
	
	@Autowired
	UserDao userDao;

	@RequestMapping("/user")
	public String main() {
		System.out.println("UserController!");
		return "index";
	}
	
	@RequestMapping("/user/add")
	public ResponseEntity add() {
		User user = new User();
		user.setName("Flavio");
		user.setEmail("email@email.com");
		user.setCreated(new Date());
		user.setLastLogin(new Date());
		user.setModified(new Date());
		user.setPassword("123");
		
		userDao.save(user);
		
		return new ResponseEntity(user, HttpStatus.OK);
	}
}
