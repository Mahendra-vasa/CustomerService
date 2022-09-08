package com.ibm.userservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ibm.userservice.entity.User;

public interface UserServiceRepository extends JpaRepository <User , Integer>{
	//@Query("SELECT u FROM User u WHERE u.username = :userName")
	//public User getUserByUsername(@Param("username") String userName);
	
	 @Query("FROM User where userName=?1")
	 public User getUserByUsername(String userName);
}