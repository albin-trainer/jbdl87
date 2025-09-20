package com.geek.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.geek.dto.Employee;
import com.geek.exception.ApplicationException;
import com.geek.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeesApi {
	@Autowired
	private EmployeeService empService;
	@GetMapping("/test")
	public String test() {
		return "Its working";
	}
	@GetMapping( value="/sample",produces = { "application/xml","application/json"})
	public Employee testEmployee() {
		Employee emp= new Employee(101, "Abhijeet", "Bangalore", 500000);
		return emp;
	}
	@GetMapping
	public List<Employee> getAllEmps(){
		return empService.allEmps();
	}
	@GetMapping( value= "/{id}",produces = { "application/xml","application/json"})
	public Employee searchById(@PathVariable("id") int id) {
		List<Employee> emps=empService.allEmps();
		Employee emp=emps.stream().filter(e->e.getEmpId()==id).
				findFirst().orElseThrow(()-> new ApplicationException("Emp not found"));
		return emp;
	}
	
}
