package com.csis3275.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class DoctorMapper implements RowMapper<Doctor>{

	@Override
	public Doctor mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Doctor doctor=new Doctor();
		doctor.setId(rs.getInt("id"));
		doctor.setFirstName(rs.getString("firstName"));
		doctor.setLastName(rs.getString("lastName"));
		doctor.setEmail(rs.getString("email"));
		doctor.setPassword(rs.getString("password"));
		doctor.setSex(rs.getString("sex"));
		doctor.setSpecialization(rs.getString("specialization"));
		return doctor;
	}

}
