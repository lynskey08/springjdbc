package com.gareth.spring.springjdbc.assignment2;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/gareth/spring/springjdbc/assignment2/config.xml");
		CustomerDao dao = (CustomerDao) ctx.getBean("customerDao");
		
//		Customer customer = new Customer();
//		customer.setId(4);
//		customer.setFirstName("Shane");
//		customer.setLastName("Burkelina");
//		customer.setAge(26);
		
		//int result = dao.insert(customer);
		//int result = dao.update(customer);
		//int result = dao.delete(1);
		//System.out.println("Number of records deleted: "+result);
		
		//Customer result = dao.read(2);
		List<Customer> result = dao.read();
		System.out.println(result);
		((AbstractApplicationContext) ctx).close();
		
	}

}
