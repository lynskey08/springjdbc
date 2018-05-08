package com.gareth.spring.springjdbc.employee.dao.impl;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.gareth.spring.springjdbc.employee.dao.EmployeeDao;
import com.gareth.spring.springjdbc.employee.dao.rowmapper.EmployeeRowMapper;
import com.gareth.spring.springjdbc.employee.dto.Employee;

public class EmployeeDaoImpl implements EmployeeDao {

	private JdbcTemplate jdbcTemplate;

	@Override
	public int create(Employee employee) {
		String sql = "insert into employee (id,firstname,lastname) values(?,?,?)";
		int result = jdbcTemplate.update(sql, employee.getId(), employee.getFirstName(), employee.getLastName());
		return result;
	}

	@Override
	public int update(Employee employee) {
		String sql = "update employee set firstname=?,lastname=? where id=?";
		int result = jdbcTemplate.update(sql, employee.getFirstName(), employee.getLastName(), employee.getId());
		return result;
	}

	@Override
	public int delete(int id) {
		String sql = "delete from employee where id=?";
		int result = jdbcTemplate.update(sql, id);
		return result;
	}
	//read single employee from the database table
	@Override
	public Employee read(int id) {
		String sql = "select * from employee where id=?";
		EmployeeRowMapper rowMapper = new EmployeeRowMapper();
		//take the returns and pass them to an employee object
		Employee employee = jdbcTemplate.queryForObject(sql, rowMapper, id);
		return employee;
	}
	
	//read multiple employees from the database
	@Override
	public List<Employee> read() {
		String sql = "select * from employee";
		EmployeeRowMapper rowMapper = new EmployeeRowMapper();
		List<Employee> employees = jdbcTemplate.query(sql, rowMapper);
		return employees;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	

	

}
