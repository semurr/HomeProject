package com.semurr.account.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.semurr.account.dao.AccountDAO;
import com.semurr.account.model.UserAccount;
import com.smurr.util.HibernateUtil;

public class AccountDAOImpl implements AccountDAO{

	public UserAccount getAccountByName(String name) {
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();		
		Session session = sessionFactory.openSession();		
		
		UserAccount account = (UserAccount) session.createCriteria(UserAccount.class).add(Restrictions.eq("email", name)).uniqueResult();	
	
		return account;
	}

	public boolean addAcccount(UserAccount account) {
		// TODO Auto-generated method stub
		return false;
	}

}
