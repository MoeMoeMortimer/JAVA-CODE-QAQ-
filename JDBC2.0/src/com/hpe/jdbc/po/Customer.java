package com.hpe.jdbc.po;

public class Customer {
	private int cusid;
	private String cusname;
	private String custel;
	private String cusaddr;
	public Customer() {
		super();
	}
	public Customer(int cusid, String cusname, String custel, String cusaddr) {
		super();
		this.cusid = cusid;
		this.cusname = cusname;
		this.custel = custel;
		this.cusaddr = cusaddr;
	}
	public int getCusid() {
		return cusid;
	}
	public void setCusid(int cusid) {
		this.cusid = cusid;
	}
	public String getCusname() {
		return cusname;
	}
	public void setCusname(String cusname) {
		this.cusname = cusname;
	}
	public String getCustel() {
		return custel;
	}
	public void setCustel(String custel) {
		this.custel = custel;
	}
	public String getCusaddr() {
		return cusaddr;
	}
	public void setCusaddr(String cusaddr) {
		this.cusaddr = cusaddr;
	}
	@Override
	public String toString() {
		return "Customer [cusid=" + cusid + ", cusname=" + cusname + ", custel=" + custel + ", cusaddr=" + cusaddr
				+ "]";
	}
	
}
