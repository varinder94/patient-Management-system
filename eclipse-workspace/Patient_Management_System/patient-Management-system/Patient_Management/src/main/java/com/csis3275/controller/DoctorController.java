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
	
	@GetMapping("/doctorLogin")
	public String init(Model admin) {
		admin.addAttribute("msg", "Please Enter Your Login Details");
		return "DoctorLogin";
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
				return "DoctorLogin";
			}

		} else {
			model.addAttribute("error", "Please enter Details");
			return "DoctorLogin";
		}

	}
	
	@ModelAttribute("doctor")
	public Doctor setupAddForm() {
		return new Doctor();
	}
	// Thats a GET request from the browser to the URL below
		@GetMapping("/showDoctors")
		public String showDoctors(HttpSession session, Model model) {
			// Get a list of students from the controller
			List<Doctor> doct = doctorDaoImpl.getAllDoctors();

			// Add the results to the model
			model.addAttribute("doctList", doct);
			return "showDoctors";
		}

		// Handle Form Post
		@PostMapping("/showDoctors")
		public String createPatient(@ModelAttribute("doctor") Doctor createDoctor, Model model) {

			// Create the student pass the object in.
			doctorDaoImpl.createNewDoctor(createDoctor);

			// Get a list of students from the controller
			List<Doctor> doct = doctorDaoImpl.getAllDoctors();
			model.addAttribute("doctList", doct);

			return "showDoctors";
		}

		// Get the student and display the form
		@GetMapping("/deleteDoctors")
		public String deletePatient(@RequestParam(required = true) int id, Model model) {

			// Get the student
			doctorDaoImpl.deleteDoctor(id);

			// Get a list of students from the controller
			List<Doctor> doct = doctorDaoImpl.getAllDoctors();
			model.addAttribute("doctList", doct);

			model.addAttribute("message", "Deleted Patient: " + id);

			return "showDoctors";
		}
		
		//Get the student and display the form
			@GetMapping("/editDoctors")
			public String editPatient(@RequestParam(required = true) int id, Model model)	{
						
				//Get the student
				Doctor updatedDoct = doctorDaoImpl.getDoctorById(id);
				model.addAttribute("doctor", updatedDoct);
				
				return "editDoctors";
			}
			
			@PostMapping("/editDoctors")
			public String updateStudent(@ModelAttribute("doctor") Doctor  updatedPatient, Model model)	{
				
				doctorDaoImpl.updateDoctor(updatedPatient);
				
				//Get a list of students from the controller
				List<Doctor> doctors = doctorDaoImpl.getAllDoctors();
				model.addAttribute("doctor", doctors);
			
				model.addAttribute("message","Edited Student " + updatedPatient.getId());
				
				//We are redirecting to show students so that the GETMapping is executed again because our edit did not add the list of students to the model
				return "editDoctors";
				
			}
			
			
			
			
    
	
}
