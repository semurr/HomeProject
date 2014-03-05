package com.semurr.account.dao;

import com.semurr.account.model.UserAccount;

public interface AccountDAO {
	
	public UserAccount getAccountByName(String name);
	public boolean addAcccount(UserAccount account);

}
