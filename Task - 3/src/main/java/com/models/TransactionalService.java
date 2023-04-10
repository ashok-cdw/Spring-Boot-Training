// Money Transactional Service
package com.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.TransactionalException;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class TransactionalService {
	@Autowired
	private BankingService bankingService;

	@Transactional(propagation = Propagation.REQUIRED)
	public void moneyTransfer(int crid, int drid, double amount) throws Exception{
		bankingService.doCredit(crid, amount);
		bankingService.doDebit(drid, amount);
	}
}
