package com.geek.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.stereotype.Component;
@Component
public class DBConnection {
	public Connection getConnectionWithMysql() {
		Connection connection=null;
		 try {
			Class.forName("com.mysql.cj.jdbc.Driver"); //loads dynamically this class in JVM
			//to make a connection need URL
			 //url syntax : http://google.com:80
			 //u plz try with 3306 port (default)
			 String url="jdbc:mysql://localhost:3307/jbdl87";
			 connection=DriverManager.getConnection(url,"root","root");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
}
