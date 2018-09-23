package controller;


import java.util.Iterator;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import antlr.collections.List;
import model.Attendance_table;

public class Create_table {

	public static void create_table() {
		// create session factory
		SessionFactory sessionFactory = HibernateUtility.getSessionFactory();
		// create session
		Session session = sessionFactory.openSession();
		// transaction
		Transaction tx = null;
		tx = session.beginTransaction();
		
		Attendance_table at =new Attendance_table();
		at.setEmployee_name("dimuthu");
		
		//persisite data to datbase
		session.save(at);
		tx.commit();
		//as soon as used we close the session because of session is not Thread Safe as session factory
		session.close();

	}

}
