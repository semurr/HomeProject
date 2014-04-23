package com.semurr.dao.impl;

import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.semurr.dao.AccountDAO;
import com.semurr.dao.LoginDAO;
import com.semurr.model.UserAccount;
import com.semurr.hash.Hash;
import com.semurr.util.HibernateUtil;

@Repository
public class LoginDAOImpl implements LoginDAO {

	public boolean validateLogin(UserAccount userAccount) throws NoSuchAlgorithmException {
		
		AccountDAO accountDAO = new AccountDAOImpl();
		Logger log = Logger.getLogger("InfoLoggin");
		
		Session session = null;
		
		try{
			log.info("login session");
			session = HibernateUtil.getSessionFactory().openSession();			
			
			//query for account by email
			log.info("grab existing user from db");
			UserAccount databaseAccountForValidation = (UserAccount) session.createCriteria(UserAccount.class).add(Restrictions.eq("email", userAccount.getEmail())).uniqueResult();
			
			//if account not found
			if(databaseAccountForValidation == null){
				return false;
			}
			userAccount = accountDAO.createAccount(userAccount, databaseAccountForValidation.getSalt());
			
			//if not equal wrong account info
			log.info("login check if same user");
			if(!Arrays.equals(userAccount.getPassword().getBytes(), databaseAccountForValidation.getPassword().getBytes())){
				log.info("login validate user false");
				return false;				
			} else {
				log.info("login validate user true");
				return true;
			}			
		} catch (Exception e){
			log.info("login exception thrown" + e.getMessage());
			
		} finally {
			session.close();
		}
		log.info("login return default false");
		return false;
		
		
	}
}
