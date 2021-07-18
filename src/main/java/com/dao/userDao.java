package com.dao;

import java.sql.SQLException;
import java.util.List;

//import java.sql.SQLException;
//import java.util.List;

import com.banking.models.User;

//import com.example.models.User;

public interface userDao {
List<User> getAllUsers();
	
	User getUserByUsername(String username);
	
	void createUser(User u) throws SQLException;
	
	void updateUser(User u);
	
	void deleteUser(User u);
}
