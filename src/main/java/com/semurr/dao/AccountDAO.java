package com.semurr.dao;

import com.semurr.model.UserAccount;

public interface AccountDAO {
	
	public UserAccount getAccountByName(String email);
	public void addAcccount(UserAccount account);

}
