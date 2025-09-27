package com.geek.dao;

import java.util.List;

import com.geek.dto.Employee;

public interface EmployeeDao {
	List<Employee> getAllEmps();
	Employee addNewEmployee(Employee e);
}
