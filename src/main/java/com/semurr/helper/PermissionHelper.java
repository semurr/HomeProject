package com.semurr.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.semurr.dao.AccountDAO;
import com.semurr.dao.impl.AccountDAOImpl;
import com.semurr.enums.Permission;
import com.semurr.model.Group;
import com.semurr.model.UserAccount;

@Component
public class PermissionHelper {
	
	public static boolean validateUserPermission(int accountId, Permission permission){
		
		AccountDAO accountDAO = new AccountDAOImpl();
		
		UserAccount user = accountDAO.getAccountById(accountId);
		
		if(user == null){
			return false;
		}
		
		for(Group g: user.getGroups()){
			for(com.semurr.model.Permission p : g.getPermissions()){
												
				if(p.getPermission_detail().toString().contains(permission.toString())){
					return true;					
				}
				
			}
		}
		return false;
	}	

}
