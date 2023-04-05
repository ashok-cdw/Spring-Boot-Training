package com.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "accounts")
public class AccountsDTO {

	@Id
	private int aceid;
	private double salary;

	public double getAceid() {
		return aceid;
	}

	public void setAceid(int aceid) {
		this.aceid = aceid;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

}