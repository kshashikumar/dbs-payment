package com.dbs.payment.beans;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="customer")
public class Customer {

	@Id
	String customerid;
	String accountholdername;
	int overdraftflag;
	float clearbalance;
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customer(String customerid, String accountholdername, int overdraftflag, float clearbalance) {
		super();
		this.customerid = customerid;
		this.accountholdername = accountholdername;
		this.overdraftflag = overdraftflag;
		this.clearbalance = clearbalance;
	}
	public String getCustomerid() {
		return customerid;
	}
	public void setCustomerid(String customerid) {
		this.customerid = customerid;
	}
	public String getAccountholdername() {
		return accountholdername;
	}
	public void setAccountholdername(String accountholdername) {
		this.accountholdername = accountholdername;
	}
	public int getOverdraftflag() {
		return overdraftflag;
	}
	public void setOverdraftflag(int overdraftflag) {
		this.overdraftflag = overdraftflag;
	}
	public float getClearbalance() {
		return clearbalance;
	}
	public void setClearbalance(float clearbalance) {
		this.clearbalance = clearbalance;
	}
	@Override
	public String toString() {
		return "Customer [customerid=" + customerid + ", accountholdername=" + accountholdername + ", overdraftflag="
				+ overdraftflag + ", clearbalance=" + clearbalance + "]";
	}
	
}
