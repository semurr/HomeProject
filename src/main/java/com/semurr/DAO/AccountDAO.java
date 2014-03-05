package com.semurr.DAO;

import com.semurr.account.UserAccount;

public interface AccountDAO {
	
	public UserAccount getAccountByName(String name);
	public boolean addAcccount(UserAccount account);

}
