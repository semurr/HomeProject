package com.semurr.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.semurr.dao.AccountDAO;
import com.semurr.model.UserAccount;
import com.smurr.util.HibernateUtil;

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
		
		System.out.println("pass");
		
		} catch (RuntimeException e){
			e.printStackTrace();
			transaction.rollback();			
			System.out.println("fail");
		} finally{
			if(session!=null){
				session.close();
			}
			System.out.println("end");
		}
	}

}
