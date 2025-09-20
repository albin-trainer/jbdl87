package com.geek.dto;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Employee {
private int empId;
private String empName;
private String address;
private float salary;
public Employee() {
}
public Employee(int empId, String empName, String address, float salary) {
	super();
	this.empId = empId;
	this.empName = empName;
	this.address = address;
	this.salary = salary;
}
public int getEmpId() {
	return empId;
}
public void setEmpId(int empId) {
	this.empId = empId;
}
public String getEmpName() {
	return empName;
}
public void setEmpName(String empName) {
	this.empName = empName;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public float getSalary() {
	return salary;
}
public void setSalary(float salary) {
	this.salary = salary;
}


}
