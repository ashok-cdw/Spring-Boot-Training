// Banking Service
package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.exception.InvalidUserIdException;
import com.example.demo.exception.TransactionalException;
import com.example.demo.models.User;
import com.example.demo.models.UserDAO;

/**
 * @author ashok
 *
 */
@Service("bankingservice")
@Transactional(propagation = Propagation.REQUIRED)
public class BankingService {
	@Autowired
	private UserDAO userdao;

	/**
	 * method returns userdao object
	 * 
	 * @param null
	 * @return userdao
	 */
	public UserDAO getUserdao() {
		return userdao;
	}

	/**
	 * method sets userdao object
	 * 
	 * @param userdao
	 * @return
	 */
	public void setUserdao(UserDAO userdao) {
		this.userdao = userdao;
	}

	/**
	 * method does credit of money into account / throws an Exception if user is
	 * invalid
	 * 
	 * @param crid
	 * @param amount
	 * @throws Exception
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public void doCredit(int crid, double amount) throws Exception {
		User user = userdao.findById(crid).orElse(null);
		if (user == null) {
			throw new InvalidUserIdException("Transaction Failed - Invalid Credit Id : " + crid);
		}
		double newAmount = user.getAmount() + amount;
		user.setAmount(newAmount);
		userdao.save(user);
	}

	/**
	 * method does debit of money from account / throws an Exception if user is
	 * invalid or Insufficient Balance
	 * 
	 * @param crid
	 * @param amount
	 * @throws Exception
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public void doDebit(int drid, double amount) throws Exception {

		User user = userdao.findById(drid).orElse(null);
		if (user == null) {
			throw new InvalidUserIdException("Transaction Failed - Invalid Debit Id : " + drid);
		} else if (amount > user.getAmount()) {
			throw new TransactionalException("Transaction Failed - Insufficient Balance");
		}
		double newAmount = user.getAmount() - amount;
		user.setAmount(newAmount);
		userdao.save(user);
	}
}
