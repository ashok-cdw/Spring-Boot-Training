// Transactional Model
package com.models;

public class Transaction {
	private int crid;
	private int drid;
	private double amount;

	public int getCrid() {
		return crid;
	}

	public void setCrid(int crid) {
		this.crid = crid;
	}

	public int getDrid() {
		return drid;
	}

	public void setDrid(int drid) {
		this.drid = drid;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Transaction [crid=" + crid + ", drid=" + drid + ", amount=" + amount + "]";
	}
}