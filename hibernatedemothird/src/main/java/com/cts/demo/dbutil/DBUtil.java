package com.cts.demo.dbutil;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class DBUtil {

	private static SessionFactory sessionFactory=null;
	
	public static SessionFactory getSessionFactory()
	{
		Configuration configuration = new Configuration(); 
		configuration.configure();
		ServiceRegistry  serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();        
		SessionFactory  sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	    return sessionFactory;
	}
}
