package com.spk.hiber;


import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Main {
	
	public static void main(String[] args) {
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();

		
		Person person = new Person("Steve", "Balmer");
		session.save(person);

		Employee employee = new Employee("James", "Gosling", "Marketing", new Date());
		session.save(employee);
		
		session.getTransaction().commit();
		session.close();
	}   
    
}
