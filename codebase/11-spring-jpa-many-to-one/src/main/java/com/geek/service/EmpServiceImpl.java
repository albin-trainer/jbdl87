package com.geek.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geek.dao.EmployeDao;
import com.geek.entity.Department;
import com.geek.entity.Employee;

import jakarta.transaction.Transactional;
@Service
@Transactional
public class EmpServiceImpl implements EmpService {
	@Autowired
 private EmployeDao empDao;
	@Override
	public Department addNewDepartmentService(Department d) {
		
		return empDao.addNewDepartment(d);
	}
	@Override
	public Employee addNewEmployeeService(Employee e, int deptId) {
		// TODO Auto-generated method stub
		
		return empDao.addNewEmployee(e, deptId);
	}
	@Override
	public List<Employee> getAllEmployeesByDeptIdService(int deptId) {
		// TODO Auto-generated method stub
		return empDao.getAllEmployeesByDeptId(deptId);
	}

}
