package com.prachi.training.model;

public class Enroll {
	private int uID, cID;
	public int getuID() {
		return uID;
	}
	public void setuID(int uID) {
		this.uID = uID;
	}
	public int getcID() {
		return cID;
	}
	public void setcID(int cID) {
		this.cID = cID;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getPayment() {
		return payment;
	}
	public void setPayment(String payment) {
		this.payment = payment;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Enroll(int uID, String pwd, int cID, String payment, String email) {
		super();
		this.uID = uID;
		this.cID = cID;
		this.pwd = pwd;
		this.payment = payment;
		this.email = email;
	}
	private String pwd, payment, email;
	

}
