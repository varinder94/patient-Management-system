package com.csis3275.controller;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.csis3275.dao.Doctorsdao;
import com.csis3275.model.Doctor;





@Controller
public class DoctorController {
	@Autowired
	Doctorsdao doctorDaoImpl;
	
	@ModelAttribute("doctor")
	public Doctor setupAddForm() {
		return new Doctor();
	}
	
	@GetMapping("/doctorLogin")
	public String init(Model admin) {
		admin.addAttribute("msg", "Please Enter Your Login Details");
		return "doctorLogin";
	}
	
	@PostMapping("/doctorLogin")
	public String submit(@ModelAttribute("doctor") Doctor doctors, Model model) {

		if (doctors != null && doctors.getEmail() != null && doctors.getPassword() != null) {

			boolean doct = doctorDaoImpl.authenticateDoctor(doctors.getEmail(), doctors.getPassword());

			if (doct == true) {
				model.addAttribute("msg", doctors.getEmail());
				return "DoctorDesh";
			} else {
				model.addAttribute("error", "Invalid Details or user name is taken");
				return "doctorLogin";
			}

		} else {
			model.addAttribute("error", "Please enter Details");
			return "DoctorDesh";
		}

	}
	
	
	// Thats a GET request from the browser to the URL below
		@GetMapping("/showDoctors")
		public String showDoctors(HttpSession session, Model model) {
			
			List<Doctor> doct = doctorDaoImpl.getAllDoctors();

			model.addAttribute("doctList", doct);
			return "showDoctors";
		}

		// Handle Form Post
		@PostMapping("/showDoctors")
		public String createPatient(@ModelAttribute("doctor") Doctor createDoctor, Model model) {

		
			doctorDaoImpl.createNewDoctor(createDoctor);

			List<Doctor> doct = doctorDaoImpl.getAllDoctors();
			model.addAttribute("doctList", doct);

			return "showDoctors";
		}

		// Get the Doctor and display the form
		@GetMapping("/deleteDoctors")
		public String deletePatient(@RequestParam(required = true) int id, Model model) {

			doctorDaoImpl.deleteDoctor(id);

			List<Doctor> doct = doctorDaoImpl.getAllDoctors();
			model.addAttribute("doctList", doct);

			model.addAttribute("message", "Deleted Patient: " + id);

			return "showDoctors";
		}
		
		//Get the Doctor and display the form
			@GetMapping("/editDoctors")
			public String editPatient(@RequestParam(required = true) int id, Model model)	{
						
		
				Doctor updatedDoct = doctorDaoImpl.getDoctorById(id);
				model.addAttribute("doctor", updatedDoct);
				
				return "editDoctors";
			}
			
			@PostMapping("/editDoctors")
			public String updateStudent(@ModelAttribute("doctor") Doctor  updatedPatient, Model model)	{
				
				doctorDaoImpl.updateDoctor(updatedPatient);
				
	
				List<Doctor> doctors = doctorDaoImpl.getAllDoctors();
				model.addAttribute("doctor", doctors);
			
				model.addAttribute("message","Edited Student " + updatedPatient.getId());
				
				
				return "editDoctors";
				
			}
			
			
			
			
    
	
}
