package com.test;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.banking.models.User;
import com.dao.userDao;
import com.services.UserService;

public class UserServiceTest {

	@InjectMocks
	public UserService uServ;
	
	@Mock
	public userDao uDao;
	
	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testSignUp() {

		User u = new User(1, "NewUser", "Test", "new@mail.com", "testpass");
		User not = new User(0, "user", "test", "test@mail.com", "testpass");
		
		when(uDao.getUserByUsername(toString())).thenReturn(u);
		
		User loggedIn = uServ.signIn("NewUser", "testpass");
		
		assertEquals(u.getId(), loggedIn.getId());
	}



}
