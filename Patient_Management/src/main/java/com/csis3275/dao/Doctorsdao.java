package com.csis3275.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.csis3275.model.Doctor;
import com.csis3275.model.DoctorMapper;




@Component
public class Doctorsdao {
	JdbcTemplate jdbcTemplate;
	private final String GET_ALL = "select * from Doctors";
	private final String INSERT_Doctor = "insert into Doctors(id, firstName,lastName,email,password,sex,specialization) values(?,?,?,?,?,?,?)";
	 private final String FIND_Doctor = "select * from Doctors where id = ?";
	private final String SQL_UPDATE_Doctor = "UPDATE Doctors set  firstName = ?, lastName  = ? , email=? , password=? , sex=? , specialization=?   WHERE id = ?";
	private final String SQL_DELETE_Doctor = "DELETE FROM Doctors WHERE id = ?";
	
	@Autowired
	public Doctorsdao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public Doctor getDoctorById(int id) {
		return jdbcTemplate.queryForObject(FIND_Doctor, new Object[] { id }, new DoctorMapper());
	}
	
	public List<Doctor> getAllDoctors() {
		return jdbcTemplate.query(GET_ALL, new DoctorMapper());
	}
	public boolean createNewDoctor(Doctor doct) {
		return jdbcTemplate.update(INSERT_Doctor, doct.getId(),doct.getFirstName(), doct.getLastName(),
				doct.getEmail(), doct.getPassword(),doct.getSex() ,doct.getSpecialization()) > 0;
	}
	
	public boolean updateDoctor(Doctor doctor) {
		return jdbcTemplate.update(SQL_UPDATE_Doctor, doctor.getId(), doctor.getFirstName(), doctor.getLastName(),
				doctor.getEmail(),doctor.getPassword(), doctor.getSex(), doctor.getSpecialization()) > 0;
	}
	public boolean deleteDoctor(int idToDelete) {
		return jdbcTemplate.update(SQL_DELETE_Doctor, idToDelete) > 0;
	}
	
	public boolean authenticateDoctor(String doctName, String password) {
		try {
			String DoctorNameDB = (String) jdbcTemplate.queryForObject(
					"SELECT email FROM Doctors WHERE email =" + "'" + doctName + "'", new Object[] {},
					String.class);
			String passwordDB = (String) jdbcTemplate.queryForObject(
					"SELECT TOP 1 password FROM Doctors WHERE password =" + "'" + password + "'",
					new Object[] {}, String.class);
			if (doctName.equals(DoctorNameDB) && password.equals(passwordDB)) {
				return true;
			} else {
				return false;
			}
		} catch (EmptyResultDataAccessException e) {
			e.printStackTrace();
		}
		return false;

	}
}
