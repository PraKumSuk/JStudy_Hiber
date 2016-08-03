package com.spk.hiber;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateUtil {

	//Creating a session factory object
	private static SessionFactory buildSessionFactory() {
		try {
			// Create the SessionFactory from hibernate.cfg.xml
			return new AnnotationConfiguration().configure().buildSessionFactory();

		} catch (Throwable ex) {
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}
	
	//Member to hold a session factory object
	private static final SessionFactory sessionFactory = buildSessionFactory();	

	//Getter for session factory
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}
