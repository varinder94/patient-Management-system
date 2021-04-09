package com.csis3275.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PaymentController {
	
	@GetMapping("/pay")
	public String init(Model pay) {
		pay.addAttribute("msg", "Please Pay the Dues");
		return "Checkout";
	}
	@GetMapping("/review")
	public String init2(Model pay) {
		pay.addAttribute("msg", "Please Review The Following Details");
		return "review";
	}

}
