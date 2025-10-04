package com.geek.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
@Entity
@Data
@Table(name ="EMP1")
public class Employee {
	@Id
private int empId;
private String empName;
private float salary;
@ManyToOne
private Department dept;
}
