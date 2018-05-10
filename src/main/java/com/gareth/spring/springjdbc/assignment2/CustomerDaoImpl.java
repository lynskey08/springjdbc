package com.gareth.spring.springjdbc.assignment2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component("customerDao")
public class CustomerDaoImpl implements CustomerDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public int insert(Customer customer) {
		String sql = "insert into customer(id,firstname,lastname,age) values(?,?,?,?)";
		int result = jdbcTemplate.update(sql, customer.getId(), customer.getFirstName(), customer.getLastName(), customer.getAge());
		return result;
	}

	@Override
	public int update(Customer customer) {
		String sql = "update customer set firstname=?,lastname=?,age=? where id=?";
		int result = jdbcTemplate.update(sql, customer.getFirstName(), customer.getLastName(), customer.getAge(), customer.getId());
		return result;
	}
	
	@Override
	public int delete(int id) {
		String sql = "delete from customer where id=?";
		int result = jdbcTemplate.update(sql, id);
		return result;
	}
	
	@Override
	public Customer read(int id) {
		String sql = "select * from customer where id=?";
		CustomerRowMapper rowMapper = new CustomerRowMapper();
		Customer customer = jdbcTemplate.queryForObject(sql, rowMapper, id);
		return customer;
	}
	
	@Override
	public List<Customer> read() {
		String sql = "select * from customer";
		CustomerRowMapper rowMapper = new CustomerRowMapper();
		List<Customer> customer = jdbcTemplate.query(sql, rowMapper);
		return customer;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}
