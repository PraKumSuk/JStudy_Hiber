package com.spk;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

public class ManageEmployee {

	// XML Configuration
	//public static SessionFactory sessionFactory = new Configuration()
	//												.configure()
	//												.buildSessionFactory();
	
	//Annotation Configuration
	public static SessionFactory sessionFactory = new AnnotationConfiguration()
												  .configure()
												  .addPackage("com.spk")
												  .addAnnotatedClass(Employee.class)
												  .buildSessionFactory();	

	// Method to CREATE an employee in the database 
	public Integer addEmployee(String fname, String lname, int salary){

		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		Integer employeeID = null;

		try{
			transaction = session.beginTransaction();
			Employee employee = new Employee();
			employee.setFirstName(fname);
			employee.setLastName(lname);
			employee.setSalary(salary);

			employeeID = (Integer) session.save(employee); 
			transaction.commit();

		}catch (HibernateException hiberException) {

			if (transaction!=null) transaction.rollback();
			hiberException.printStackTrace(); 

		}finally {
			session.close(); 
		}
		return employeeID;
	}

	// Method to  READ all the employees 
	public void listEmployees( ){

		Session session = sessionFactory.openSession();
		Transaction transaction = null;

		try{

			transaction = session.beginTransaction();
			// General Way
			List employees = session.createQuery("FROM Employee").list(); 
			
			// Using FROM clause and Query
			/*String hql = "FROM Employee";
			Query query = session.createQuery(hql);
			List employees = query.list();*/
			
			// Using From clause and Class name
			/*String hql = "FROM com.spk.Employee";
			Query query = session.createQuery(hql);
			List employees = query.list();*/
			
			// Using AS clause
			/*String hql = "FROM Employee AS E";
			Query query = session.createQuery(hql);
			List employees = query.list();*/
			
			// Using AS clause
			/*String hql = "FROM Employee E";
			Query query = session.createQuery(hql);
			List employees = query.list();*/
			
			// Using SELECT FROM clause
			/*String hql = "SELECT E.firstName FROM Employee E";
			Query query = session.createQuery(hql);
			List employees = query.list();			
			System.out.println(employees.get(0));*/
			
			// Using WHERE clause
			/*String hql = "FROM Employee E WHERE E.id = 3";
			Query query = session.createQuery(hql);
			List employees = query.list();*/
			
			// Using ORDERBy
			/*String hql = "FROM Employee E WHERE E.id > 1 ORDER BY E.salary DESC";
			Query query = session.createQuery(hql);
			List employees = query.list();*/
			
			// Using ORDERBy
			/*String hql = "FROM Employee E WHERE E.id > 1 ORDER BY E.firstName DESC, E.salary DESC";
			Query query = session.createQuery(hql);
			List employees = query.list();*/
			
			// Using GroupBy
			/*String hql = "SELECT SUM(E.salary), E.firstName FROM Employee E GROUP BY E.firstName";
			Query query = session.createQuery(hql);
			List employees = query.list();*/
			
			// Using Named Parameters i.e. user input
			/*String hql = "FROM Employee E WHERE E.id = :employee_id";
			Query query = session.createQuery(hql);
			query.setParameter("employee_id",3);
			List employees = query.list();*/
			
			// Using executeUpdate for Update
			/*String hql = "UPDATE Employee set salary = :salary WHERE id = :employee_id";
			Query query = session.createQuery(hql);
			query.setParameter("salary", 1212121);
			query.setParameter("employee_id", 3);
			int result = query.executeUpdate();
			System.out.println("Rows affected: " + result);*/
			
			// Using executeUpdate for delete
			/*String hql = "DELETE FROM Employee WHERE id = :employee_id";
			Query query = session.createQuery(hql);
			query.setParameter("employee_id", 1);
			int result = query.executeUpdate();
			System.out.println("Rows affected: " + result);*/
			
			// Using executeUpdate for insert/copying data from one object to other
			/*String hql = "INSERT INTO Employee(firstName, lastName, salary) SELECT firstName, lastName, salary FROM old_employee";
			Query query = session.createQuery(hql);
			int result = query.executeUpdate();
			System.out.println("Rows affected: " + result);*/
			
			for (Iterator iterator = employees.iterator(); iterator.hasNext();){
				Employee employee = (Employee) iterator.next(); 
				System.out.println("First Name: " + employee.getFirstName()+
							"  Last Name: " + employee.getLastName()+
							"  Salary: " + employee.getSalary()); 
			}

			transaction.commit();

		}catch (HibernateException hiberException) {

			if (transaction!=null) transaction.rollback();
			hiberException.printStackTrace(); 

		}finally {
			session.close(); 
		}
	}


	// Method to UPDATE salary for an employee 
	public void updateEmployee(Integer EmployeeID, int salary ){

		Session session = sessionFactory.openSession();
		Transaction transaction = null;

		try{
			transaction = session.beginTransaction();
			Employee employee = (Employee)session.get(Employee.class, EmployeeID); 
			employee.setSalary( salary );

			session.update(employee); 
			transaction.commit();

		}catch (HibernateException hiberException) {

			if (transaction!=null) transaction.rollback();
			hiberException.printStackTrace(); 

		}finally {
			session.close(); 
		}
	}

	// Method to DELETE an employee from the records 
	public void deleteEmployee(Integer EmployeeID){

		Session session = sessionFactory.openSession();
		Transaction transaction = null;

		try{
			transaction = session.beginTransaction();
			Employee employee = (Employee)session.get(Employee.class, EmployeeID); 

			session.delete(employee); 
			transaction.commit();

		}catch (HibernateException hiberException) {

			if (transaction!=null) transaction.rollback();
			hiberException.printStackTrace(); 

		}finally {
			session.close(); 
		}
	}

}
