package com.semurr.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.semurr.dao.PermissionDAO;
import com.semurr.hibernate.HibernateUtil;
import com.semurr.model.UserAccount;

public class PermissionDAOImpl implements PermissionDAO{

	public void addUser(UserAccount user, int permision) {
		// TODO Auto-generated method stub
		
		Session session = null;
		Transaction transaction = null;

		try {
			session = HibernateUtil.getSessionFactory().openSession();

			// create a transaction for rollback
			transaction = session.beginTransaction();
			transaction.setTimeout(5);

			//session.save();
			transaction.commit();

		} catch (HibernateException e) {
			if (transaction != null) {
				transaction.rollback();
			}

		} finally {
			if (session != null) {
				session.close();
			}
		}
		
	}

	public void addUser() {
		// TODO Auto-generated method stub
		
	}

}
