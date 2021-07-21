package com.banking.models;

import java.util.List;
import java.util.Random;

//import com.bank.models.Transactions;



public class Account {
	private int accountNum;
	private int customerID;
	private int currentBal;
	private String accountType;	
	private List<Transactions> transactions;
	
	
	
public Account() {
		
	}
	
	public Account(int customerID, int currentBal, String accountType) {
		this.setAccountNum(new Random().nextInt(100000) + 100000);
		this.customerID = customerID;
		this.currentBal = currentBal;
		this.accountType = accountType;
	}
	
	public Account(int accountNum, int customerID, int currentBal, String accountType) {
		this.accountNum = accountNum;
		this.customerID = customerID;
		this.currentBal = currentBal;
		this.accountType = accountType;
	}


	public int getAccountNum() {
		return accountNum;
	}
	
	public void setAccountNum(int accountNum) {
		this.accountNum = accountNum;
	}
	
	public int getCustomerID() {
		return customerID;
	}
	
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	
	
	public int getCurrentBal() {
		return currentBal;
	}

	public void setCurrentBal(int currentBal) {
		this.currentBal = currentBal;
	}

	public String getAccountType() {
		return accountType;
	}
	
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public Account(int accountNum, int customerID, int currentBal, String accountType,
			List<Transactions> transactions) {
		super();
		this.accountNum = accountNum;
		this.customerID = customerID;
		this.currentBal = currentBal;
		this.accountType = accountType;
		this.transactions = transactions;
	}
	
	@Override
	public String toString() {
		return "Account [accountNum=" + accountNum + ", customerID=" + customerID + ", currentBal=" + currentBal
				+ ", accountType=" + accountType + ", transactions=" + transactions + "]";
	}

	public void setAccountNum(List<Account> accountList) {
		// TODO Auto-generated method stub
		
	}
		
	
}
