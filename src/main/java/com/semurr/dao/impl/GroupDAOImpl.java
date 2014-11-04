package com.semurr.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.semurr.dao.GroupDAO;
import com.semurr.dao.PermissionDAO;
import com.semurr.hibernate.HibernateUtil;
import com.semurr.model.Blog;
import com.semurr.model.Group;
import com.semurr.model.Permission;

public class GroupDAOImpl implements GroupDAO {
	
	@Autowired
	PermissionDAO permissionDAO = new PermissionDAOImpl();

	public boolean addGroup(Group groupToAdd) {

		Session session = null;
		Transaction transaction = null;

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			transaction.setTimeout(5);

			session.save(groupToAdd);
			transaction.commit();
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
		return true;

	}	

	public List<Group> getAllGroups() {

		Session session = null;

		try {
			session = HibernateUtil.getSessionFactory().openSession();

			Query query = session.createQuery("from Group");
			List<Group> listOfGroups = query.list();

			return listOfGroups;

		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return null;
	}

	public Group getGroupById(int groupId) {

		Session session = null;
		Transaction transaction = null;

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();

			Query query = session
					.createQuery("from Group where group_id = :groupId");
			query.setParameter("groupId", groupId);
			return (Group) query.uniqueResult();

		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return null;
	}

	public boolean addPermissionToGroup(Group group, Permission permission) {
		
		Session session = null;
		Transaction transaction = null;

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			
			group.getPermissions().add(permission);
			
			session.saveOrUpdate(group);
			
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
}
