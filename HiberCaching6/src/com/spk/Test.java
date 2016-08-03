package com.spk;

public class Test {

	public static void main(String[] args) {

		ManageEmployee ME = new ManageEmployee();

		/* Add few employee records in database */
		Integer empID1 = ME.addEmployee("AAAAAA", "aa", 2000);
		Integer empID2 = ME.addEmployee("BBBBB", "bb", 5000);
		Integer empID3 = ME.addEmployee("CCCCC", "cc", 5000);
		Integer empID4 = ME.addEmployee("DDDDD", "dd", 3000);

		/* List down employees and their salary using Scalar Query */
		//ME.listEmployeesScalar();

		/* List down complete employees information using Entity Query */
		//ME.listEmployeesEntity();

	}

}
