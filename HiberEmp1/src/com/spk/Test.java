package com.spk;

public class Test {

	public static void main(String[] args) {

		try{

			ManageEmployee manageEmployee = new ManageEmployee();

			// Add few employee records in database
			Integer empID1 = manageEmployee.addEmployee("Kalyan", "Kumar", 99999);
			Integer empID2 = manageEmployee.addEmployee("Vasanth", "Kumar", 88888);
			Integer empID3 = manageEmployee.addEmployee("Babitha", "Kumari", 77777);
			Integer empID4 = manageEmployee.addEmployee("Dhiraj", "Kumar", 66666);
			Integer empID5 = manageEmployee.addEmployee("Abdul", "Kumar", 55555);
			Integer empID6 = manageEmployee.addEmployee("Vinod", "Kumar", 44444);			

			// List down all the employees
			//manageEmployee.listEmployees();

			// Update employee's records
			//manageEmployee.updateEmployee(5, 99999);

			// Delete an employee from the database
			//manageEmployee.deleteEmployee(6);

			// List down all the employees
			manageEmployee.listEmployees();

		}catch (Exception exception) { 
			System.err.println("Error occured during Manage Employee Process." + exception);			
		}
	}

}
