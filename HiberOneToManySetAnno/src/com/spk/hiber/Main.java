package com.spk.hiber;


import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Main {
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();

//		For UNIDIRECTIONAL
//		Department department = new Department();
//		department.setDepartmentName("Sales");
//		session.save(department);
//		
//		Employee emp1 = new Employee("Nina", "Mayers", "111");
//		Employee emp2 = new Employee("Tony", "Almeida", "222");
//
//		emp1.setDepartment(department);
//		emp2.setDepartment(department);
//		
//		session.save(emp1);
//		session.save(emp2);
		
		//For Bidirectional
		Department department = new Department();
		department.setDepartmentName("Sales");

		Employee emp1 = new Employee("Nina", "Mayers", "111");
		Employee emp2 = new Employee("Tony", "Almeida", "222");
		
		department.setEmployees(new ArrayList<Employee>());
		department.getEmployees().add(emp1);
		department.getEmployees().add(emp2);
		
		session.save(department);

		session.getTransaction().commit();
		session.close();
		
		System.out.println("Transactions completed Successfully");
	}
}
