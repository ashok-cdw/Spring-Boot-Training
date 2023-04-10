// User Service
package com.models;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userservice")
public class UserService{
	@Autowired
	UserDAO dao;
	
	public void createUser(User user) {
		dao.save(user);
	}
	
	public User findUserById(int id) {
		return dao.findById(id).orElse(null);
	}
	
	public List<User> findByName(String name) {
		return dao.findByName(name);
	}
	
}
