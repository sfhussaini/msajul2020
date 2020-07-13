package com.example.EmployeeMS;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "EMPLOYEES")
@SequenceGenerator(name="employee_seq", initialValue=1, allocationSize=100)
public class Employee {
	@Id //Primary key
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="employee_seq")
	@Column(name = "EMP_ID")
	private Integer empId;
	@Column(name = "EMP_JOB")
	private String job;
	@Column(name = "EMP_NAME")
	private String name;
	@Column(name = "EMP_SALARY")
	private Double salary;
	@Column(name = "EMP_DEPARTMENT")
	private String department;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Column(name = "EMP_EMAIL")
	private String email;
	
	public Integer getEmpId() {
		return empId;
	}
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
}
