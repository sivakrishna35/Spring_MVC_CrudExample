package com.test.config;

public class UserIdNotFoundException extends RuntimeException  {
	
	public UserIdNotFoundException(String message)
	{
		super(message);
	}
}
