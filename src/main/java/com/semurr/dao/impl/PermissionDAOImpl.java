package com.semurr.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.semurr.dao.PermissionDAO;
import com.semurr.hibernate.HibernateUtil;
import com.semurr.model.Blog;
import com.semurr.model.Permission;
import com.semurr.model.UserAccount;

/**
 * @author stephen
 *
 */
@Repository
public class PermissionDAOImpl implements PermissionDAO {

	// add a new permission, pass in details
	public boolean addPermission(Permission permissionDetail) {

		Session session = null;
		Transaction transaction = null;

		try {
			session = HibernateUtil.getSessionFactory().openSession();

			// create a transaction for rollback
			transaction = session.beginTransaction();
			transaction.setTimeout(5);

			session.save(permissionDetail);
			transaction.commit();
			return true;

		} catch (HibernateException e) {
			if (transaction != null) {
				transaction.rollback();
			}
			return false;

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
			System.out.println(e);
			// exception caught do nothing
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return null;
		
	}

	public Permission getPermissionById(int permissionId) {
		Session session = null;
		Query query = null;

		try {
			session = HibernateUtil.getSessionFactory().openSession();

			query = session.createQuery("from Permission where permission_id = :permissionid");
			query.setParameter("permissionid", permissionId);
			List list = query.list();

			return (Permission) list.get(0);

		} catch (Exception e) {
			System.out.println(e);

		} finally {
			if (session != null) {
				session.close();
			}
		}
		return null;
	}
}
