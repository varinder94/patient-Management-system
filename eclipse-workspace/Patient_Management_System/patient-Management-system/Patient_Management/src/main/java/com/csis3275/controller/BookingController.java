package com.csis3275.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.csis3275.dao.Bookingdao;
import com.csis3275.model.Booking;



@Controller
public class BookingController {
	
	@Autowired
	Bookingdao bookingDaoImpl;
	
	@ModelAttribute("books")
	public Booking setupAddForm() {
		return new Booking();
	}
	
	@GetMapping("/booking")
	public String showbooking(HttpSession session, Model model) {
		List<Booking> book = bookingDaoImpl.getAllBooking();
		model.addAttribute("book", book);
		return "upload";
	}

	@PostMapping("/booking")
	public String createNewBooking(@ModelAttribute("books") Booking newBooking, Model model) {

		bookingDaoImpl.createNewBooking(newBooking);
		List<Booking> book = bookingDaoImpl.getAllBooking();
		model.addAttribute("book", book);

		return "successFile";
	}



}
