package com.spk.hiber;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name="EMPLOYEE")
public class Employee {

	@Id
	@GeneratedValue
	@Column(name="EMPLOYEE_ID")
	private Long employeeId;

	@Column(name="FIRST_NAME")
	private String firstname;

	@Column(name="LAST_NAME")
	private String lastname;

	@Column(name="BIRTH_DATE")
	private Date birthDate;

	@Column(name="CELL_PHONE")
	private String cellphone;

	//for unidirectional relation
	//@ManyToOne
	//@JoinColumn(name="DEPARTMENT_ID")
	//private Department department;
	
	//for bidirectional
	@ManyToOne
	@JoinColumn(name="department_id", insertable=false, updatable=false, nullable=false)
	private Department department;

	public Employee() {

	}

	public Employee(String firstname, String lastname, String phone) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.birthDate = new Date(System.currentTimeMillis());
		this.cellphone = phone;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	// Getter and Setter methods
	
	
}
