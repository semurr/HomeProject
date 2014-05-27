package com.semurr.dao;

import java.security.NoSuchAlgorithmException;

import com.semurr.model.Group;
import com.semurr.model.UserAccount;

public interface AccountDAO {
	
	public UserAccount getAccountByName(String email);
	public void addAcccount(UserAccount account);
	public UserAccount createAccount(UserAccount account, byte[] salt) throws NoSuchAlgorithmException;
	public boolean addPermissionGroupToUser(UserAccount user, Group group);
	public UserAccount getAccountById(int userId);

}
