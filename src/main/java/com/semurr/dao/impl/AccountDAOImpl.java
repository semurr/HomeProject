package com.semurr.dao.impl;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.jboss.logging.Logger;
import org.springframework.stereotype.Repository;

import com.semurr.dao.AccountDAO;
import com.semurr.hash.Hash;
import com.semurr.hibernate.HibernateUtil;
import com.semurr.model.Blog;
import com.semurr.model.Group;
import com.semurr.model.UserAccount;

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
		
		Logger log = Logger.getLogger("InfoLoggin");
		
		log.info("add account" + account.getEmail());
		
		Session session = null;
		Transaction transaction = null;
		
		try{
		session = HibernateUtil.getSessionFactory().openSession();		
		
		//create a transaction for rollback
		log.info("start transcation");
		transaction = session.beginTransaction();
		transaction.setTimeout(5);
		
		session.save(account);		
		transaction.commit();		
		
		} catch (HibernateException e){
			log.info("Exception caught when adding an account");
			String error = e.getCause().getMessage();
			log.info(error);
			
			if(transaction != null){
				transaction.rollback();				
			}			
			 
			if(error.contains("Duplicate")){				
				throw new HibernateException("Username already taken");				
			}			
		} finally{
			log.info("close session");
			if(session!=null){
				session.close();
			}			
		}
	}

	/*
	 * basic helper method to create the account
	 * 
	 * (non-Javadoc)
	 * @see com.semurr.dao.AccountDAO#createAccount(com.semurr.model.UserAccount, byte[])
	 */
	public UserAccount createAccount(UserAccount account, byte[] salt) throws NoSuchAlgorithmException {
		if(salt == null){			
			account.setSalt(Hash.generateSalt());
		} else{
			account.setSalt(salt);
		}
		
		account.setPassword(new String(Hash.createHash(account.getPassword().getBytes(), account.getSalt())));		
		return account;
	}

	public boolean addPermissionGroupToUser(UserAccount user, Group group) {
		Session session = null;
		Transaction transaction = null;

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			
			user.getGroups().add(group);
			
			session.saveOrUpdate(user);
			
			transaction.commit();
			
			return true;		

		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return false;
	}

	public UserAccount getAccountById(int userId) {
		Session session = null;
		Query query = null;

		try {
			session = HibernateUtil.getSessionFactory().openSession();

			query = session.createQuery("from UserAccount where user_id = :userId");
			query.setParameter("userId", userId);
			
			
			return (UserAccount) query.uniqueResult();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			if (session != null) {
				session.close();
			}
		}
		return null;
	}

}
