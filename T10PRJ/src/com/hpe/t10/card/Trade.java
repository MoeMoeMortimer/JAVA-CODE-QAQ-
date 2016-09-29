package com.hpe.t10.card;

public class Trade {
	private String tradeid;
	private String cardid;
	private double money;
	private String tradetype;
	private String tradetime;

	public Trade(String tradeid, String cardid, double money, String tradetype, String tradetime) {
		super();
		this.tradeid = tradeid;
		this.cardid = cardid;
		this.money = money;
		this.tradetype = tradetype;
		this.tradetime = tradetime;
	}

	public String getTradeid() {
		return tradeid;
	}

	public void setTradeid(String tradeid) {
		this.tradeid = tradeid;
	}

	public String getCardid() {
		return cardid;
	}

	public void setCardid(String cardid) {
		this.cardid = cardid;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public String getTradetype() {
		return tradetype;
	}

	public void setTradetype(String tradetype) {
		this.tradetype = tradetype;
	}

	public String getTradetime() {
		return tradetime;
	}

	public void setTradetime(String tradetime) {
		this.tradetime = tradetime;
	}

	@Override
	public String toString() {
		return "Trade [tradeid=" + tradeid + ", cardid=" + cardid + ", money=" + money + ", tradetype=" + tradetype
				+ ", tradetime=" + tradetime + "]";
	}

}
