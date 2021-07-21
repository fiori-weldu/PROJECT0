package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.banking.models.Account;
import com.banking.models.User;


public interface  AccountDao {
 List<Account> getAllAccounts();
	 
	 Account getAccountByUser(User u);
	
	 void createAccount(Account a) throws SQLException;
	
	 void deleteAccount(Account a);
	 public void makeDeposit(User u, int deposit);

	 public void makeWithdrawl(User u, int deposit);
	 
	 public void transfer();

	
	 
}
