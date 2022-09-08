package com.ibm.userservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.ibm.userservice.entity.User;
import com.ibm.userservice.service.UserService;

@RestController
public class UserServiceController {
	@Autowired
    UserService userService;
	private static Logger log = LoggerFactory.getLogger(UserServiceController.class);
	
    @PostMapping("/saveUser")
    public ResponseEntity<String> saveUser(@RequestBody User user) {
   	    System.out.println("user"+user);
   	    log.debug("saveUser", user);
   	    String userResponse = userService.createUser(user); 
   	    return ResponseEntity.status(HttpStatus.OK).body(userResponse);
   	}
    
    @GetMapping("/getUser/{name}")
    public ResponseEntity<User> getUserByName(@PathVariable String name) {
    	System.out.println("userName"+name);
    	log.debug("userName", name);
    	User userDetails =  userService.getUserByName(name);
    	return ResponseEntity.status(HttpStatus.OK).body(userDetails);
    }

}
