package com.models;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository("acedao")
public class AccountsDAO {
	
	@Autowired
	private SessionFactory factory;
	
	public AccountsDTO findByID(int aceid) {
		Session session = factory.getCurrentSession();
		AccountsDTO dto=session.get(AccountsDTO.class,Integer.valueOf(aceid));
		return dto;
	}
	
	public void updateUser(AccountsDTO dto) {
		Session session = factory.getCurrentSession();
		session.persist(dto);
	}
	
	public SessionFactory getFactory() {
		return factory;
	}
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}
}