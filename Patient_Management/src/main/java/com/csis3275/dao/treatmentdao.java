package com.csis3275.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;


import com.csis3275.model.TreatmentMapper;
import com.csis3275.model.treatment;

@Component
public class treatmentdao {
	JdbcTemplate jdbcTemplate;
	private final String GET_ALL = "select * from treatment";

	private final String INSERT_treatment = "insert into treatment(patientFirstName, patientLastName,patientMedicine,patientAlleries,medicinedoses,specialNote) values(?,?,?,?,?,?)";
	private final String SQL_DELETE_Treatment = "DELETE FROM treatment WHERE medicinedoses = ?";
	
	@Autowired
	public treatmentdao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	public List<treatment> getAllTreatment() {
		return jdbcTemplate.query(GET_ALL, new TreatmentMapper());
	}
	public boolean createNewTreatment(treatment treat) {
		return jdbcTemplate.update(INSERT_treatment, treat.getPatientFirstName(),treat.getPatientLastName(),treat.getPatientMedicine(),treat.getPatientAlleries(),
				treat.getMedicinedoses(),treat.getSpecialNote()) > 0;
	}
	public boolean deleteTreatment(int idToDelete) {
		return jdbcTemplate.update(SQL_DELETE_Treatment, idToDelete) > 0;
	}

}
