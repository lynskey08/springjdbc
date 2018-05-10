package com.gareth.spring.springjdbc.assignment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component("passengerDao")
public class PassengerDaoImpl implements PassengerDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int create(Passenger passenger) {
		String sql = "insert into passenger(id,firstname,lastname) values(?,?,?)";
		int result = jdbcTemplate.update(sql, passenger.getId(), passenger.getFirstName(), passenger.getLastName());
		return result;
	}

	@Override
	public int update(Passenger passenger) {
		String sql = "update passenger set firstname=?, lastname=? where id=?";
		int result = jdbcTemplate.update(sql, passenger.getFirstName(), passenger.getLastName(), passenger.getId());
		return result;
	}
	
	@Override
	public int delete(int id) {
		String sql = "delete from passenger where id=?";
		int result = jdbcTemplate.update(sql, id);
		return result;
	}
	
	@Override
	public Passenger read(int id) {
		String sql = "select * from passenger where id=?";
		PassengerRowMapper rowMapper = new PassengerRowMapper();
		Passenger passenger = jdbcTemplate.queryForObject(sql, rowMapper, id);
		return passenger;
	}

	@Override
	public List<Passenger> read() {
		String sql = "select * from passenger";
		PassengerRowMapper rowMapper = new PassengerRowMapper();
		List<Passenger> passenger = jdbcTemplate.query(sql, rowMapper);
		return passenger;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
}
