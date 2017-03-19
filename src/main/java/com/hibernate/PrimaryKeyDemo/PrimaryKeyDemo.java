package com.hibernate.PrimaryKeyDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory fac = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class).buildSessionFactory();
		
		// create session 
		Session session = fac.getCurrentSession();
		
		try{
			// create a student object 
			System.out.println("Creating a new employee object");
			Employee emp = new Employee("Mohit", "Delhi", "Raper ");
			Employee emp1 = new Employee("Rakeswa", "Patna", "Kidnapper");
			Employee emp2 = new Employee("meke", "Lucknow", "Gol Gappa");

			// start a transaction 
			session.beginTransaction();
			
			// save the employee object object
			System.out.println("Saving the employee object");
			session.save(emp);
			session.save(emp1);
			session.save(emp2);

			
			// commit transaction 
			session.getTransaction().commit();
			
			System.out.println("Done");
			
			
		}
		finally{
			fac.close();
		}
	}

}
