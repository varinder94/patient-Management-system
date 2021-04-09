package com.csis3275.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class Managementdao {
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	public Managementdao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	public boolean authenticateAdmin(String adminName,String password)
    {try {
        String adminNameDB = (String) jdbcTemplate.queryForObject(
       		 "SELECT email FROM Management WHERE email ="+"'"+adminName+"'", new Object[] {}, String.class);
        String passwordDB = (String) jdbcTemplate.queryForObject(
       		 "SELECT TOP 1 password FROM Management WHERE password ="+"'"+password+"'", new Object[] {}, String.class);
        if(adminName.equals(adminNameDB) && password.equals(passwordDB)){
		      return true;
		      }
		   else {
            return false;}}
        catch (EmptyResultDataAccessException e) {
               e.printStackTrace();
           }
    return false;
       
    }
}
