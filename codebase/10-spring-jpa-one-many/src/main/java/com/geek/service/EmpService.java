package com.geek.service;

import java.util.List;

import com.geek.entity.Department;
import com.geek.entity.Employee;

public interface EmpService {
	 Department addNewDepartmentService(Department d);
	 Employee addNewEmployeeService(Employee e, int deptId);
		public List<Employee> getAllEmployeesByDeptIdService(int deptId) ;

}
