package com.dbs.payment.beans;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="message")
public class Message {

	@Id
	String messagecode;
	String instruction;
	public Message() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Message(String messagecode, String instruction) {
		super();
		this.messagecode = messagecode;
		this.instruction = instruction;
	}
	public String getMessagecode() {
		return messagecode;
	}
	public void setMessagecode(String messagecode) {
		this.messagecode = messagecode;
	}
	public String getInstruction() {
		return instruction;
	}
	public void setInstruction(String instruction) {
		this.instruction = instruction;
	}
	@Override
	public String toString() {
		return "Message [messagecode=" + messagecode + ", instruction=" + instruction + "]";
	}
	
	
}
