package com.semurr.dao;

import java.security.NoSuchAlgorithmException;

import com.semurr.model.UserAccount;

public interface LoginDAO {
	
	public boolean validateLogin(UserAccount userAccount) throws NoSuchAlgorithmException;

}
