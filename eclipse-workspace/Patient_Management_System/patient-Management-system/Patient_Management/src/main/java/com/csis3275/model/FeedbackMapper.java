package com.csis3275.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class FeedbackMapper implements RowMapper<feedback>{

	@Override
	public feedback mapRow(ResultSet rs, int rowNum) throws SQLException {
		feedback feed=new feedback();
		feed.setName(rs.getString("name"));
		feed.setLast(rs.getString("last"));
		feed.setDoctor(rs.getString("doctor"));
		feed.setExperience(rs.getString("experience"));
		feed.setGoodPoint(rs.getString("goodPoint"));
		feed.setRating(rs.getInt("rating"));
		feed.setSuggestions(rs.getString("suggestions"));
		return feed;
	}

}
