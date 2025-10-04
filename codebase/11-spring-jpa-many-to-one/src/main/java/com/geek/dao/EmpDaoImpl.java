package com.geek.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.geek.entity.Department;
import com.geek.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.PersistenceUnit;
import jakarta.persistence.Query;

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
	public Employee addNewEmployee(Employee e, int deptId) {
		Department d=em.find(Department.class,deptId);
		if(d!=null) {
			e.setDept(d);
			em.persist(e);
			System.out.println("A new emp added ...");
		}
		else System.out.println("Dept not exists !!!!");
		return e;
	}

	@Override
	public List<Employee> getAllEmployeesByDeptId(int deptId) {
		//query param  :paramname
	   String jpql="select emp from Employee emp where emp.dept.deptId = :departId";
	   Query q=em.createQuery(jpql);
	   q.setParameter("departId", deptId);
	   List<Employee> emplist= q.getResultList();
		return emplist;
	}

}
