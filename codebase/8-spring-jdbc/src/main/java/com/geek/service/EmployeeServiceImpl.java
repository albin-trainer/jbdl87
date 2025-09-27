package com.geek.service;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.geek.dao.EmployeeDao;
import com.geek.dto.Employee;
@Component
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	@Qualifier("employeeDaoImplJdbcTemplate")
    private EmployeeDao empDao;
	public List<Employee> allEmps() {
	//	System.out.println("all emps service method");
		return empDao.getAllEmps();
	}

	public Employee addNewEmp(Employee e) {
		return empDao.addNewEmployee(e);
	}

}
