package com.basics.constructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Student 
{
	private String studname;
	private String studid;
	private Department department;
	
//	@Autowired
//	no need to add the annotation
	public Student(Department department) {
		super();
		this.department = department;
	}


	@Override
	public String toString() {
		return "Student [studname=" + studname + ", studid=" + studid + ", department=" + department + "]";
	}


	public String getStudname() {
		return studname;
	}

	@Value("Poorani")
	public void setStudname(String studname) {
		this.studname = studname;
	}


	public String getStudid() {
		return studid;
	}

	@Value("CH013")
	public void setStudid(String studid) {
		this.studid = studid;
	}


	public Department getDepartment() {
		return department;
	}


	public void setDepartment(Department department) {
		this.department = department;
	}
	
	
}
