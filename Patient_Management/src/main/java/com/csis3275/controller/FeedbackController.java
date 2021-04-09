package com.csis3275.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.csis3275.dao.feedbackdao;

import com.csis3275.model.feedback;

@Controller
public class FeedbackController {
	@Autowired
	feedbackdao feedbackDaoImpl;
	@ModelAttribute("feeds")
	public feedback setupAddForm() {
		return new feedback();
	}
	

	@GetMapping("/feedback")
	public String showFeedback(HttpSession session, Model model) {
		List<feedback> feed = feedbackDaoImpl.getAllFeedback();
		model.addAttribute("feed", feed);
		return "feedBack";
	}

	@PostMapping("/feedback")
	public String createNewFeedback(@ModelAttribute("feeds") feedback feed,Model model) {

		feedbackDaoImpl.createNewFeedback(feed);
		List<feedback> feed1 = feedbackDaoImpl.getAllFeedback();
	
		model.addAttribute("feed", feed1);
		
	
				return "ResponseFeedback";
			}
	
	@GetMapping("/showfeedback")
	public String showFeedBack(HttpSession session, Model model) {
		
		List<feedback>feed = feedbackDaoImpl.getAllFeedback();

		model.addAttribute("feedList", feed);

		return "showFeedback";
	}

	// Handle Form Post
	@PostMapping("/showfeedback")
	public String createBooking(@ModelAttribute("feeds") feedback feed, Model model) {

		
		feedbackDaoImpl.createNewFeedback(feed);

		List<feedback> feed1 = feedbackDaoImpl.getAllFeedback();
		model.addAttribute("feedList", feed1);

		return "showFeedback";
	}


}
