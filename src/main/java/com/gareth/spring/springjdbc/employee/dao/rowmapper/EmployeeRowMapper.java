package com.gareth.spring.springjdbc.employee.dao.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.gareth.spring.springjdbc.employee.dto.Employee;

public class EmployeeRowMapper implements RowMapper<Employee> {

	/*1.Spring will give us the ResultSet at runtime.
	 * 2.We're getting the results out of the result set
	 * 3. Creating an object of our own type and setting
	 * the results to that type
	 * 4. and then returning it*/
	@Override
	public Employee mapRow(/*1*/ResultSet rs, int rowNum) throws SQLException {
		Employee emp = new Employee();
		//first column in the database is id. That is why we're
		//passing getInt the column index 1 and setting it into
		//emp.setID
		emp.setId(rs.getInt(1));/*2 & 3*/
		emp.setFirstName(rs.getString(2));
		emp.setLastName(rs.getString(3));
		return emp;/*4*/
	}

}
