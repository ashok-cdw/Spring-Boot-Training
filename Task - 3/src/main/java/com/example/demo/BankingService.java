package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("bankingservice")
@Transactional(propagation = Propagation.REQUIRED)
public class BankingService {
	@Autowired
	private UserDAO userdao;

	@Transactional(propagation = Propagation.REQUIRED)
	public void doCredit(int crid, double amount) {
		User user = userdao.findById(crid).orElse(null);
		double newAmount = user.getAmount() + amount;
		user.setAmount(newAmount);
		userdao.save(user);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void doDebit(int drid, double amount) throws TransactionalException{
		User user = userdao.findById(drid).orElse(null);
		if(amount > user.getAmount()) {
			throw new TransactionalException("Insufficient Balance");
		}
		double newAmount = user.getAmount() - amount;
		user.setAmount(newAmount);
		userdao.save(user);
	}
}
