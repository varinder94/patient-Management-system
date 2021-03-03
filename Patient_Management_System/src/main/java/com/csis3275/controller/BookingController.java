package com.csis3275.controller;

import java.util.List;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.csis3275.dao.Bookingdao;
import com.csis3275.model.Booking;

@Controller

public class BookingController {

	@Autowired
	Bookingdao bookingDao;

	@ModelAttribute("books")
	public Booking setupAddForm() {
		return new Booking();
	}

	@GetMapping("/booking")
	public String showBooking(HttpSession session, Model model) {
		List<Booking> Book = bookingDao.getAllBooking();
		model.addAttribute("booking", Book);
		return "upload";
	}

	@PostMapping("/booking")
	public String createNewBooking(Booking newBook, @RequestParam CommonsMultipartFile[] file, BindingResult result,
			Model model) {
		bookingDao.createNewBooking(newBook);
		List<Booking> Book = bookingDao.getAllBooking();

		model.addAttribute("booking", Book);
		
		model.addAttribute("success", "Dear  " + newBook.getName() + " , your appointment is booked successfully");
		return "successFile";
	}
//	
//	@RequestMapping(value = "/booking", method = RequestMethod.POST)
//    public String handleFileUpload(HttpServletRequest request,
//            @RequestParam CommonsMultipartFile[] file) throws Exception {
//          
//        if (file != null && file.length > 0) {
//            for (CommonsMultipartFile aFile : file){
//                  
//                System.out.println("Saving file: " + aFile.getOriginalFilename());
//                 
//                Booking newBook = new Booking();
//                newBook.setfName(aFile.getOriginalFilename());
//                newBook.setFile(aFile.getBytes());
//                              
//            }
//        }
//  
//        return "successFile";
//    }  

}
