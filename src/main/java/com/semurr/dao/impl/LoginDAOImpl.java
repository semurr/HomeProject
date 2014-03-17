package com.semurr.dao.impl;

import java.security.NoSuchAlgorithmException;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.semurr.dao.LoginDAO;
import com.semurr.model.UserAccount;
import com.smurr.hash.Hash;
import com.smurr.util.HibernateUtil;

@Repository
public class LoginDAOImpl implements LoginDAO{
	
	public boolean validateLogin(UserAccount userAccount) throws NoSuchAlgorithmException {
		
		Session session = HibernateUtil.getSessionFactory().openSession();		
				
		//query for account by email
		UserAccount databaseAccountForValidation = (UserAccount) session.createCriteria(UserAccount.class).add(Restrictions.eq("email", userAccount.getEmail())).uniqueResult();
		
		//if account not found
		if(databaseAccountForValidation == null){
			return false;
		}
		userAccount.setSalt(databaseAccountForValidation.getSalt());		
		
		System.out.println("pw = " + Hash.createHash(userAccount.getPassword().getBytes(), userAccount.getSalt()).toString());
		System.out.println("pw = " + Hash.createHash(userAccount.getPassword().getBytes(), userAccount.getSalt()).toString());
		
		
		System.out.println("User email = " + userAccount.getEmail());
		System.out.println("User passw = " + userAccount.getPassword());
		System.out.println("User salt2 = " + userAccount.getSalt());
		
		System.out.println("dbus email = " + databaseAccountForValidation.getEmail());
		System.out.println("dbus passw = " + databaseAccountForValidation.getPassword());
		System.out.println("dbus salt2 = " + databaseAccountForValidation.getSalt());
				
		session.close();
		
		return false;
	}

}
