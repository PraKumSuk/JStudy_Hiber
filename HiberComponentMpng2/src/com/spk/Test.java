package com.spk;

public class Test {

	public static void main(String[] args) {

		ManageEmployee ME = new ManageEmployee();

		// Address 1
		Address address1 = ME.addAddress("Kengeri","Bangalore","KA","111");
		// Employee 1
		Integer empID1 = ME.addEmployee("Kalyan", "Kumar", 4000, address1);

		// Address 2
		Address address2 = ME.addAddress("Vontikoppal","Mysore","KA","222");
		// Employee 2
		Integer empID2 = ME.addEmployee("Vasanth", "Kumar", 3000, address2);

		// List down all the employees
		ME.listEmployees();

		// Update employee's salary records
		ME.updateEmployee(empID1, 9999);

		// List down all the employees
		ME.listEmployees();

	}

}
