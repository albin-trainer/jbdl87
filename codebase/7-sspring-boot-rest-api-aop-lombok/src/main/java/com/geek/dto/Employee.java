package com.geek.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@XmlRootElement
@NoArgsConstructor
@AllArgsConstructor
//@Setter
//@Getter
@Data
public class Employee {
private int empId;
@NotBlank(message = "emp name cannot blank")
private String empName;
private String address;
@Min(value = 10000,message = "Salary must have min value of 10000")
private float salary;

}
