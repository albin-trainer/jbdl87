package com.geek.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
@Entity
@Data
public class Employee {
	@Id
private int empId;
private String empName;
private float salary;

}
