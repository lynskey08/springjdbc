package com.gareth.spring.springjdbc.assignment;



import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Test {
	
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/gareth/spring/springjdbc/assignment/config.xml");
		PassengerDao dao = (PassengerDao) ctx.getBean("passengerDao");
		
//		Passenger passenger = new Passenger();
//		passenger.setId(5);
//		passenger.setFirstName("Evan");
//		passenger.setLastName("Donagh");
		
		//int result = dao.create(passenger);
		//int result = dao.update(passenger);
		//int result = dao.delete(3);
		
		//rowMapper single record query execute
		//Passenger passenger = dao.read(1);
		//System.out.println(passenger);
		
		List<Passenger> result = dao.read();
		System.out.println(result);
		
		//System.out.println("New record updated: "+result);
		((AbstractApplicationContext) ctx).close();
	}
}
