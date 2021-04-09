package com.csis3275.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.csis3275.model.Booking;
import com.csis3275.model.BookingMapper;
import com.csis3275.model.Doctor;




@Component
public class Bookingdao {

	static JdbcTemplate jdbcTemplate;
	private final String SQL_GET_ALL_BOOKING = "select * from BOOKING";
	private final  String SQL_INSERT_BOOKING = "insert into BOOKING(name,last,dateP,doctor,timeP) values(?,?,?,?,?)";
	private final String SQL_DELETE_Booking = "DELETE FROM BOOKING WHERE id = ?";
	
	@Autowired
	public Bookingdao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
//	public Booking getBookingById(int id) {
//		return jdbcTemplate.queryForObject(FIND_BOOKING, new Object[] { id }, new BookingMapper());
//	}
//	
	public List<Booking> getAllBooking() {
		return jdbcTemplate.query(SQL_GET_ALL_BOOKING, new BookingMapper());
	}

	public boolean createNewBooking(Booking book) {
		
		 return jdbcTemplate.update(SQL_INSERT_BOOKING,book.getName(),book.getLast(),
				                   book.getDateP(),book.getDoctor(),book.getTimeP()) > 0;
				                   
				                   
	}
	
	// This Method Is Used To Save The Uploaded File In The Database
 
//	public boolean updateBooking(Booking book) {
//		return jdbcTemplate.update(SQL_UPDATE_BOOKING,book.getId(),book.getName(),book.getLast(),
//                book.getDateP(),book.getTimeP(),book.getDoctor()) > 0;
//	}
	public boolean deleteBooking(int idToDelete) {
		return jdbcTemplate.update(SQL_DELETE_Booking, idToDelete) > 0;
	}
	
}
