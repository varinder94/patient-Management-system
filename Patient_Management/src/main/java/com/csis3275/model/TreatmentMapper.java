package com.csis3275.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class TreatmentMapper implements RowMapper<treatment> {

	@Override
	public treatment mapRow(ResultSet rs, int rowNum) throws SQLException {
	
		treatment treat=new treatment();
		treat.setPatientFirstName(rs.getString("patientFirstName"));
		treat.setPatientLastName(rs.getString("patientLastName"));
		treat.setPatientMedicine(rs.getString("patientMedicine"));
		treat.setPatientAlleries(rs.getString("patientAlleries"));
		treat.setMedicinedoses(rs.getInt("medicinedoses"));
		treat.setSpecialNote(rs.getString("SpecialNote"));
		return treat;
	}

}
