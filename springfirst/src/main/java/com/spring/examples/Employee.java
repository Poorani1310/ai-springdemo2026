package com.spring.examples;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import sun.jvm.hotspot.debugger.Address;

@Component
public class Employee 
{
	String empname;
	Integer empID;
	double salary;
	
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(String empname, Integer empID, double salary) {
		super();
		this.empname = empname;
		this.empID = empID;
		this.salary = salary;
	}
	
	public String getEmpname() {
		return empname;
	}
	
	@Value("${employee.name}")
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public Integer getEmpID() {
		return empID;
	}
	
	@Value("${employee.id}")
	public void setEmpID(Integer empID) {
		this.empID = empID;
	}
	public double getSalary() {
		return salary;
	}
	
	@Value("${employee.salary}")
	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [empname=" + empname + ", empID=" + empID + ", salary=" + salary + "]";
	}
	
	
}
