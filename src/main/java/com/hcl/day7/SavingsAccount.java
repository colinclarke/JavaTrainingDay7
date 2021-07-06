package com.hcl.day7;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class SavingsAccount extends BankAccount {
	private double annualInterestRate;

	SavingsAccount(String owner, double balance, double annualInterestRate) {
		super(owner, balance);
		this.annualInterestRate = annualInterestRate;
	}

	public void depositMonthlyInterest() {
		this.setBalance(this.getBalance() * (1 + (this.annualInterestRate / 12)));
	}

	@Override
	public String toString() {
		return String.format("Owner: %s \nBalance: %.2f \nAnnual Interest Rate: %.2f\n", this.getOwner(),
				this.getBalance(), this.annualInterestRate);
	}
}
