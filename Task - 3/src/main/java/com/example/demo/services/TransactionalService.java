// Money Transactional Service
package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.exception.TransactionalException;

/**
 * @author ashok
 */
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class TransactionalService {
	
	@Autowired
	private BankingService bankingService;

	/**
	 * method invokes do credit and do debit methods
	 * @param crid
	 * @param drid
	 * @param amount
	 * @throws Exception
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public void moneyTransfer(int crid, int drid, double amount) throws Exception{
		try {
			bankingService.doDebit(drid, amount);
			bankingService.doCredit(crid, amount);
		}
		catch (Exception e) {
			throw e;
		}
	}
}
