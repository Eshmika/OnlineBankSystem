package com.card;

public class user {
	private String user;
	private int pass;
	private String name;
		
	public user(String user, int pass, String name) {
		this.user = user;
		this.pass = pass;
		this.name = name;
		
	}

	public String getUser() {
		return user;
	}

	public int getPass() {
		return pass;
	}

	public String getName() {
		return name;
	}

	
}
