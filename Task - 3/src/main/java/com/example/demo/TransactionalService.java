package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class TransactionalService {
	@Autowired
	private BankingService bankingService;

	@Transactional(propagation = Propagation.REQUIRED)
	public void moneyTransfer(int crid, int drid, double amount) throws TransactionalException{
		bankingService.doCredit(crid, amount);
		bankingService.doDebit(drid, amount);
	}
}
