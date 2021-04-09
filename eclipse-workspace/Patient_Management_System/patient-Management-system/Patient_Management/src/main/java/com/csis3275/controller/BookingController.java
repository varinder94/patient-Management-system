package com.csis3275.controller;


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
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
	public String createNewBooking(@ModelAttribute("books") Booking newBooking,Model model) {

		
		bookingDaoImpl.createNewBooking(newBooking);
		List<Booking> book = bookingDaoImpl.getAllBooking();
		model.addAttribute("book", book);
		
	
				return "successFile";
			}
	// Thats a GET request from the browser to the URL below
		@GetMapping("/showBooking")
		public String showBooking(HttpSession session, Model model) {
			// Get a list of Booking from the controller
			List<Booking> book = bookingDaoImpl.getAllBooking();

			// Add the results to the model
			model.addAttribute("bookList", book);

			return "showBooking";
		}

		// Handle Form Post
		@PostMapping("/showBooking")
		public String createBooking(@ModelAttribute("books") Booking createBooking, Model model) {

			// bookingDaoImpl the booking pass the object in.
			bookingDaoImpl.createNewBooking(createBooking);

			// Get a list of Booking from the controller
			List<Booking> book = bookingDaoImpl.getAllBooking();
			model.addAttribute("bookList", book);

			return "showBooking";
		}
		private static final String FILE_PATH1 = "C://Users//varin//Desktop//doctorIcon.png";
		@GetMapping("/download1")
		   public void downloadFile(HttpServletResponse resonse) throws IOException {
		      File file = new File(FILE_PATH1);

		      resonse.setContentType("application/pdf");
		      resonse.setHeader("Content-Disposition", "attachment;filename=" + file.getName());
		      BufferedInputStream inStrem = new BufferedInputStream(new FileInputStream(file));
		      BufferedOutputStream outStream = new BufferedOutputStream(resonse.getOutputStream());
		      
		      byte[] buffer = new byte[1024];
		      int bytesRead = 0;
		      while ((bytesRead = inStrem.read(buffer)) != -1) {
		        outStream.write(buffer, 0, bytesRead);
		      }
		      outStream.flush();
		      inStrem.close();
		   }
		private static final String FILE_PATH = "C://Users//varin//Desktop//Tax Documents/T4_2020_1.pdf";
		@GetMapping("/download")
		   public void downloadFile3(HttpServletResponse resonse) throws IOException {
		      File file = new File(FILE_PATH);

		      resonse.setContentType("application/pdf");
		      resonse.setHeader("Content-Disposition", "attachment;filename=" + file.getName());
		      BufferedInputStream inStrem = new BufferedInputStream(new FileInputStream(file));
		      BufferedOutputStream outStream = new BufferedOutputStream(resonse.getOutputStream());
		      
		      byte[] buffer = new byte[1024];
		      int bytesRead = 0;
		      while ((bytesRead = inStrem.read(buffer)) != -1) {
		        outStream.write(buffer, 0, bytesRead);
		      }
		      outStream.flush();
		      inStrem.close();
		   }
		
}

