package com.spk.hiber;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table (name="EMPLOYEE")
public class Employee extends Person {

	private Date joiningDate;
	
	private String departmentName;
	
	public Date getJoiningDate() {
		return joiningDate;
	}
	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public Employee(){

	}

	public Employee(String firstName, String lastName, String department, Date date){
		super.setFirstname(firstName);
		super.setLastname(firstName);
		this.departmentName= department;
		this.joiningDate=date;

	}

}
