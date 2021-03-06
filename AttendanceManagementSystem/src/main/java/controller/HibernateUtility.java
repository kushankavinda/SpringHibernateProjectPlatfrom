package controller;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtility {
	public static SessionFactory factory;

	// to disallow creating objects by other classes.
	private HibernateUtility() {
	
	}

	// maling the Hibernate SessionFactory object as singleton becuse of session factory is the heaviest object in hibernate
	public static synchronized SessionFactory getSessionFactory() {
		if (factory == null) {
			factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		}
		return factory;
	}
}
