package com.gareth.spring.springjdbc.assignment2;

import java.util.List;

public interface CustomerDao {
	
	int insert(Customer customer);
	
	int update(Customer customer);
	
	int delete(int id);
	
	Customer read(int id);
	
	List<Customer> read();
}
