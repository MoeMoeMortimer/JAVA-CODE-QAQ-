package com.hpe.t10.card;

public class Card {
	private String cardid;
	private String password;
	private String name;
	private String uid;
	private String phone;
	private double balance;
	private boolean state;

	public Card(String cardid, String password, String name, String uid, String phone, double balance, boolean state) {
		super();
		this.cardid = cardid;
		this.password = password;
		this.name = name;
		this.uid = uid;
		this.phone = phone;
		this.balance = balance;
		this.state = state;
	}

	public String getCardid() {
		return cardid;
	}

	public void setCardid(String cardid) {
		this.cardid = cardid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "Card [cardid=" + cardid + ", password=" + password + ", name=" + name + ", uid=" + uid + ", phone="
				+ phone + ", balance=" + balance + ", state=" + state + "]";
	}

}
