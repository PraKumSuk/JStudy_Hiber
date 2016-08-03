package com.spk;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;

public class ManageEmployee {

	//Annotation Configuration
	public static SessionFactory sessionFactory = new AnnotationConfiguration()
													.configure()
													.addPackage("com.spk")
													.addAnnotatedClass(Employee.class)
													.buildSessionFactory();	

	/* Method to CREATE an employee in the database */
	public Integer addEmployee(String firstName, String lastName, int salary){
		
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		Integer employeeID = null;
		
		try{
			
			transaction = session.beginTransaction();
			Employee employee = new Employee(firstName, lastName, salary);
			employeeID = (Integer) session.save(employee); 
			transaction.commit();
			
		}catch (HibernateException hibernateException) {
			
			if (transaction!=null) transaction.rollback();
			hibernateException.printStackTrace(); 
			
		}finally {
			session.close(); 
		}
		return employeeID;
	}

	/* Method to  READ all the employees using Scalar Query */
	public void listEmployeesScalar( ){
		
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		
		try{
			
			transaction = session.beginTransaction();			
			String sql = "SELECT first_name, salary FROM EMPLOYEE";
			SQLQuery query = session.createSQLQuery(sql);
			
			//Result Transformers transforms the result set data to a non-entity bean 
			//like say map etc
			query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
			List data = query.list();

			for(Object object : data){
				
				Map row = (Map)object;
				System.out.print("First Name: " + row.get("first_name")); 
				System.out.println(", Salary: " + row.get("salary")); 
			}
			transaction.commit();
			
		}catch (HibernateException hibernateException) {
			
			if (transaction!=null) transaction.rollback();
			hibernateException.printStackTrace(); 
			
		}finally {
			session.close(); 
		}
	}

	/* Method to  READ all the employees using Entity Query */
	public void listEmployeesEntity( ){
		
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		
		try{
			
			transaction = session.beginTransaction();
			String sql = "SELECT * FROM EMPLOYEE";
			SQLQuery query = session.createSQLQuery(sql);
			
			// addEntity the normal native SQL way
			query.addEntity(Employee.class);
			List employees = query.list();

			for (Iterator iterator = employees.iterator(); iterator.hasNext();){
				
				Employee employee = (Employee) iterator.next(); 
				System.out.print("First Name: " + employee.getFirstName()); 
				System.out.print("  Last Name: " + employee.getLastName()); 
				System.out.println("  Salary: " + employee.getSalary()); 
			}
			transaction.commit();
			
		}catch (HibernateException hibernateException) {
			
			if (transaction!=null) transaction.rollback();
			hibernateException.printStackTrace(); 
			
		}finally {
			session.close(); 
		}
	}

}
