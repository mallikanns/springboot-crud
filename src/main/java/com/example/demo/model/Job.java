package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="jobs")
public class Job {
	@Id
//	 `JOB_ID` varchar(10) NOT NULL DEFAULT '',
	@Column(name="JOB_ID", length = 10)
	String id;
	
//	 `JOB_TITLE` varchar(35) NOT NULL,
	@Column(name="JOB_TITLE", length = 35, nullable = false)
	String jobTitle;
	
//	 `MIN_SALARY` decimal(6,0) DEFAULT NULL,
	@Column(name="MIN_SALARY")
	Integer minSalary;
	
//	 `MAX_SALARY` decimal(6,0) DEFAULT NULL,
	@Column(name="MAX_SALARY")
	Integer maxSalary;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public Integer getMinSalary() {
		return minSalary;
	}
	public void setMinSalary(Integer minSalary) {
		this.minSalary = minSalary;
	}
	public Integer getMaxSalary() {
		return maxSalary;
	}
	public void setMaxSalary(Integer maxSalary) {
		this.maxSalary = maxSalary;
	}
	
	
}
