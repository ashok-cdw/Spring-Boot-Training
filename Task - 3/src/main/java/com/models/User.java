// User Model
package com.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author ashok
 *
 */
@Entity
@Table(name = "bankuser")
public class User {
	@Id
	private int id;
	private String name;
	private double amount;
	/**
	 * method returns id of the user
	 * @return id
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * method sets id of the user
	 * @param id
	 * @return
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * method returns name of the user
	 * @return name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * method sets name of the user
	 * @param name
	 * @return
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * method returns amount of the user
	 * @return amount
	 */
	public double getAmount() {
		return amount;
	}
	
	/**
	 * method sets amount of the user
	 * @param amount
	 * @return
	 */
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	/**
	 * @return class members data
	 */
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", amount=" + amount + "]";
	}
	
}
