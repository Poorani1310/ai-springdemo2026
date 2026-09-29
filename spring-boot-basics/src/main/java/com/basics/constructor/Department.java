package com.basics.constructor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Department 
{
	String deptid;
	String deptname;
	
	@Override
	public String toString() {
		return "Department [deptid=" + deptid + ", deptname=" + deptname + "]";
	}
	public String getDeptid() {
		return deptid;
	}
	@Value("CSE")
	public void setDeptid(String deptid) {
		this.deptid = deptid;
	}
	public String getDeptname() {
		return deptname;
	}
	@Value("Computer Science Engineering")
	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}
	
	
}
