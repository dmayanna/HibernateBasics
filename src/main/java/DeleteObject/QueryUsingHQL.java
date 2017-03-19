package DeleteObject;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class QueryUsingHQL {

	public static void main(String[] args) {

		// create session factory
		SessionFactory fac = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class)
				.buildSessionFactory();

		// create session
		Session session = fac.getCurrentSession();

		try {
			// start a transaction
			session.beginTransaction();
			// get the employee
			Employee emp = session.get(Employee.class,19320 );
			
			// Deleting the meployee
			session.delete(emp);
			
			
			///// Alternate Approach
			
			session.createQuery("delete from Employee where employee_id='19318'").executeUpdate();
			
			// commit transaction
			session.getTransaction().commit();

			System.out.println("Done");

		} finally {
			fac.close();
		}
	}

	private static void displayStudents(List<Employee> theEmployees) {
		for (Employee e : theEmployees) {
			System.out.println(e+"\n");
		}
	}

}
