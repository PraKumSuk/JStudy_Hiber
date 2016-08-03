package com.spk;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ManageEmployee {

	public static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory(); 
	
	/* Method to create employee records in batches */
	public void addEmployees( ){
		
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		Integer employeeID = null;
		
		try{
			
			transaction = session.beginTransaction();
			for ( int i=0; i<100000; i++ ) {
				String fname = "First Name " + i;
				String lname = "Last Name " + i;
				Integer salary = i;
				Employee employee = new Employee(fname, lname, salary);
				session.save(employee);
				
				System.out.println("Saving Employee : "+i);
				
				if( i % 50 == 0 ) {
					
					System.out.println("Flushing and Clearing Session data at index : "+i);
					session.flush();
					session.clear();
				}
			}
			transaction.commit();
			
		}catch (HibernateException hiberException) {
			
			if (transaction!=null) transaction.rollback();
			hiberException.printStackTrace(); 
			
		}finally {
			session.close(); 
		}
		return ;
	}

}
