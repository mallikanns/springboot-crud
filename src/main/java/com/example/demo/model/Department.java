package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="departments")
public class Department {
	@Id
//	 `DEPARTMENT_ID` decimal(4,0) NOT NULL DEFAULT '0',
	@Column(name="DEPARTMENT_ID")
	Integer id;
//	 `DEPARTMENT_NAME` varchar(30) NOT NULL,
	@Column(name="DEPARTMENT_NAME", length = 30, nullable = false)
	String name;
	
//	 `MANAGER_ID` decimal(6,0) DEFAULT NULL,
	@OneToOne
	@JoinColumn(name="MANAGER_ID")
//	@JsonIgnore
	@JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class, 
            property = "id")
	Employee manager;
	
//	 `LOCATION_ID` decimal(4,0) DEFAULT NULL,
	@Column(name="LOCATION_ID")
	Integer location;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Employee getManager() {
		return manager;
	}
	public void setManager(Employee manager) {
		this.manager = manager;
	}
	public Integer getLocation() {
		return location;
	}
	public void setLocation(Integer location) {
		this.location = location;
	}
	
	
}
