package com.spk.hiber;

import java.sql.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.spk.hiber.Employee;


public class Main {
	
	//Method to list employees
	private static List list() {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		List employees = session.createQuery("from Employee").list();
		session.close();
		return employees;
	}
	
	//Method to read specific employee
	private static Employee read(Long id) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();

		Employee employee = (Employee) session.get(Employee.class, id);
		session.close();
		return employee;
	}
	
	//Method to save an employee
	private static Employee save(Employee employee) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();

		session.beginTransaction();

		Long id = (Long) session.save(employee);
		employee.setId(id);

		session.getTransaction().commit();

		session.close();

		return employee;
	}

	//Method to update/edit an employee
	private static Employee update(Employee employee) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();

		session.beginTransaction();

		session.merge(employee);

		session.getTransaction().commit();

		session.close();
		return employee;

	}

	//Method to delete an employee
	private static void delete(Employee employee) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();

		session.beginTransaction();

		session.delete(employee);

		session.getTransaction().commit();

		session.close();
	}

	public static void main(String[] args) {

		// Read		
		List employees = list();
		System.out.println("******* READ *******");
		System.out.println("Total Employees: " + employees.size());

		// Write
		System.out.println("******* WRITE *******");
		Employee empl = new Employee("adadff", "adfddfdf", new Date(System.currentTimeMillis()), "911");
		empl = save(empl);
		empl = read(empl.getId());
		System.out.printf("%d %s %s \n", empl.getId(), empl.getFirstname(), empl.getLastname());
		
		// Update
		System.out.println("******* UPDATE *******");
		Employee empl2 = read(7l); // read employee with id 1
		System.out.println("Name Before Update:" + empl2.getFirstname());
		empl2.setFirstname("Abdul");
		update(empl2);	// save the updated employee details

		empl2 = read(7l); // read again employee with id 1
		System.out.println("Name Aftere Update:" + empl2.getFirstname());

		// Delete
		System.out.println("******* DELETE *******");
		delete(empl); 
		Employee empl3 = read(empl.getId());
		System.out.println("Object:" + empl3);
	}
}
