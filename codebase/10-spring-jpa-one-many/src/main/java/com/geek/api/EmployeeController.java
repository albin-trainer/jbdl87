package com.geek.api;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.geek.entity.Department;
import com.geek.entity.Employee;
import com.geek.service.EmpService;
@RestController
public class EmployeeController {
	@Autowired
	private EmpService empService;
	@PostMapping("/departments")
	public Department addNewDepartment(@RequestBody  Department d) {
		return empService.addNewDepartmentService(d);
	}
	@PostMapping("/employees/{deptId}")
	public Employee addNewEmployee( @RequestBody Employee e,@PathVariable("deptId")  int deptId) {
		// TODO Auto-generated method stub
		return empService.addNewEmployeeService(e, deptId);
	}
	@GetMapping("/departments/searchbyDeptId")
	public List<Employee> getAllEmployeesByDeptId(@RequestParam("deptId")  int deptId) {
		return empService.getAllEmployeesByDeptIdService(deptId);
	}

}
