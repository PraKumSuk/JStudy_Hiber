package com.spk;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ManageEmployee ME = new ManageEmployee();

		// Add few employee records in database 
		Integer empID1 = ME.addEmployee("Kalyan", "Kumar", 111);
		Integer empID2 = ME.addEmployee("Vasanth", "Kumar", 222);
		Integer empID3 = ME.addEmployee("Dhiraj", "Kumar", 333);
//
//		// List down all the employees 
//		ME.listEmployees();
//
//		// Update employee's records 
//		ME.updateEmployee(empID1, 999);
//
//		// Delete an employee from the database 
//		ME.deleteEmployee(empID2);

		// List down new list of the employees 
		ME.listEmployees();

	}

}
