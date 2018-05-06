package com.gareth.spring.springjdbc.employee.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.gareth.spring.springjdbc.employee.dao.EmployeeDao;
import com.gareth.spring.springjdbc.employee.dto.Employee;

public class Test {
	
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/gareth/spring/springjdbc/employee/test/config.xml");
		EmployeeDao dao = (EmployeeDao) ctx.getBean("employeeDao");//read the bean
		
		//created employee dto(data transfer object)
		//and giving it data
		Employee employee = new Employee();
		employee.setId(2);
		employee.setFirstName("Greg");
		employee.setLastName("Front");
		
		//invoked the create method by passing it the employee
		//object, instead of passing values
		//int result = dao.create(employee);
		
		int result = dao.update(employee);
		System.out.println("Number of records are: " +result);
	}
}
