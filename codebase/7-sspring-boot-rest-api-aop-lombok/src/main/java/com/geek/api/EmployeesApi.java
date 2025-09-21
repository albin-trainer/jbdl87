package com.geek.api;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.geek.dto.Employee;
import com.geek.exception.ApplicationException;
import com.geek.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/employees")
public class EmployeesApi {
	@Autowired
	private EmployeeService empService;
	Logger log= LoggerFactory.getLogger(EmployeesApi.class);
	
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
		//logs used to maintain/tract the history ...
		log.info("getting all emos "); //with timestamp can be stored in a file
		System.out.println("---before ---");
		 List<Employee> emps= empService.allEmps();
		 System.out.println("----after----");
		 return emps;
	}
	@PostMapping(produces = "application/json",consumes = "application/xml")
	public List<Employee> addNewEmp( @Valid @RequestBody Employee e){
		List<Employee> emps=empService.allEmps();
		emps.add(e);
		return emps;
	}
	
	@GetMapping( value= "/{id}",produces = { "application/xml","application/json"})
	public Employee searchById(@PathVariable("id") int id) {
		List<Employee> emps=empService.allEmps();
		Employee emp=emps.stream().filter(e->e.getEmpId()==id).
				findFirst().orElseThrow(()-> new ApplicationException("Emp not found"));
		return emp;
	}
	
}
