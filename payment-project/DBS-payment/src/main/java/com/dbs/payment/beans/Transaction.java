package com.dbs.payment.beans;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="transaction")
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int transactionid;
	Date transferdate;
	String transfertype;
	String messagecode;
	String customerid;
	String receiveraccountholdernumber;
	String receiveraccountholdername;
	float inramount;
	String status;
	String bic;
	int transferfees;
	public Transaction(int transactionid, Date transferdate, String transfertype, String messagecode, String customerid,
			String receiveraccountholdernumber, String receiveraccountholdername, float inramount, String status,
			String bic, int transferfees) {
		super();
		this.transactionid = transactionid;
		this.transferdate = transferdate;
		this.transfertype = transfertype;
		this.messagecode = messagecode;
		this.customerid = customerid;
		this.receiveraccountholdernumber = receiveraccountholdernumber;
		this.receiveraccountholdername = receiveraccountholdername;
		this.inramount = inramount;
		this.status = status;
		this.bic = bic;
		this.transferfees = transferfees;
	}
	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getTransactionid() {
		return transactionid;
	}
	public void setTransactionid(int transactionid) {
		this.transactionid = transactionid;
	}
	public Date getTransferdate() {
		return transferdate;
	}
	public void setTransferdate(Date transferdate) {
		this.transferdate = transferdate;
	}
	public String getTransfertype() {
		return transfertype;
	}
	public void setTransfertype(String transfertype) {
		this.transfertype = transfertype;
	}
	public String getMessagecode() {
		return messagecode;
	}
	public void setMessagecode(String messagecode) {
		this.messagecode = messagecode;
	}
	public String getCustomerid() {
		return customerid;
	}
	public void setCustomerid(String customerid) {
		this.customerid = customerid;
	}
	public String getReceiveraccountholdernumber() {
		return receiveraccountholdernumber;
	}
	public void setReceiveraccountholdernumber(String receiveraccountholdernumber) {
		this.receiveraccountholdernumber = receiveraccountholdernumber;
	}
	public String getReceiveraccountholdername() {
		return receiveraccountholdername;
	}
	public void setReceiveraccountholdername(String receiveraccountholdername) {
		this.receiveraccountholdername = receiveraccountholdername;
	}
	public float getInramount() {
		return inramount;
	}
	public void setInramount(float inramount) {
		this.inramount = inramount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getBic() {
		return bic;
	}
	public void setBic(String bic) {
		this.bic = bic;
	}
	public int getTransferfees() {
		return transferfees;
	}
	public void setTransferfees(int transferfees) {
		this.transferfees = transferfees;
	}
	@Override
	public String toString() {
		return "Transaction [transactionid=" + transactionid + ", transferdate=" + transferdate + ", transfertype="
				+ transfertype + ", messagecode=" + messagecode + ", customerid=" + customerid
				+ ", receiveraccountholdernumber=" + receiveraccountholdernumber + ", receiveraccountholdername="
				+ receiveraccountholdername + ", inramount=" + inramount + ", status=" + status + ", bic=" + bic
				+ ", transferfees=" + transferfees + "]";
	}
		
}
