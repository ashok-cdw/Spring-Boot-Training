// User Service
package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.models.User;
import com.models.UserDAO;

/**
 * @author ashok
 *
 */
@Service("userservice")
public class UserService{
	
	@Autowired
	UserDAO dao;
	
	/**
	 * method creates new user with passed data
	 * @param user
	 */
	public void createUser(User user) {
		dao.save(user);
	}
	
	/**
	 * method finds user by id
	 * @param id
	 * @return user/null
	 */
	public User findUserById(int id) {
		return dao.findById(id).orElse(null);
	}
	
	/**
	 * method finds user by name
	 * @param name
	 * @return user/null
	 */
	public List<User> findByName(String name) {
		return dao.findByName(name);
	}
	
}
