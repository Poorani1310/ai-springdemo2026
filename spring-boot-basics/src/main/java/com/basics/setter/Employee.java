package com.basics.setter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Employee 
{
	String empname;
	Integer empID;
	double salary;
	
	private Address empaddr;
	
	public Address getEmpaddr() {
		return empaddr;
	}

	@Autowired
	public void setEmpaddr(Address empaddr) {
		this.empaddr = empaddr;
	}
	
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
	
	@Value("Poorani")
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public Integer getEmpID() {
		return empID;
	}
	
	@Value("4635")
	public void setEmpID(Integer empID) {
		this.empID = empID;
	}
	public double getSalary() {
		return salary;
	}
	
	@Value("150000.00")
	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [empname=" + empname + ", empID=" + empID + ", salary=" + salary + ", empaddr=" + empaddr
				+ "]";
	}
	
	
}


