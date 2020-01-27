package com.app.controller;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dao.IUserDao;
import com.app.pojos.LoginDetails;
import com.app.pojos.User;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

	@Autowired
	private IUserDao udao;

	@PostConstruct
	public void myInit() {
		System.out.println("Inside init of .." + getClass().getName());
	}

	@PostMapping("/login")
	public ResponseEntity<?> validUser(@RequestBody LoginDetails l) {
		System.out.println("in login dtls " + l);
		try {
			return new ResponseEntity<LoginDetails>(udao.validateUser(l), HttpStatus.OK);
		} catch (RuntimeException e1) {
			e1.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/register")
	public ResponseEntity<?> registerUser(@RequestBody User u){
		System.out.println("in register user "+u);
		try {
			return new ResponseEntity<User>(udao.registerUser(u), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
	}

}
