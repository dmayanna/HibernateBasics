package UpdateObjects;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateUsingHQL {

	public static void main(String[] args) {

		// create session factory
		SessionFactory fac = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class)
				.buildSessionFactory();

		// create session
		Session session = fac.getCurrentSession();

		try {
			
			int employeeId = 1;
			
			System.out.println("Employee Id we are updating is : "+employeeId);
			
			// start a transaction
			session.beginTransaction();
			System.out.println("Getting employee with Id : "+employeeId);
			
			// retrieve student based on the id
			Employee e = session.get(Employee.class, 19315);
	
			System.out.println("Updating Student ... ");
			e.setCity("Gorakhpur");
			e.setFirst_name("Yogi AdityaNath");

			//  update using HQL 
			System.out.println("Update profession for all employees ");
			
			session.createQuery("update Employee set profession='Rowdy' where first_name='Deekshith'").executeUpdate();

			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done");

		} finally {
			fac.close();
		}
	

	}

}
