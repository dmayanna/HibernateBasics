package com.hibernate.readobject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadObject {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory fac = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee2.class).buildSessionFactory();
		
		// create session 
		Session session = fac.getCurrentSession();
		
		try{
			//start transaction
			session.beginTransaction();
		
			// retrieve student based on the id: primary key
			Employee2 emp1 = session.get(Employee2.class,19269);
		
			System.out.println(emp1.getFirst_name());
			
			session.getTransaction().commit();
			
			System.out.println("Done");
			
			
		}
		finally{
			fac.close();
		}
	}

}
