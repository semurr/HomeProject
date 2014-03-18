package com.semurr.dao.impl;

import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.semurr.dao.LoginDAO;
import com.semurr.model.UserAccount;
import com.smurr.hash.Hash;
import com.smurr.util.HibernateUtil;

@Repository
public class LoginDAOImpl implements LoginDAO {

	public boolean validateLogin(UserAccount userAccount) throws NoSuchAlgorithmException {
		
		Session session = null;
		
		try{
			session = HibernateUtil.getSessionFactory().openSession();		
			
			//query for account by email
			UserAccount databaseAccountForValidation = (UserAccount) session.createCriteria(UserAccount.class).add(Restrictions.eq("email", userAccount.getEmail())).uniqueResult();
			
			//if account not found
			if(databaseAccountForValidation == null){
				return false;
			}
			userAccount.setSalt(databaseAccountForValidation.getSalt());
			userAccount.setPassword(new String(Hash.createHash(userAccount.getPassword().getBytes(), userAccount.getSalt())));
			
			//if not equal wrong account info
			if(!Arrays.equals(userAccount.getPassword().getBytes(), databaseAccountForValidation.getPassword().getBytes())){				
				return false;				
			} else {				
				return true;
			}			
		} catch (Exception e){
			
		} finally {
			session.close();
		}		
		return false;
		
		
	}
}
