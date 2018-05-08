package com.gareth.spring.springjdbc.employee.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.gareth.spring.springjdbc.employee.dao.EmployeeDao;
import com.gareth.spring.springjdbc.employee.dto.Employee;

public class Test {
	
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/gareth/spring/springjdbc/employee/test/config.xml");
		EmployeeDao dao = (EmployeeDao) ctx.getBean("employeeDao");//read the bean from the spring container
		
		//created employee dto(data transfer object)
		//and giving it data(for inserts and updates)
//		Employee employee = new Employee();
//		employee.setId(5);
//		employee.setFirstName("Dillon");
//		employee.setLastName("Kenny");
		
		//invoked the create method by passing it the employee
		//object, instead of passing values
		//int result = dao.create(employee);
		//int result = dao.update(employee);
		//int result = dao.delete(10);
		
		//read single employee from the database table
		//Employee employee = dao.read(2);
		//System.out.println("Employee Record: " +employee);
		
		List<Employee> result = dao.read();
		System.out.println("Employee Records: " +result);
		
		//System.out.println("Number of records are: " +result);
		((AbstractApplicationContext) ctx).close();
	}
}
