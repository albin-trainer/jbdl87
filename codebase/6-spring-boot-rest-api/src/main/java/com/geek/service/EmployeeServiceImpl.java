package com.geek.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.geek.dto.Employee;
@Component
public class EmployeeServiceImpl implements EmployeeService {
List<Employee> emps= new ArrayList<>();
{
	emps.add(new Employee(101, "Abhijeet", "Bangalore", 500000));
	emps.add(new Employee(102, "Sharuktan", "Mumbai", 500000));
	emps.add(new Employee(103, "Prachi", "Pune", 500000));
	emps.add(new Employee(104, "Puneet", "Delhi", 500000));
	emps.add(new Employee(105, "RajKumar", "Bangalore", 500000));
}
	@Override
	public List<Employee> allEmps() {
		return emps;
	}

}
