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
	
	
	//Patient Operations in admin deshboard
	
	@Autowired
	Registrationdao patientDaoImpl;

	@ModelAttribute("patients")
	public Registration setupAddForm() {
		return new Registration();
	}
	
	
	
	
	@GetMapping("/showPatient")
	public String showPatients(HttpSession session, Model model) {
		
		List<Registration> patient = patientDaoImpl.getAllPatient();

		
		model.addAttribute("PatientList", patient);
		return "showPatients";
	}

	// Handle Form Post
	@PostMapping("/showPatient")
	public String createPatient(@ModelAttribute("patients") Registration createPatient, Model model) {

	
		patientDaoImpl.createNewPatient(createPatient);

		List<Registration> patient = patientDaoImpl.getAllPatient();
		model.addAttribute("PatientList", patient);

		return "showPatients";
	}


	@GetMapping("/deletePatient")
	public String deletePatient(@RequestParam(required = true) int id, Model model) {

	
		patientDaoImpl.deletePatient(id);


		List<Registration> patient = patientDaoImpl.getAllPatient();
		model.addAttribute("PatientList", patient);

		model.addAttribute("message", "Deleted Patient: " + id);

		return "showPatients";
	}
	
	
		@GetMapping("/editPatient")
		public String editPatient(@RequestParam(required = true) int id, Model model)	{
					
			
			Registration updatePatient = patientDaoImpl.getPatientById(id);
			model.addAttribute("patient", updatePatient);
			
			return "editPatient";
		}
		
		@PostMapping("/editPatient")
		public String updatePatient(@ModelAttribute("patients") Registration  updatedPatient, Model model)	{
			
			patientDaoImpl.updatePatient(updatedPatient);
			
			
			List<Registration> Patients = patientDaoImpl.getAllPatient();
			model.addAttribute("patient", Patients);
		
			model.addAttribute("message","Edited Patient " + updatedPatient.getId());
			
			
			return "showPatients";
			
		}
		

	

}
