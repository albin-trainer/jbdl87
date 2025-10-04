package com.geek.entity;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
@Entity
@Data//setter and getters
//Lombok - to avoid boiler plate code
public class Department {
	@Id
private int deptId;
private String deptName;
@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
private List<Employee> emps;
}
