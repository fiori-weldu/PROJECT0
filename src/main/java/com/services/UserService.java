package com.services;

import java.sql.SQLException;

import com.banking.models.User;
import com.dao.userDao;
import com.exception.UserNameAlreadyExistsException;
 




public class UserService {
private userDao uDao;
	
	public UserService(userDao u) {
		this.uDao = u;
	}
	
	public User signUp(String first, String last, String email, String password) throws UserNameAlreadyExistsException{
		User u = new User(first, last, email, password);
		
		try {
			uDao.createUser(u);
			//Logging.logger.info("New user has registered");
			System.out.println("New user has registered");
		} catch(SQLException e) {
			//Logging.logger.warn("Username created that already exists in the database");
			//throw new UserNameAlreadyExistsException();
			System.out.println("Username created that already exists in the database");
		}
		
		return u;
	}
	
	public User signIn(String username, String password) 
	//throws UserDoesNotExistException, InvalidCredentialsException
	{
		
		User u = uDao.getUserByUsername(username);
		
		if(u.getId() == 0) {
			//Logging.logger.warn("User tried loggging in that does not exist");
			//throw new UserDoesNotExistException();
			System.out.println("User tried loggging in that does not exist");
		}
		else if(!u.getPassword().equals(password)) {
			//Logging.logger.warn("User tried to login with invalid credentials");
			//throw new InvalidCredentialsException();
			System.out.println("User tried to login with invalid credentials");
		}
		else {
			//Logging.logger.info("User was logged in");
			System.out.println("User was logged in");
			return u;
		}
		return u;
	}
}
