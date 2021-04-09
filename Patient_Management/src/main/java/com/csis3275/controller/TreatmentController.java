package com.csis3275.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import com.csis3275.dao.treatmentdao;

import com.csis3275.model.treatment;
@Controller
public class TreatmentController {
	@Autowired
	treatmentdao treatmentDaoImpl;

	@ModelAttribute("treats")
	public treatment setupAddForm() {
		return new treatment();
	}
	

	@GetMapping("/treatment")
	public String Treatment(HttpSession session, Model model) {
		List<treatment> treat = treatmentDaoImpl.getAllTreatment();
		model.addAttribute("treat", treat);
		return "Treatment";
	}

	@PostMapping("/treatment")
	public String createNewTreatment(@ModelAttribute("treats") treatment treat,Model model) {

		treatmentDaoImpl.createNewTreatment(treat);
		List<treatment> treat1 = treatmentDaoImpl.getAllTreatment();
		model.addAttribute("treat", treat1);
		

		return "successTreat";
	}
// Thats a GET request from the browser to the URL below
@GetMapping("/showtreatment")
public String showTreatment(HttpSession session, Model model) {
	
	List<treatment> treat1 = treatmentDaoImpl.getAllTreatment();

	model.addAttribute("TreatList", treat1);

	return "showTreatment";
}

// Handle Form Post
@PostMapping("/showtreatment")
public String createTreatment(@ModelAttribute("treats") treatment treat, Model model) {

	
	treatmentDaoImpl.createNewTreatment(treat);

	List<treatment> treat1 = treatmentDaoImpl.getAllTreatment();
	model.addAttribute("TreatList", treat1);

	return "showTreatment";
}


}
