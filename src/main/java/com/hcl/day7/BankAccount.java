package com.hcl.day7;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public abstract class BankAccount {
	private String owner;
	private double balance;

	public void deposit(double amount) {
		this.balance += amount;
	}

	public boolean withdraw(double amount) {
		if (this.balance >= amount) {
			this.balance -= amount;
			return true;
		}
		return false;
	}
}
