package com.csis3275.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;


public class BookingMapper implements RowMapper<Booking> {

    
	@Override
	public Booking mapRow(ResultSet rs, int rowNum) throws SQLException {
		Booking book=new Booking();
		book.setId(rs.getInt("id"));	
		book.setName(rs.getString("name"));
		book.setLast(rs.getString("last"));
		book.setDateP(rs.getDate("dateP"));
		book.setTimeP(rs.getString("timeP"));
		book.setDoctor(rs.getString("doctor"));
	
		
		return book;
	}

	

}
