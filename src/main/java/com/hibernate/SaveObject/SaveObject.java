package com.hibernate.SaveObject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SaveObject {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory fac = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class).buildSessionFactory();
		
		// create session 
		Session session = fac.getCurrentSession();
		
		try{
			// create a student object 
			System.out.println("Creating a new employee object");
			Employee emp = new Employee("Deekshith", "Mayanna", "smdeekshith@gmail.com");
			
			// start a transaction 
			session.beginTransaction();
			
			// save the employee object object
			System.out.println("Saving the employee object");
			session.save(emp);
			
			// commit transaction 
			session.getTransaction().commit();
			
			System.out.println("Done");
			
			
		}
		finally{
			fac.close();
		}
	}

}
