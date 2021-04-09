package com.csis3275.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.csis3275.model.FeedbackMapper;
import com.csis3275.model.feedback;

@Component
public class feedbackdao {
	JdbcTemplate jdbcTemplate;
	private final String GET_ALL = "select * from feedback";
	private final String SQL_DELETE_feed = "DELETE FROM feedback WHERE rating = ?";

	private final String INSERT_feedback = "insert into feedback(name, last,doctor,goodPoint,rating,experience,suggestions) values(?,?,?,?,?,?,?)";
	@Autowired
	public feedbackdao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	public List<feedback> getAllFeedback() {
		return jdbcTemplate.query(GET_ALL, new FeedbackMapper());
	}
	public boolean createNewFeedback(feedback feed) {
		return jdbcTemplate.update(INSERT_feedback,feed.getName(),feed.getLast(),feed.getDoctor(),feed.getGoodPoint(),
				feed.getRating(),feed.getExperience(),feed.getSuggestions()) > 0;
	}
	public boolean deleteFeedback(int idToDelete) {
		return jdbcTemplate.update(SQL_DELETE_feed, idToDelete) > 0;
	}

}
