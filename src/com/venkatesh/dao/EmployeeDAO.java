package com.venkatesh.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.venkatesh.Employee;

public class EmployeeDAO {
	
	public boolean add(Employee employee){
		Connection con;
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Loaded");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/exampledb", "root", "root");
			System.out.println("Connected");
			
			PreparedStatement ps = con.prepareStatement("INSERT INTO employee_details(empId, empName, empAge, empDesignation) VALUES(?,?,?,?)");
			
			int index=0;
			ps.setInt(++index, employee.getEmpId());
			ps.setString(++index, employee.getEmpName());
			ps.setInt(++index, employee.getEmpAge());
			ps.setString(++index, employee.getEmpDesignation());
			
			if(ps.executeUpdate() > 0){
				con.close();
				return true;
			}
		} catch (ClassNotFoundException e){ 
			e.printStackTrace();
		}catch (SQLException e){ 
			e.printStackTrace();
		}
		return false;
	}

}
