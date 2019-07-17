package com.revature.model;

public class Check {
	private int account;
	private int balance;
	private boolean approve;
	public int getAccount() {
		return account;
	}
	public void setAccount(int account) {
		this.account = account;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public boolean isApprove() {
		return approve;
	}
	public void setApprove(boolean approve) {
		this.approve = approve;
	}
	public Check(int account, int balance, boolean approve) {
		super();
		this.account = account;
		this.balance = balance;
		this.approve = approve;
	}
	@Override
	public String toString() {
		return "["+"account=" + account + ", balance=" + balance + ", approve=" + approve + "]";
	}
	
}
