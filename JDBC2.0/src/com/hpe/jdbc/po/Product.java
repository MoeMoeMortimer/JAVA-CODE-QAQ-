package com.hpe.jdbc.po;

import java.math.BigDecimal;

public class Product {
	private Integer proid;
	private String proname;
	private String type;
	private Integer storecount;
	private BigDecimal sugpurchase;
	private BigDecimal sugsell;
	public Product(Integer proid, String proname, String type, Integer storecount, BigDecimal sugpurchase,
			BigDecimal sugsell) {
		super();
		this.proid = proid;
		this.proname = proname;
		this.type = type;
		this.storecount = storecount;
		this.sugpurchase = sugpurchase;
		this.sugsell = sugsell;
	}
	public Product() {
		super();
	}
	public Integer getProid() {
		return proid;
	}
	public void setProid(Integer proid) {
		this.proid = proid;
	}
	public String getProname() {
		return proname;
	}
	public void setProname(String proname) {
		this.proname = proname;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getStorecount() {
		return storecount;
	}
	public void setStorecount(Integer storecount) {
		this.storecount = storecount;
	}
	public BigDecimal getSugpurchase() {
		return sugpurchase;
	}
	public void setSugpurchase(BigDecimal sugpurchase) {
		this.sugpurchase = sugpurchase;
	}
	public BigDecimal getSugsell() {
		return sugsell;
	}
	public void setSugsell(BigDecimal sugsell) {
		this.sugsell = sugsell;
	}
	@Override
	public String toString() {
		return "Product [proid=" + proid + ", proname=" + proname + ", type=" + type + ", storecount=" + storecount
				+ ", sugpurchase=" + sugpurchase + ", sugsell=" + sugsell + "]";
	}
	
}
