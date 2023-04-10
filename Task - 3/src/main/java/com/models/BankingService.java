// Banking Service
package com.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.InvalidUserIdException;
import com.example.demo.TransactionalException;

@Service("bankingservice")
@Transactional(propagation = Propagation.REQUIRED)
public class BankingService {
	@Autowired
	private UserDAO userdao;

	public UserDAO getUserdao() {
		return userdao;
	}

	public void setUserdao(UserDAO userdao) {
		this.userdao = userdao;
	}

	// Do Credit Method	
	@Transactional(propagation = Propagation.REQUIRED)
	public void doCredit(int crid, double amount) throws Exception {
		User user = userdao.findById(crid).orElse(null);
		if(user == null) {
			throw new InvalidUserIdException("Transaction Failed - Invalid User Id");
		}
		double newAmount = user.getAmount() + amount;
		user.setAmount(newAmount);
		userdao.save(user);
	}

	// Do Debit Method	
	@Transactional(propagation = Propagation.REQUIRED)
	public void doDebit(int drid, double amount) throws Exception {
		User user = userdao.findById(drid).orElse(null);
		if(user == null) {
			throw new InvalidUserIdException("Transaction Failed - Invalid User Id");
		}
		else if (amount > user.getAmount()) {
			throw new TransactionalException("Transaction Failed - Insufficient Balance");
		}
		double newAmount = user.getAmount() - amount;
		user.setAmount(newAmount);
		userdao.save(user);
	}
}
