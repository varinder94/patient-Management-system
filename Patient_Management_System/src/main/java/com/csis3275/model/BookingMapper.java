package com.csis3275.model;


import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class BookingMapper implements RowMapper<Booking>{

	@Override
	public Booking mapRow(ResultSet result, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Booking book=new Booking();
		book.setId(result.getInt("id"));
		book.setName(result.getString("name"));
		book.setLast(result.getString("last"));
		book.setDateP(result.getDate("dateP"));
		book.setDoctor(result.getString("doctor"));
		book.setTimeP(result.getString("timeP"));
		
		//book.setFile(result.getBytes("file"));
		
			return book;
	}

}
