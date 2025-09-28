package com.geek.entity;

import org.springframework.stereotype.Component;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceUnit;

@Component
public class CacheTest {
   @PersistenceUnit(name="default")
	private EntityManagerFactory emf;
   
   public Employee searchById(int id) {
	   EntityManager em=emf.createEntityManager();
	   Employee e=em.find(Employee.class, id);
	   //Wont Hit the DB 
	   //simply returns snapshot (backup) copy
	 e=  em.find(Employee.class, id);
	   return e;
   }
   
   public void updateSalary(int id,float sal) {
	   EntityManager em=emf.createEntityManager();
	   em.getTransaction().begin();
	   Employee e=em.find(Employee.class, id);
	   e.setSalary(sal);
	   em.getTransaction().commit();
	   System.out.println("salary updated");
   }
}
