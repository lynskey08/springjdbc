package com.gareth.spring.springjdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class Test {
	
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/gareth/spring/springjdbc/config.xml");
		JdbcTemplate jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");
		System.out.println("Connected to jdbc:postgresql://localhost:5432/mydb..");
		String sql = "insert into employee (id,firstname,lastname) values(?,?,?)";//create the statement
		int result = jdbcTemplate.update(sql,10, "Gareth", "Lynskey");//executes the statement
		System.out.println("Number of records are: " +result);
	}
}
