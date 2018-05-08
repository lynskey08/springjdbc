package com.gareth.spring.springjdbc.employee.dao;

import java.util.List;

import com.gareth.spring.springjdbc.employee.dto.Employee;

public interface EmployeeDao {
	
	int create(Employee employee);
	
	int update(Employee employee);
	
	int delete(int id);
	
	//read single employee from the database table
	Employee read(int id);
	
	//read multiple employees from the database
	List<Employee> read();
}
