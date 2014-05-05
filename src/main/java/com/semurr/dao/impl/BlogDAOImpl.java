package com.semurr.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.semurr.dao.BlogDAO;
import com.semurr.hibernate.HibernateUtil;
import com.semurr.model.Blog;

public class BlogDAOImpl implements BlogDAO {

	public void addBlog(Blog blog) {

		Session session = null;
		Transaction transaction = null;

		try {
			session = HibernateUtil.getSessionFactory().openSession();

			// create a transaction for rollback
			transaction = session.beginTransaction();
			transaction.setTimeout(5);

			session.save(blog);
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

	public Blog getBlogById(int id) {

		Session session = null;
		Query query = null;

		try {
			session = HibernateUtil.getSessionFactory().openSession();

			query = session.createQuery("from Blog where blog_id = :blogid");
			query.setParameter("blogid", id);
			List list = query.list();

			return (Blog) list.get(0);

		} catch (Exception e) {
			System.out.println(e);

		} finally {
			if (session != null) {
				session.close();
			}
		}
		return null;
	}

	public List<Blog> getAllBlogs() {

		Session session = null;

		try {
			session = HibernateUtil.getSessionFactory().openSession();

			Query query = session.createQuery("from Blog");
			List<Blog> listOfBlogs = query.list();

			return listOfBlogs;

		} catch (Exception e) {
			// exception caught do nothing
		}
		return null;
	}

	public Blog getBlogByTitle(String title) {
		Session session = null;
		Query query = null;

		try {
			session = HibernateUtil.getSessionFactory().openSession();

			query = session.createQuery("from Blog where title = :title");
			query.setParameter("title", title);
			List list = query.list();

			return (Blog) list.get(0);

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
