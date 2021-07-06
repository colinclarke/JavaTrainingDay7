package com.hcl.day7;

public class SavingsAccount extends BankAccount {
	private double annualInterestRate;

	public void depositMonthlyInterest() {
		this.setBalance(this.getBalance() * (1 + (this.annualInterestRate / 12)));
	}
}
