package com.csis3275.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.csis3275.model.Booking;
import com.csis3275.model.BookingMapper;


@Component
public class Bookingdao {
	JdbcTemplate jdbcTemplate;
	
	private final String SQL_GET_ALL = "select * from BOOKING";
	private final String SQL_INSERT_BOOKING = "insert into BOOKING(id,name, last,dateP,timeP,doctor,file) values(?,?,?,?,?,?,?)";
	private final String FIND_Booking = "select * from BOOKING where id = ?";
	private final String SQL_UPDATE_Booking = "UPDATE BOOKING set  id = ?, name  = ? , last=? , dateP=? , timeP=? , doctor=? , file=?  WHERE id = ?";
	private final String SQL_DELETE_Booking = "DELETE FROM BOOKING WHERE id = ?";

	@Autowired
	public Bookingdao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public Booking getBookingById(int id) {
		return jdbcTemplate.queryForObject(FIND_Booking, new Object[] { id }, new BookingMapper());
	}

	public List<Booking> getAllBooking() {
		return jdbcTemplate.query(SQL_GET_ALL, new BookingMapper());
	}

	public boolean createNewBooking(Booking booking) {
		return jdbcTemplate.update(SQL_INSERT_BOOKING, booking.getId(), booking.getName(), booking.getLast(),
				booking.getDateP(), booking.getTimeP(), booking.getDoctor(), booking.getFile()) > 0;
	}
	
	public boolean updateBooking(Booking booking) {
		return jdbcTemplate.update(SQL_UPDATE_Booking, booking.getId(), booking.getName(),
				booking.getLast(),booking.getDateP(), booking.getTimeP(), booking.getDoctor(),
				booking.getFile()) > 0;
	}
	
	public boolean deleteBooking(int idToDelete) {
		return jdbcTemplate.update(SQL_DELETE_Booking, idToDelete) > 0;
	}

	
	
}


