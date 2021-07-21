package com.services;

import java.sql.SQLException;
import com.banking.models.Account;
import com.dao.AccountDao;
import com.exception.UserDoesNotExistException;
import Logging.Logging;
public class AccountServices {
private AccountDao aDao;
	
	public AccountServices(AccountDao a) {
		this.aDao = a;
	}
	public Account createAccount( int customerID, int balance, String acctType) throws UserDoesNotExistException {
		Account a = new Account(customerID, balance, acctType);
		
		try {
			
			aDao.createAccount(a);
			Logging.logger.info("Your account has been created");
			
		} catch (SQLException e) {
			
			Logging.logger.warn("Account created that already exists in the database");
			throw new UserDoesNotExistException();
		}
		 
		return a;
	
}
}
