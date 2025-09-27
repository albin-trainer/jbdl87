package com.geek.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.geek.dto.Employee;
@Component
//@Primary
public class EmployeeDaoImplJdbcTemplate 
implements EmployeeDao{
	@Autowired
	private JdbcTemplate template;
	@Override
	public List<Employee> getAllEmps() {
		String sql="select * from employee";
		List<Employee> empList=template.query(sql, new BeanPropertyRowMapper<>(Employee.class));
		return empList;
	}

	@Override
	public Employee addNewEmployee(Employee e) {
		String sql="insert into employee values(?,?,?,?)";
		int c=template.update(sql, e.getEmpId(),e.getEmpName(),e.getAddress(),e.getSalary());
		return e;
	}

}
