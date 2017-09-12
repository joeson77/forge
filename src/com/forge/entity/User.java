package com.forge.entity;

public class User {
	private int uid;
	private String uname;
	private String upassword;
	private String ubirthday;
	private String ugender;
	private String utel;
	private String uemail;
	
	
	
	public User() {
		super();
	}
	public User(int uid, String uname, String upassword, String ubirthday, String ugender, String utel, String uemail) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.upassword = upassword;
		this.ubirthday = ubirthday;
		this.ugender = ugender;
		this.utel = utel;
		this.uemail = uemail;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpassword() {
		return upassword;
	}
	public void setUpassword(String upassword) {
		this.upassword = upassword;
	}
	public String getUbirthday() {
		return ubirthday;
	}
	public void setUbirthday(String ubirthday) {
		this.ubirthday = ubirthday;
	}
	public String getUgender() {
		return ugender;
	}
	public void setUgender(String ugender) {
		this.ugender = ugender;
	}
	public String getUtel() {
		return utel;
	}
	public void setUtel(String utel) {
		this.utel = utel;
	}
	public String getUemail() {
		return uemail;
	}
	public void setUemail(String uemail) {
		this.uemail = uemail;
	}
	
	
	
	
}
