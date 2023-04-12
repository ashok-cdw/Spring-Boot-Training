// User DAO
package com.example.demo.models;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author ashok
 * UserDAO interface extends the JpaRepository Methods
 */
@Repository
public interface UserDAO extends JpaRepository<User, Integer>{
	/**
	 * @param name
	 * @return List<User>
	 */
	public List<User> findByName(String name);
}
