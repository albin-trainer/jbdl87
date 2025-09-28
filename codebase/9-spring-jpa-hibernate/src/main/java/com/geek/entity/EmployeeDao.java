package com.geek.entity;

import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
@Component
public class EmployeeDao {
   @PersistenceContext
	private EntityManager em;
	@Transactional //declrative transaction
	//starts the transaction @Before method called
	//commits rollback the transaction @After method called
	public void addNewEmployee(Employee e) {
	//	em.getTransaction().begin();
		em.persist(e); //persist obj in DB
		e.getAddress().setPlaceName("Pune");
		//em.getTransaction().commit();
		System.out.println("emp is stored in DB");
	}
	
	public Employee searchById(int id) {
		//find method to search only by PK
		Employee emp=em.find(Employee.class, id);
		
		Employee emp2=em.find(Employee.class, id);
		return emp;
	}
	public List<Employee> allEmps(){
		//Java persistence query language
		String jpql="select emp from Employee emp";
		Query q=  em.createQuery(jpql);
		List<Employee>  emps=	q.getResultList();
		 return emps;
	}
	public List<Employee> searchByPlace(String placeName){
		//Java persistence query language -quering objects not rows in table
		String jpql="select emp from Employee emp where emp.address.placeName= :p";
		Query q=  em.createQuery(jpql);
		q.setParameter("p", placeName);
		List<Employee>  emps=	q.getResultList();
		 return emps;
	}
}
