package com.card;

public class Card {
	private String cardnumber;
	private String accnumber;
	private String name;
	private int pin;
	private String expiredate;
		
	public Card(String cardnumber, String accnumber, String name, int pin, String expiredate) {
		this.cardnumber = cardnumber;
		this.accnumber = accnumber;
		this.name = name;
		this.pin = pin;
		this.expiredate = expiredate;
	}

	public String getCardnumber() {
		return cardnumber;
	}

	public String getAccnumber() {
		return accnumber;
	}

	public String getName() {
		return name;
	}

	public int getPin() {
		return pin;
	}

	public String getExpiredate() {
		return expiredate;
	}
	
}
