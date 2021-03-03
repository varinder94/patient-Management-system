package com.csis3275.controller;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.csis3275.dao.Registrationdao;

import com.csis3275.model.LoginP;
import com.csis3275.model.Registration;

@Controller
public class RegistrationController {

	@Autowired
	Registrationdao patientDaoImpl;

	@ModelAttribute("patients")
	public Registration setupAddForm() {
		return new Registration();
	}

	@RequestMapping("/main")
	public String home(ModelMap model) {
		Registration main = new Registration();
		model.addAttribute("main", main);
		return "MainPage";
	}

	@GetMapping("/register")
	public String showpatient(HttpSession session, Model model) {
		List<Registration> patient = patientDaoImpl.getAllPatient();
		model.addAttribute("patient", patient);
		return "PatientR";
	}

	@PostMapping("/register")
	public String createNewPatient(@ModelAttribute("patients") Registration newPatient, Model model) {

		patientDaoImpl.createNewPatient(newPatient);
		List<Registration> patient = patientDaoImpl.getAllPatient();
		model.addAttribute("patient", patient);

		return "Login";
	}

	@GetMapping("/patientlogin")
	public String init(Model patient) {
		patient.addAttribute("msg", "Please Enter Your Login Details");
		return "Login";
	}

	@PostMapping("/patientlogin")
	public String submit(@ModelAttribute("user") LoginP user, Model model) {

		if (user != null && user.getUserName() != null && user.getPassword() != null) {

			boolean patient = patientDaoImpl.authenticatePatient(user.getUserName(), user.getPassword());

			if (patient == true) {
				model.addAttribute("msg", user.getUserName());
				return "upload";
			} else {
				model.addAttribute("error", "Invalid Details or user name is taken");
				return "Login";
			}

		} else {
			model.addAttribute("error", "Please enter Details");
			return "Login";
		}

	}

	

	
	
	

}
