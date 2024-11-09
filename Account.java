package com.org.bank.model;

public class Account {
	private int Account_Id;
	private String Account_holder;
	private String Account_type;
	private double balance;
	private String address;
	private String contact_No;
public Account(int account_Id, String account_holder, String account_type, double balance, String address,
			String contact_No) {
		Account_Id = account_Id;
		Account_holder = account_holder;
		Account_type = account_type;
		this.balance = balance;
		this.address = address;
		this.contact_No = contact_No;
	}
public int getAccount_Id() {
	return Account_Id;
}
public void setAccount_Id(int account_Id) {
	Account_Id = account_Id;
}
public String getAccount_holder() {
	return Account_holder;
}
public void setAccount_holder(String account_holder) {
	Account_holder = account_holder;
}
public String getAccount_type() {
	return Account_type;
}
public void setAccount_type(String account_type) {
	Account_type = account_type;
}
public double getBalance() {
	return balance;
}
public void setBalance(double balance) {
	this.balance = balance;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getContact_No() {
	return contact_No;
}
public void setContact_No(String contact_No) {
	this.contact_No = contact_No;
}
@Override
public String toString() {
	return "Account [Account_Id=" + Account_Id + ", Account_holder=" + Account_holder + ", Account_type=" + Account_type
			+ ", balance=" + balance + ", address=" + address + ", contact_No=" + contact_No + "]";
}

}
