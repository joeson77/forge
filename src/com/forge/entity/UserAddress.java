package com.forge.entity;

public class UserAddress {
	private int aid;
	private String province;
	private String city;
	private String county;
	private String extra;
	private int uid;
	
	
	public UserAddress() {
		super();
	}
	public UserAddress(int aid, String province, String city, String county, String extra, int uid) {
		super();
		this.aid = aid;
		this.province = province;
		this.city = city;
		this.county = county;
		this.extra = extra;
		this.uid = uid;
	}
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCounty() {
		return county;
	}
	public void setCounty(String county) {
		this.county = county;
	}
	public String getExtra() {
		return extra;
	}
	public void setExtra(String extra) {
		this.extra = extra;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	
	

}
