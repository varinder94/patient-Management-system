package com.csis3275.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.csis3275.model.Registration;
import com.csis3275.model.RegistrationMapper;

@Component
public class Registrationdao {
	static JdbcTemplate jdbcTemplate;
	private final String SQL_GET_ALL = "select * from PATIENTREGISTRATION";
	private final String SQL_INSERT_Patient = "insert into PATIENTREGISTRATION(firstname, lastname,email,password,sex,birthDay,telephone,id) values(?,?,?,?,?,?,?,?)";
	 private final String FIND_Patient = "select * from PATIENTREGISTRATION where id = ?";
	private final String SQL_UPDATE_Patient = "UPDATE PATIENTREGISTRATION set  firstname = ?, lastname  = ? , email=? , password=? , sex=? , birthDay=? , telephone=?  WHERE id = ?";
	private final String SQL_DELETE_patient = "DELETE FROM PATIENTREGISTRATION WHERE id = ?";
	
	@Autowired
	public Registrationdao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	

	public Registration getPatientById(int id) {
		return jdbcTemplate.queryForObject(FIND_Patient, new Object[] { id }, new RegistrationMapper());
	}
	
	public List<Registration> getAllPatient() {
		return jdbcTemplate.query(SQL_GET_ALL, new RegistrationMapper());
	}

	public boolean createNewPatient(Registration patient) {
		return jdbcTemplate.update(SQL_INSERT_Patient, patient.getFirstname(), patient.getLastname(),
				patient.getEmail(), patient.getPassword(), patient.getSex(), patient.getBirthDay(),
				patient.getTelephone(), patient.getId()) > 0;
	}

	public boolean updatePatient(Registration patient) {
		return jdbcTemplate.update(SQL_UPDATE_Patient, patient.getFirstname(), patient.getLastname(),
				patient.getEmail(),patient.getPassword(), patient.getSex(), patient.getBirthDay(),
				patient.getTelephone(), patient.getId()) > 0;
	}

	public boolean deletePatient(int idToDelete) {
		return jdbcTemplate.update(SQL_DELETE_patient, idToDelete) > 0;
	}

	public boolean authenticatePatient(String userName, String password) {
		try {
			String userNameDB = (String) jdbcTemplate.queryForObject(
					"SELECT email FROM PATIENTREGISTRATION WHERE email =" + "'" + userName + "'", new Object[] {},
					String.class);
			String passwordDB = (String) jdbcTemplate.queryForObject(
					"SELECT TOP 1 password FROM PATIENTREGISTRATION WHERE password =" + "'" + password + "'",
					new Object[] {}, String.class);
			if (userName.equals(userNameDB) && password.equals(passwordDB)) {
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
