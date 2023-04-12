// Transactional Model
package com.example.demo.models;

/**
 * @author ashok
 *
 */
public class Transaction {
	private int crid;
	private int drid;
	private double amount;

	/**
	 * method returns crid
	 * 
	 * @return crid
	 */
	public int getCrid() {
		return crid;
	}

	/**
	 * method sets crid
	 * 
	 * @param crid
	 * @return
	 */
	public void setCrid(int crid) {
		this.crid = crid;
	}

	/**
	 * method returns drid
	 * 
	 * @return drid
	 */
	public int getDrid() {

		return drid;
	}

	/**
	 * method sets drid
	 * 
	 * @param drid
	 * @return
	 */
	public void setDrid(int drid) {
		this.drid = drid;
	}

	public double getAmount() {
		return amount;
	}

	/**
	 * method sets amount
	 * 
	 * @param amount
	 * @return
	 */
	public void setAmount(double amount) {
		this.amount = amount;
	}

	/**
	 * @return class members data
	 */
	@Override
	public String toString() {
		return "Transaction [crid=" + crid + ", drid=" + drid + ", amount=" + amount + "]";
	}
}