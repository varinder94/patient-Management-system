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

import com.csis3275.dao.Managementdao;
import com.csis3275.dao.Registrationdao;
import com.csis3275.model.AdminLogin;
import com.csis3275.model.Registration;




@Controller
public class AdminController {
//for admin login and registration
	@Autowired
	Managementdao mangementdaoImpl;
	
	@GetMapping("/adminlogin")
	public String init(Model admin) {
		admin.addAttribute("msg", "Please Enter Your Login Details");
		return "AdminLogin";
	}

	@PostMapping("/adminlogin")
	public String submit(@ModelAttribute("admin") AdminLogin admin, Model model) {

		if (admin != null && admin.getAdminemail() != null && admin.getAdminPaddword() != null) {

			boolean patient = mangementdaoImpl.authenticateAdmin(admin.getAdminemail(), admin.getAdminPaddword());

			if (patient == true) {
				model.addAttribute("msg", admin.getAdminemail());
				return "AdminDesh";
			} else {
				model.addAttribute("error", "Invalid Details or user name is taken");
				return "AdminDesh";
			}

		} else {
			model.addAttribute("error", "Please enter Details");
			return "AdminLogin";
		}

	}
	@Autowired
	Registrationdao patientDaoImpl;
	// We need a blank Patient for the add form
	@ModelAttribute("patient")
	public Registration setupAddForm() {
		return new Registration();
	}
	// Thats a GET request from the browser to the URL below
		@GetMapping("/showStudents")
		public String showPatients(HttpSession session, Model model) {
			// Get a list of students from the controller
			List<Registration> patients = patientDaoImpl.getAllPatient();

			// Add the results to the model
			model.addAttribute("PatientList", patients);
			return "showPatients";
		}

		// Handle Form Post
		@PostMapping("/createPatient")
		public String createPatient(@ModelAttribute("patient") Registration createPatient, Model model) {

			// Create the student pass the object in.
			patientDaoImpl.createNewPatient(createPatient);

			// Get a list of students from the controller
			List<Registration> patients = patientDaoImpl.getAllPatient();
			model.addAttribute("patientList", patients);

			return "showPatients";
		}

		// Get the student and display the form
		@GetMapping("/deletePatient")
		public String deletePatient(@RequestParam(required = true) int id, Model model) {

			// Get the student
			patientDaoImpl.deletePatient(id);

			// Get a list of students from the controller
			List<Registration> patients = patientDaoImpl.getAllPatient();
			model.addAttribute("patientList", patients);

			model.addAttribute("message", "Deleted Patient: " + id);

			return "showPatients";
		}
		
		//Get the student and display the form
			@GetMapping("/editPatient")
			public String editPatient(@RequestParam(required = true) int id, Model model)	{
						
				//Get the student
				Registration updatePatient = patientDaoImpl.getPatientById(id);
				model.addAttribute("patient", updatePatient);
				
				return "editPatient";
			}
			
			@PostMapping("/editPatient")
			public String updateStudent(@ModelAttribute("patient") Registration  updatedPatient, Model model)	{
				
				patientDaoImpl.updatePatient(updatedPatient);
				
				//Get a list of students from the controller
				List<Registration> Patients = patientDaoImpl.getAllPatient();
				model.addAttribute("patient", Patients);
			
				model.addAttribute("message","Edited Student " + updatedPatient.getId());
				
				//We are redirecting to show students so that the GETMapping is executed again because our edit did not add the list of students to the model
				return "showPatients";
				
			}
			


}
