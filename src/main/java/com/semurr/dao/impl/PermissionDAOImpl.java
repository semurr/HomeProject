package com.semurr.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.semurr.dao.PermissionDAO;
import com.semurr.hibernate.HibernateUtil;
import com.semurr.model.Blog;
import com.semurr.model.Permission;
import com.semurr.model.UserAccount;

/**
 * @author stephen
 *
 */
public class PermissionDAOImpl implements PermissionDAO {

	// add a new permission, pass in details
	public void addPermission(Permission permissionDetail) {

		Session session = null;
		Transaction transaction = null;

		try {
			session = HibernateUtil.getSessionFactory().openSession();

			// create a transaction for rollback
			transaction = session.beginTransaction();
			transaction.setTimeout(5);

			session.save(permissionDetail);
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

	public List<Permission> getAllPermission() {
		// TODO Auto-generated method stub
		
		Session session = null;

		try {
			session = HibernateUtil.getSessionFactory().openSession();

			Query query = session.createQuery("from Permission");
			List<Permission> listOfPermission = query.list();

			return listOfPermission;

		} catch (Exception e) {
			// exception caught do nothing
		}
		return null;
		
	}
}
