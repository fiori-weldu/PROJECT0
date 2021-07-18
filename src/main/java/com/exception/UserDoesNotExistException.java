package com.exception;

import java.lang.management.RuntimeMXBean;

public class UserDoesNotExistException extends RuntimeException{
private static final long serialVersionUID = 1L;
	
	public UserDoesNotExistException() {
		super("A username was created that already exists in the database");
	}
}
