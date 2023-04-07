package com.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.InsufficientBalance;

@Service("bss")
@Transactional
public class BankingService {

	@Autowired
	private AccountsDAO dao;

	@Transactional(propagation = Propagation.REQUIRED)
	public void doCredit(double cramt, int aceid) {
		AccountsDTO dto = dao.findByID(aceid);
		double amt = dto.getSalary();
		double newamt = amt + cramt;
		dto.setSalary(newamt);
		dao.updateUser(dto);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void doDebit(double dramt, int aceid) throws InsufficientBalance {
		AccountsDTO dto = dao.findByID(aceid);
		double amt = dto.getSalary();
		if (amt < dramt) {
			throw new InsufficientBalance("Not enough money to transfer....");
		}
		double newamt = amt - dramt;
		dto.setSalary(newamt);
		dao.updateUser(dto);
	}
}