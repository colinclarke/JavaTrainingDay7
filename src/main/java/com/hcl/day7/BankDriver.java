package com.hcl.day7;

public class BankDriver {
	public static void main(String[] args) {
		System.out.println(">>>> Initialize two checking accounts");
		CheckingAccount acct1 = new CheckingAccount("Colin", 0, 35, 0);
		System.out.println(acct1);
		CheckingAccount acct2 = new CheckingAccount("Bill", 300, 27, 0);
		System.out.println(acct2);

		System.out.println(">>>> Colin tries to withdraw more money than he has");
		acct1.withdraw(20);
		System.out.println(acct1);

		System.out.println(">>>> Bill tries to withdraw more money than he has");
		acct2.withdraw(1000);
		System.out.println(acct2);

		System.out.println(">>>> Bill writes Colin a check for more than he has");
		Check check = new Check(acct2, "Colin", true, true, 2000);
		acct1.processCheck(check);
		System.out.println(acct1);
		System.out.println(acct2);

		System.out.println(">>>> Bill writes Colin a check for less than he has");
		Check check2 = new Check(acct2, "Colin", true, true, 200);
		acct1.processCheck(check2);
		System.out.println(acct1);
		System.out.println(acct2);
	}
}
