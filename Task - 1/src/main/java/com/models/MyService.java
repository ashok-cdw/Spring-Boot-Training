package com.models;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("MyService")
@Transactional
public class MyService {
	
	@Autowired
	AccountsDAO dao;
	
	
	public void doServe(int id, double amount) {
		AccountsDTO dto = dao.findByID(id);
		dto.setSalary(amount);
		dao.updateUser(dto);
	}


	public AccountsDAO getDao() {
		return dao;
	}


	public void setDao(AccountsDAO dao) {
		this.dao = dao;
	}
}
