package com.csis3275.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.csis3275.dao.Bookingdao;
import com.csis3275.dao.Doctorsdao;
import com.csis3275.dao.FileUploadInDb;
import com.csis3275.dao.Managementdao;
import com.csis3275.dao.Registrationdao;
import com.csis3275.dao.feedbackdao;
import com.csis3275.dao.treatmentdao;
import com.csis3275.model.AdminLogin;
import com.csis3275.model.Booking;
import com.csis3275.model.Doctor;
import com.csis3275.model.FileUpload;
import com.csis3275.model.Registration;
import com.csis3275.model.feedback;
import com.csis3275.model.treatment;

class DaoClassTest {

	private DriverManagerDataSource datasource;
	private Registrationdao regDao;
	private Bookingdao bookdao;
	private Doctorsdao doctdao;
	private feedbackdao feeddao;
	private FileUploadInDb fDb;
	private Managementdao managedao;
	private treatmentdao treatdao;
	
	@Test
	void TestSave() {
		datasource = new DriverManagerDataSource();
		datasource.setUrl("jdbc:h2:tcp://localhost/~/test");
		datasource.setUsername("sa");
		datasource.setPassword("");
		datasource.setDriverClassName("org.h2.Driver");
		regDao=new Registrationdao(datasource);
		
		//Registration Dao
		
		Registration reg=new Registration();
		reg.setFirstname("Varinder");
		reg.setLastname("Kaur");
		reg.setEmail("vk@gmail.com");
		reg.setSex("female");
		reg.setPassword("vk@22");
		reg.setTelephone("2363332483");
		reg.setId(0);
		boolean result=regDao.authenticatePatient("vk@gmail.com","vk@22");
		regDao.getPatientById(4537);
		regDao.updatePatient(reg);
		regDao.createNewPatient(reg);
		regDao.deletePatient(0);
		regDao.getAllPatient();
		
		//Booking Dao
		 bookdao=new Bookingdao(datasource);
		Booking book =new Booking();
		book.setDateP(null);
		book.setFile(null);
		book.setId(100);
		book.setDoctor("Me.singh");
		book.setTimeP("15.:30");
		book.setName("punia");
		
		book.setLast("kaur");
		bookdao.getAllBooking();
		bookdao.createNewBooking(book);
		bookdao.deleteBooking(100);
		
		
		
		
		//Doctorsdao
		doctdao=new Doctorsdao(datasource);
		Doctor doct =new Doctor();
	doct.setEmail("harmail@gmail.com");
	doct.setFirstName("harmail");
	doct.setId(8);
	doct.setLastName("singh");
	doct.setPassword("vk@43");
	doct.setSex("male");
	doct.setSpecialization("brain");
	doctdao.authenticateDoctor("harmail@gmail.com", "vk@43");
	doctdao.createNewDoctor(doct);
	doctdao.getDoctorById(8);
	doctdao.deleteDoctor(8);
	doctdao.getAllDoctors();
	
	
		
		
		
		//feedbackdao
		feeddao=new feedbackdao(datasource);
		feedback feed=new feedback();
		feed.setDoctor("varinder");
		feed.setExperience("high");
		feed.setGoodPoint("time management");
		feed.setLast("kaur");
		feed.setRating(1);
		feed.setSuggestions("upgrade system");
		feed.setName("akwinder");
		feeddao.getAllFeedback();
		feeddao.createNewFeedback(feed);
		feeddao.deleteFeedback(1);
		
		
		//FileUploadInDb
		
		fDb=new FileUploadInDb(datasource);
		FileUpload fupload=new FileUpload();
		fupload.setFileDescription("new file");
		fupload.setFileName("medical history");
		fupload.setData(null);
		fupload.setId(21);
		FileUploadInDb.fileSaveInDb(fupload);
		fDb.deleteFeedback(21);
		
		
		
		//Managementdao
		managedao=new Managementdao(datasource);
		AdminLogin adLog=new AdminLogin();
		adLog.setAdminemail("akpunia6@gmail.com");
		adLog.setAdminPaddword("punia_6");
		managedao.authenticateAdmin("akpunia6@gmail.com","punia_6");
		
		
		//TreatmentDao
		treatdao=new treatmentdao(datasource);
		treatment treat=new treatment();
		treat.setMedicinedoses(15);
		treat.setPatientAlleries("Dust");
		treat.setPatientFirstName("deep");
		treat.setPatientLastName("sidhu");
		treat.setPatientMedicine("Tylenol");
		treat.setSpecialNote("Rest Needed");
		treatdao.getAllTreatment();
		treatdao.createNewTreatment(treat);
		treatdao.deleteTreatment(15);
		
	
		
		
	}

}
