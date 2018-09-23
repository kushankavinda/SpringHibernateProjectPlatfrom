package controller;

import java.util.ArrayList;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class Retrive {
public static String retrive() {
	
	SessionFactory sessionFactory = HibernateUtility.getSessionFactory();
	ArrayList all_employees=new ArrayList();

		try {
			// create session
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			// Select all the distinct supplier names
			Query querySource = session
					.createQuery("select Employee_name from Attendance_table order by Employee_name desc");
		/*	querySource.setFirstResult(1);
			querySource.setMaxResults(100);*/
			
			all_employees = (ArrayList) querySource.list();
			
			session.close();

		} catch (HibernateException e) {
			System.out.println("Exception hibernate exception : " + e);
		} catch (Exception e) {
			System.out.print("Exception : " + e);
		} finally {	
			System.out.println(all_employees);
		}
		return (String) all_employees.get(0);

}
}
