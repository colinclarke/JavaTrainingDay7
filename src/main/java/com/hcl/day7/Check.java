package com.hcl.day7;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Check {
	private CheckingAccount from;
	private String to;
	private boolean senderHasSigned;
	private boolean receiverHasSigned;
	private double amount;

	public boolean isValid() {
		return (senderHasSigned && receiverHasSigned);
	}
}