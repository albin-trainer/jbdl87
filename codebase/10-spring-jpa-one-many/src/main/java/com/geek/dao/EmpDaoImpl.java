package com.geek.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.geek.entity.Department;
import com.geek.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.PersistenceUnit;

@Repository
public class EmpDaoImpl implements EmployeDao {
	@PersistenceContext
	private EntityManager em;
	@Override
	public Department addNewDepartment(Department d) {
		 em.persist(d);
		return d;
	}
	@Override
	//Any performance issue in adding a new employee ?????
	public Employee addNewEmployee(Employee e, int deptId) {
		Department d=em.find(Department.class, deptId);
		if(d!=null) {
		  List<Employee>  emps=	d.getEmps();  //load all emps, its a unneccessary , 
		  if(emps==null) {
			  //for the 1st time if a dept having no emps returns null
			emps=new ArrayList<>();
		  }
		  emps.add(e);
		  System.out.println("Emp added ..");
		}
		return e;
	}

	@Override
	public List<Employee> getAllEmployeesByDeptId(int deptId) {
		//query for searching only for  Department ...
		System.out.println("---searching emps---");
		Department d=em.find(Department.class, deptId);
		if(d!=null) {
			System.out.println("---inside if ---");
			//here fires one more query to get all emps
		List<Employee>  emps=  d.getEmps();
		return emps;
		}
		return null;
	}

}
