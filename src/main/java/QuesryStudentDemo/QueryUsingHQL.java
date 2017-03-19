package QuesryStudentDemo;

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

			// query the employees
			List<Employee> theEmployees = session.createQuery("from Employee").list();

			// Display the employees
			System.out.println("Displaying all Employees Name");
			displayStudents(theEmployees);

			// query employees whose first name is Mohit and City: Delhi

			theEmployees = session.createQuery("from Employee e where e.first_name='Mohit' and e.city='Delhi'").list();
			System.out.println("Displaying name of Employee whoose first name : Mohit and  city :Delhi");
			displayStudents(theEmployees);
			
			// query employees whoose city starts with b
			System.out.println("Employees whose city name starts with B");
			theEmployees = session.createQuery("from Employee e where e.city like 'B%'").list();
			displayStudents(theEmployees);

			// query employees whoose first name is Kuri in the database
			theEmployees = session.createQuery("from Employee e where e.first_name='Kuri'").list();
			System.out.println("Employees who have last name of : Kuri");
			displayStudents(theEmployees);
			
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
