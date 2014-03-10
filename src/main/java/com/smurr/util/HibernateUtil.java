package com.smurr.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * 
 * 
 * @author stephen
 *
 */
//TODO: Actual util convert to spring bean later  
public class HibernateUtil {

	private static SessionFactory sessionFactory;
	 
	private static SessionFactory buildSessionFactory() {
	    Configuration configuration = new Configuration().configure(); 

	    StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder();

	    serviceRegistryBuilder.applySettings(configuration.getProperties());

	    ServiceRegistry serviceRegistry = serviceRegistryBuilder.build();

	    return configuration.buildSessionFactory(serviceRegistry);
	}

	public static SessionFactory getSessionFactory() {
		if(sessionFactory == null){			
			sessionFactory = buildSessionFactory();
		}
	    return sessionFactory;
	}

	public static void shutdown() {	    
	    getSessionFactory().close();
	}
}
