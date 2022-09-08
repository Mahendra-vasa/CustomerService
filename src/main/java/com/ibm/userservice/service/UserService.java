package com.ibm.userservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ibm.userservice.dao.UserServiceRepository;
import com.ibm.userservice.entity.User;

@Service
public class UserService {
	 @Autowired
	  UserServiceRepository userServiceRepository;

     public String createUser(User user) {
    	 userServiceRepository.save(user);
       return "User Created For: "+user.getUserName();
     }
     
     public User getUserByName(String username) {
    	 User user = userServiceRepository.getUserByUsername(username);
       return user;
     }
}
