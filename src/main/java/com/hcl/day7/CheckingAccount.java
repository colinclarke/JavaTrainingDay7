package com.hcl.day7;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class CheckingAccount extends BankAccount {
	private double insufficientFundsFee;
	private double debt;

	CheckingAccount(String owner, double balance, double insufficientFundsFee, double debt) {
		super(owner, balance);
		this.insufficientFundsFee = insufficientFundsFee;
		this.debt = debt;
	}

	public void processCheck(Check checkToProcess) {
		// Check signatures and that the to field matches this account
		if (checkToProcess.isValid() && this.getOwner().equals(checkToProcess.getTo())) {
			// Check that the withdrawl went through
			if (checkToProcess.getFrom().withdraw(checkToProcess.getAmount())) {
				this.deposit(checkToProcess.getAmount());
			}

		}
	}

	@Override
	public boolean withdraw(double amount) {
		if (super.withdraw(amount)) {
			return true;
		} else if (super.withdraw(this.insufficientFundsFee)) {
			return false;
		} else {
			this.debt += this.insufficientFundsFee;
			return false;
		}
	}

	@Override
	public String toString() {
		return String.format("Owner: %s \nBalance: %.2f \nDebt: %.2f\n", super.getOwner(), super.getBalance(),
				this.debt);
	}
}
