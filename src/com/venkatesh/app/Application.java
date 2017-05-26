package com.venkatesh.app;

import com.venkatesh.Employee;
import com.venkatesh.dao.EmployeeDAO;

public class Application {

	public static void main(String[] args){
		
		Employee e = new Employee();
		e.setEmpAge(30);
		e.setEmpDesignation("SE");
		e.setEmpId(102);
		e.setEmpName("Smith");
		
		EmployeeDAO dao = new EmployeeDAO();
		if(dao.add(e))
			System.out.println("Inserted");
		else
			System.out.println("Not Inserted");
	}
}
