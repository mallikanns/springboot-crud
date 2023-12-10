package com.example.demo.model;

/*
SELECT * FROM hr.moneydata;CREATE TABLE `employees` (
		  `EMPLOYEE_ID` decimal(6,0) NOT NULL DEFAULT '0',
		  `FIRST_NAME` varchar(20) DEFAULT NULL,
		  `LAST_NAME` varchar(25) NOT NULL,
		  `EMAIL` varchar(25) NOT NULL,
		  `PHONE_NUMBER` varchar(20) DEFAULT NULL,
		  `HIRE_DATE` date NOT NULL,
		  `JOB_ID` varchar(10) NOT NULL,
		  `SALARY` decimal(8,2) DEFAULT NULL,
		  `COMMISSION_PCT` decimal(2,2) DEFAULT NULL,
		  `MANAGER_ID` decimal(6,0) DEFAULT NULL,
		  `DEPARTMENT_ID` decimal(4,0) DEFAULT NULL,
		  PRIMARY KEY (`EMPLOYEE_ID`),
		  UNIQUE KEY `EMP_EMAIL_UK` (`EMAIL`),
		  KEY `EMP_DEPARTMENT_IX` (`DEPARTMENT_ID`),
		  KEY `EMP_JOB_IX` (`JOB_ID`),
		  KEY `EMP_MANAGER_IX` (`MANAGER_ID`),
		  KEY `EMP_NAME_IX` (`LAST_NAME`,`FIRST_NAME`)
		) ENGINE=MyISAM DEFAULT CHARSET=latin1;
		CREATE TABLE `employees` (
		  `EMPLOYEE_ID` decimal(6,0) NOT NULL DEFAULT '0',
		  `FIRST_NAME` varchar(20) DEFAULT NULL,
		  `LAST_NAME` varchar(25) NOT NULL,
		  `EMAIL` varchar(25) NOT NULL,
		  `PHONE_NUMBER` varchar(20) DEFAULT NULL,
		  `HIRE_DATE` date NOT NULL,
		  `JOB_ID` varchar(10) NOT NULL,
		  `SALARY` decimal(8,2) DEFAULT NULL,
		  `COMMISSION_PCT` decimal(2,2) DEFAULT NULL,
		  `MANAGER_ID` decimal(6,0) DEFAULT NULL,
		  `DEPARTMENT_ID` decimal(4,0) DEFAULT NULL,
		  PRIMARY KEY (`EMPLOYEE_ID`),
		  UNIQUE KEY `EMP_EMAIL_UK` (`EMAIL`),
		  KEY `EMP_DEPARTMENT_IX` (`DEPARTMENT_ID`),
		  KEY `EMP_JOB_IX` (`JOB_ID`),
		  KEY `EMP_MANAGER_IX` (`MANAGER_ID`),
		  KEY `EMP_NAME_IX` (`LAST_NAME`,`FIRST_NAME`)
		) ENGINE=MyISAM DEFAULT CHARSET=latin1;
 */

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity

// map class เราเข้า table
@Table(name="employees")

public class Employee {
	@Id
	@Column(name="EMPLOYEE_ID")
//	`EMPLOYEE_ID` decimal(6,0) NOT NULL DEFAULT '0',
	 Integer id;
	
//	`FIRST_NAME` varchar(20) DEFAULT NULL,
	@Column(name="FIRST_NAME", length = 20)
	String firstName;
	
//	`LAST_NAME` varchar(25) NOT NULL,
	@Column(name="LAST_NAME", length = 25, nullable = false)
	String lastName;
	
//	 `EMAIL` varchar(25) NOT NULL,
	@Column(name="EMAIL", length = 25, nullable = false, unique = true)
	String email;
	
//	 `PHONE_NUMBER` varchar(20) DEFAULT NULL,
	@Column(name="PHONE_NUMBER", length = 20)
	String phoneNumber;
	
//	 `HIRE_DATE` date NOT NULL,
	@Column(name="HIRE_DATE", nullable = false)
	LocalDate hireDate;
	
//	 `JOB_ID` varchar(10) NOT NULL,
//	@Column(name="JOB_ID",length = 10, nullable = false)
//	String jobId;
	
	@ManyToOne(optional = false)
	@JoinColumn(name="JOB_ID", nullable = false)
	Job job;
	
//	 `SALARY` decimal(8,2) DEFAULT NULL,
	Double salary;
	
//	 `COMMISSION_PCT` decimal(2,2) DEFAULT NULL,
	Double commissionPct;
	
//	 `MANAGER_ID` decimal(6,0) DEFAULT NULL,
	
//	 `DEPARTMENT_ID` decimal(4,0) DEFAULT NULL,
	@ManyToOne
	@JoinColumn(name="DEPARTMENT_ID")
//	@NotFound(action = NotFoundAction.IGNORE)
	Department department;
	
	
//	public void copy(Employee emp) {
//		this.id = emp.id;
//		this.firstName = emp.firstName;
//		this.lastName = emp.lastName;
//		this.email = emp.email;
//		this.phoneNumber = emp.phoneNumber;
//		this.hireDate = emp.hireDate;
//		this.jobId = emp.jobId;
//		this.salary = emp.salary;
//		this.commissionPct = emp.commissionPct;
////		or
////		this.setId(emp.getId());
//	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public LocalDate getHireDate() {
		return hireDate;
	}
	
	public void setHireDate(LocalDate hireDate) {
		this.hireDate = hireDate;
	}
	
	public Double getSalary() {
		return salary;
	}
	
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	
	public Double getCommissionPct() {
		return commissionPct;
	}
	
	public void setCommissionPct(Double commissionPct) {
		this.commissionPct = commissionPct;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", phoneNumber=" + phoneNumber + ", hireDate=" + hireDate + ", job=" + job + ", salary=" + salary
				+ ", commissionPct=" + commissionPct + ", department=" + department + "]";
	}



	
}
