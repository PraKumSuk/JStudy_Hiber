package com.spk;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ManageEmployee {

	public static SessionFactory sessionfactory;

	ManageEmployee(){
		sessionfactory = new Configuration().configure().buildSessionFactory();		
	}

	// Method to add an address record in the database
	public Address addAddress(String street, String city, String state, String zipcode) {
		
		Session session = sessionfactory.openSession();
		Transaction transaction = null;
		Integer addressID = null;
		Address address = null;
		
		try{			
			transaction = session.beginTransaction();
			address = new Address(street, city, state, zipcode);
			
			addressID = (Integer) session.save(address); 
			transaction.commit();
			
		}catch (HibernateException hiberException) {
			
			if (transaction!=null) transaction.rollback();
			hiberException.printStackTrace(); 
			
		}finally {			
			session.close(); 
		}
		return address;
	}

	// Method to add an employee record in the database
	public Integer addEmployee(String fname, String lname, int salary, Address address){
		
		Session session = sessionfactory.openSession();
		Transaction transaction = null;
		Integer employeeID = null;
		
		try{
			transaction = session.beginTransaction();
			Employee employee = new Employee(fname, lname, salary, address);
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

	// Method to list all the employees detail
	public void listEmployees( ){
		
		Session session = sessionfactory.openSession();
		Transaction transaction = null;
		
		try{
			transaction = session.beginTransaction();
			List employees = session.createQuery("FROM Employee").list();
			
			for (Iterator iterator = employees.iterator(); iterator.hasNext();){
				
				Employee employee = (Employee) iterator.next(); 
				System.out.print("First Name: " + employee.getFirstName()); 
				System.out.print("  Last Name: " + employee.getLastName()); 
				System.out.println("  Salary: " + employee.getSalary());
				
				Address add = employee.getAddress();
				System.out.println("Address ");
				System.out.println("\tStreet: " +  add.getStreet());
				System.out.println("\tCity: " + add.getCity());
				System.out.println("\tState: " + add.getState());
				System.out.println("\tZipcode: " + add.getZipcode());
			}
			transaction.commit();
			
		}catch (HibernateException hiberException) {
			
			if (transaction!=null) transaction.rollback();
			hiberException.printStackTrace(); 
			
		}finally {
			session.close(); 
		}
	}
	
	// Method to update salary for an employee
	public void updateEmployee(Integer EmployeeID, int salary ){
		
		Session session = sessionfactory.openSession();
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
	
}
