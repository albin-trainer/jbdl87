package com.geek.dao;

import java.util.List;

import com.geek.entity.Department;
import com.geek.entity.Employee;

public interface EmployeDao {
 Department addNewDepartment(Department d);
 Employee addNewEmployee(Employee e, int deptId);
 
 List<Employee> getAllEmployeesByDeptId(int deptId);
}
