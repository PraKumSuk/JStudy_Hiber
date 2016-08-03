package com.spk;

public class Test {

	public static void main(String[] args) {

		ManageEmployee ME = new ManageEmployee();

		/* Add few employee records in database */
		Integer empID1 = ME.addEmployee("Zara", "Ali", 2000);
		Integer empID2 = ME.addEmployee("Daisy", "Das", 5000);
		Integer empID3 = ME.addEmployee("John", "Paul", 5000);
		Integer empID4 = ME.addEmployee("Mohd", "Yasee", 3000);

		/* List down employees and their salary using Scalar Query */
		ME.listEmployeesScalar();

		/* List down complete employees information using Entity Query */
		ME.listEmployeesEntity();

	}

}
