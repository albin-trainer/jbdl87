package com.geek.entity;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
@Entity
@Data//setter and getters
//Lombok - to avoid boiler plate code
@Table(name="DEPT1")
public class Department {
	@Id
private int deptId;
private String deptName;
@OneToMany(mappedBy = "dept")
private List<Employee> emps;

}
