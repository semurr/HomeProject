package com.semurr.dao.impl;

import java.security.NoSuchAlgorithmException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.semurr.dao.AccountDAO;
import com.semurr.model.UserAccount;
import com.smurr.hash.Hash;
import com.smurr.util.HibernateUtil;

@Repository
public class AccountDAOImpl implements AccountDAO{

	public UserAccount getAccountByName(String email) {
		
		//open session
		Session session = HibernateUtil.getSessionFactory().openSession();		
		
		//query for account by email
		UserAccount account = (UserAccount) session.createCriteria(UserAccount.class).add(Restrictions.eq("email", email)).uniqueResult();
		
		session.close();
	
		return account;
	}

	public void addAcccount(UserAccount account) {
		
		Session session = null;
		Transaction transaction = null;
		
		try{		
		session = HibernateUtil.getSessionFactory().openSession();		
		
		//create a transaction for rollback
		transaction = session.beginTransaction();
		transaction.setTimeout(5);
		
		session.save(account);		
		transaction.commit();		
		
		} catch (RuntimeException e){
			e.printStackTrace();						
			System.out.println("fail");
			transaction.rollback();
		} finally{
			if(session!=null){
				session.close();
			}			
		}
	}

	public UserAccount createAccount(UserAccount account, byte[] salt) throws NoSuchAlgorithmException {
		if(salt == null){
			System.out.println("no salt");
			account.setSalt(Hash.generateSalt());
		} else{
			System.out.println("salt");
			account.setSalt(salt);
		}
		
		account.setPassword(new String(Hash.createHash(account.getPassword().getBytes(), account.getSalt())));		
		return account;
	}

}
