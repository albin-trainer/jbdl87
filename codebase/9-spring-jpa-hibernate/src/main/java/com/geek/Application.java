package com.geek;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.geek.entity.Address;
import com.geek.entity.CacheTest;
import com.geek.entity.Employee;
import com.geek.entity.EmployeeDao;
@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		ApplicationContext ctx=
		SpringApplication.run(Application.class, args);
		EmployeeDao dao=ctx.getBean(EmployeeDao.class);
//		Address addrs1=new Address("Chennai", "B-108", 123456);
//		Employee e1=new Employee();
//		e1.setEmpId(106); e1.setEmpName("Manikandan");
//		e1.setSalary(200000);
//		e1.setAddress(addrs1);
//		dao.addNewEmployee(e1);
		/*
		Employee emp=dao.searchById(101);
		if(emp!=null) {
			System.out.println(emp.getEmpId());
			System.out.println(emp.getEmpName());
			System.out.println(emp.getSalary());
			System.out.println(emp.getAddress().getPlaceName());
			System.out.println(emp.getAddress().getDoorNo());
			System.out.println(emp.getAddress().getPinCode());
		}
		else
			System.out.println("Not exists");
			*/
//		List<Employee>  emps=dao.searchByPlace("Chennai");
//		emps.forEach(e->System.out.println(e));
		
		//dao.searchById(101);
		
		///Caching test
		CacheTest testDao=ctx.getBean(CacheTest.class);
		//testDao.searchById(101);
		testDao.updateSalary(104,300000);
	}
	
}
