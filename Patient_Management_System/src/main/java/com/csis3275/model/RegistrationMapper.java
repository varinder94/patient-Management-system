package com.csis3275.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class RegistrationMapper implements RowMapper<Registration>{

	@Override
	public Registration mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Registration register=new Registration();
		register.setFirstname(rs.getString("firstname"));
		register.setLastname(rs.getString("lastName"));
		register.setEmail(rs.getString("email"));
		register.setSex(rs.getString("sex"));
		register.setBirthDay(rs.getDate("BirthDay"));
		register.setPassword(rs.getString("telephone"));
		register.setTelephone(rs.getString("password"));
		return register;
	}

}
