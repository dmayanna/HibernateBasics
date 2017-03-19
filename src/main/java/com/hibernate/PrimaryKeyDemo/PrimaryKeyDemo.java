package com.hibernate.PrimaryKeyDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory fac = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee1.class).buildSessionFactory();
		
		// create session 
		Session session = fac.getCurrentSession();
		
		try{
			// create a student object 
			System.out.println("Creating a new employee object");
			Employee1 emp = new Employee1("Deekshith", "Dinga", "Dinga@gmail.com");
			Employee1 emp1 = new Employee1("Kuri", "Pratap", "Kuri@gmail.com");
			Employee1 emp2 = new Employee1("meke", "Prasad", "meke@gmail.com");

			// start a transaction 
			session.beginTransaction();
			
			// save the employee object object
			System.out.println("Saving the employee object");
			session.save(emp);
//			session.save(emp1);
//			session.save(emp2);

			
			// commit transaction 
			session.getTransaction().commit();
			
			System.out.println("Done");
			
			
		}
		finally{
			fac.close();
		}
	}

}
