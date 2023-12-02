package com.card;

public class account {
	private String Accountnum;
	private String Name;
	private String balance;
	public account(String accountnum, String name, String balance) {
		Accountnum = accountnum;
		Name = name;
		this.balance = balance;
	}
	public String getAccountnum() {
		return Accountnum;
	}
	public String getName() {
		return Name;
	}
	public String getBalance() {
		return balance;
	}
	
	
		
}
