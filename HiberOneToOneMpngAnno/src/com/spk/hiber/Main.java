package com.spk.hiber;

import java.sql.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Main {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		System.out.println("Hibernate One-To-One example (Annotation)");

		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();

		EmployeeDetail employeeDetail = new EmployeeDetail("99 Street", "CA", "London", "UK");
		Employee employee = new Employee("pravee", "kumar", new Date(111111),"234-343-965");
		
		employee.setEmployeeDetail(employeeDetail);
		employeeDetail.setEmployee(employee);

		session.save(employee);

		List<Employee> employees = session.createQuery("from Employee").list();
		for (Employee employee1 : employees) {
			System.out.println(employee1.getFirstname() + " , "	+ employee1.getLastname() + ", "+ employee1.getEmployeeDetail().getState());
		}

		session.getTransaction().commit();
		session.close();

	}

}
