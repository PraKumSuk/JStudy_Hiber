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
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;

public class ManageEmployee {

	public static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();	

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

}
