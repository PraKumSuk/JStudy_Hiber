package com.spk;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ManageEmployee {

	public static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		
	/* Method to CREATE an employee in the database */
	public Integer addEmployee(String fname, String lname, int salary){
		
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		Integer employeeID = null;
		
		try{
			
			transaction = session.beginTransaction();
			Employee employee = new Employee(fname, lname, salary);
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
	
	/* Method to  READ all the employees */
	public void listEmployees( ){
		
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		
		try{
			
			transaction = session.beginTransaction();
			List employees = session.createQuery("FROM Employee").list(); 
			
			for (Iterator iterator = employees.iterator(); iterator.hasNext();){
				Employee employee = (Employee) iterator.next(); 
				System.out.print("First Name: " + employee.getFirstName()); 
				System.out.print("  Last Name: " + employee.getLastName()); 
				System.out.println("  Salary: " + employee.getSalary()); 
			}
			transaction.commit();
			
		}catch (HibernateException hiberException) {
			
			if (transaction!=null) transaction.rollback();
			hiberException.printStackTrace();
			
		}finally {
			
			session.close(); 
		}
	}
	
	/* Method to UPDATE salary for an employee */
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
	
	/* Method to DELETE an employee from the records */
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