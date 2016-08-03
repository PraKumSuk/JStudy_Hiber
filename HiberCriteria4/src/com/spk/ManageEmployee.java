package com.spk;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
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

	/*// Method to CREATE an employee in the database 
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
	}*/

	// Method to  READ all the employees 
	public void listEmployees( ){

		Session session = sessionFactory.openSession();
		Transaction transaction = null;

		try{

			transaction = session.beginTransaction();
			
			//Using criteria instead of query
			Criteria criteria = session.createCriteria(Employee.class);
			
			// Simple criteria with no restrictions specified
			// Works similar to FROM Clause
			/*
			List employees = criteria.list();
			*/
			
			// To get records having salary more than 1500
			//criteria.add(Restrictions.gt("salary", 1500));
			
			// To get records having salary less than 2000
			//criteria.add(Restrictions.lt("salary", 2000));

			// To get records having fistName starting with Dhi
			//criteria.add(Restrictions.like("firstName", "Dhi%"));

			// Case sensitive form of the above restriction.
			//criteria.add(Restrictions.ilike("firstName", "KAL%"));

			// To get records having salary in between 100 and 1000
			//criteria.add(Restrictions.between("salary", 100, 1000));

			// To check if the given property is null
			//criteria.add(Restrictions.isNull("firstName"));

			// To check if the given property is not null
			//criteria.add(Restrictions.isNotNull("lastName"));

			// To check if the given property is empty
			//riteria.add(Restrictions.isEmpty("lastName"));

			// To check if the given property is not empty
			//criteria.add(Restrictions.isNotEmpty("salary"));*/
			
			

			// To get records matching with OR conditions
			//Criterion salaryCriterion = Restrictions.gt("salary", 400);
			//Criterion nameCriterion = Restrictions.ilike("firstName","Kal%");
			//LogicalExpression orExp = Restrictions.or(salaryCriterion, nameCriterion);
			//criteria.add( orExp );

			// To get records matching with AND conditions
			Criterion salaryCriterion = Restrictions.gt("salary", 400);
			Criterion nameCriterion = Restrictions.ilike("firstName","Kal%");
			LogicalExpression andExp = Restrictions.and(salaryCriterion, nameCriterion);
			criteria.add( andExp );

			List results = criteria.list();
			
			List employees = criteria.list();
			
			for (Iterator iterator = employees.iterator(); iterator.hasNext();){
				Employee employee = (Employee) iterator.next(); 
				System.out.println("First Name: " + employee.getFirstName()+
							"|  Last Name: " + employee.getLastName()+
							"|  Salary: " + employee.getSalary()); 
			}

			transaction.commit();

		}catch (HibernateException hiberException) {

			if (transaction!=null) transaction.rollback();
			hiberException.printStackTrace(); 

		}finally {
			session.close(); 
		}
	}

}
