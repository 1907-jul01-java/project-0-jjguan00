package com.revature.model;

public class Transaction {
	private String content;
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "[" + content + "]";
	}
	public Transaction(String content) {
		super();
		this.content = content;
	}
	
	
}
