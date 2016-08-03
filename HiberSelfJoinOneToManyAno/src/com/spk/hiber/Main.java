package com.spk.hiber;


import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Main {
	
	public static void main(String[] args) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
	    Session session = sf.openSession();
	    session.beginTransaction();

	    Employee manager1 = new Employee("Kalyan", "Chelecampalli");
	    
	    Employee employee1 = new Employee("Praveen", "Kumar");
	    Employee employee2 = new Employee("Vasanth", "Kumar");

	    employee1.setManager(manager1);
	    employee2.setManager(manager1);
	    
	    session.save(employee1);
	    session.save(employee2);
	    
	    session.getTransaction().commit();
	    session.close();
	    System.out.println("Transaction Completed");
	}
	
	
    
    
}
