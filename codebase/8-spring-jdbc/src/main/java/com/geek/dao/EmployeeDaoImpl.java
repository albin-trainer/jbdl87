package com.geek.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.geek.dto.Employee;
import com.geek.service.DBConnection;
@Component
public class EmployeeDaoImpl 
implements EmployeeDao{
	 @Autowired
		private DBConnection dbConnection;
	@Override
	public List<Employee> getAllEmps() {
		List<Employee> emplist=new ArrayList<>();
		Connection con=dbConnection.getConnectionWithMysql();
		String sql="select * from employee";
		try {
			PreparedStatement pstmt=con.prepareStatement(sql);
			ResultSet rs=  pstmt.executeQuery(); //returns result set (pointer)
			while (rs.next()) { //next()-> moves the pointer to nxt rec & returns true
				int id=rs.getInt("empId"); //reads the col value
				String name=rs.getString("empname");
				String address=rs.getString("address");
				float sal=rs.getFloat("salary");
				Employee e= new Employee(id, name, address, sal);
				emplist.add(e);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return emplist;
	}

	@Override
	public Employee addNewEmployee(Employee e) {
		Connection con=dbConnection.getConnectionWithMysql();
		String sql="insert into employee values(?,?,?,?)";
		try {
			PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setInt(1, e.getEmpId()); //for 1st col
		pstmt.setString(2, e.getEmpName());//for 2nd col
		pstmt.setString(3, e.getAddress());
		pstmt.setFloat(4, e.getSalary());
		pstmt.executeUpdate(); //query triggers in DB (this moment insert into the DB)
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return e;
	}

}
