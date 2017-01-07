package br.com.cs.controller;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.cs.dao.UserDao;
import br.com.cs.model.Login;
import br.com.cs.model.User;
import br.com.cs.wrapper.ResponseWrapper;
import br.com.cs.wrapper.UserWrapper;

@Controller
@Transactional
public class UserController {
	
	@Autowired
	UserDao userDao;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/user/add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST )
	public ResponseEntity add(@RequestBody User user) {
		
		try {
			if(userDao.findByEmail(user.getEmail()) == null) {
				Date date = new Date();
				user.setCreated(date);
				user.setModified(date);
				user.setLastLogin(date);
				user.setToken(UUID.randomUUID().toString());
				
				String encryptedPassword = encryptPassword(user.getPassword());
				user.setPassword(encryptedPassword);
				
				userDao.save(user);

				UserWrapper userWrapper = new UserWrapper(user); 
				
				return new ResponseEntity(userWrapper, HttpStatus.OK);
				
			} else {
				String errorMessage = "E-mail j� existente";
				ResponseWrapper responseWrapper = new ResponseWrapper(errorMessage);
				
				return new ResponseEntity(responseWrapper, HttpStatus.CONFLICT);
			}
		} catch (Exception e) {
			String errorMessage = e.getMessage();
			ResponseWrapper responseWrapper = new ResponseWrapper(errorMessage);
			
			return new ResponseEntity(responseWrapper, HttpStatus.INTERNAL_SERVER_ERROR);
		} 
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/user/login", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST )
	public ResponseEntity login(@RequestBody Login login) {
		
		try {
			User user = userDao.findByEmail(login.getEmail());
			
			if(user != null) {
				String loginEncryptedPassword = encryptPassword(login.getPassword());
				
				if(loginEncryptedPassword.equals(user.getPassword())) {
					user.setLastLogin(new Date());
					
					userDao.save(user);
					
					UserWrapper userWrapper = new UserWrapper(user); 
					
					return new ResponseEntity(userWrapper, HttpStatus.OK);
				} else {
					String errorMessage = "Usu�rio e/ou senha inv�lidos";
					ResponseWrapper responseWrapper = new ResponseWrapper(errorMessage);
					
					return new ResponseEntity(responseWrapper, HttpStatus.UNAUTHORIZED);
				}
			} else {
				String errorMessage = "Usu�rio e/ou senha inv�lidos";
				ResponseWrapper responseWrapper = new ResponseWrapper(errorMessage);
				
				return new ResponseEntity(responseWrapper, HttpStatus.FORBIDDEN);
			}
		} catch (Exception e) {
			String errorMessage = e.getMessage();
			ResponseWrapper responseWrapper = new ResponseWrapper(errorMessage);
			
			return new ResponseEntity(responseWrapper, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	private String encryptPassword(String password) {
		return DigestUtils.md5DigestAsHex(password.getBytes());
	}
}
