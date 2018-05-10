package com.gareth.spring.springjdbc.assignment2;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class CustomerRowMapper implements RowMapper<Customer> {

	@Override
	public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
		Customer customer = new Customer();
		customer.setId(rs.getInt(1));
		customer.setFirstName(rs.getString(2));
		customer.setLastName(rs.getString(3));
		customer.setAge(rs.getInt(4));
		return customer;
	}

}
