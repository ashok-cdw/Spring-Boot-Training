package com.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.InsufficientBalance;

@Service("tss")
@Transactional
public class TransactionService {

	@Autowired
	private BankingService bss;

	public BankingService getBss() {
		return bss;
	}

	public void setBss(BankingService bss) {
		this.bss = bss;
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { InsufficientBalance.class })
	public void moneyTransfer(int crid, int drid, double amt) throws InsufficientBalance {
		bss.doCredit(amt, crid);
		bss.doDebit(amt, drid);
	}
}