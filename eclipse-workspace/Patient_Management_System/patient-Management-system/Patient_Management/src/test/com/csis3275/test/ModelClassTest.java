package com.csis3275.test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.ResultSet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.csis3275.model.AdminLogin;
import com.csis3275.model.Booking;
import com.csis3275.model.BookingMapper;
import com.csis3275.model.BookingOrder;
import com.csis3275.model.Doctor;
import com.csis3275.model.DoctorMapper;
import com.csis3275.model.FeedbackMapper;
import com.csis3275.model.FileUpload;
import com.csis3275.model.LoginP;
import com.csis3275.model.Registration;
import com.csis3275.model.RegistrationMapper;
import com.csis3275.model.TreatmentMapper;
import com.csis3275.model.feedback;
import com.csis3275.model.treatment;

class ModelClassTest {
	Booking book = new Booking();
	BookingOrder bookOrder = new BookingOrder();
	Doctor doct = new Doctor();
	treatment treat = new treatment();
	feedback feed = new feedback();
	Registration register = new Registration();
	FileUpload file = new FileUpload();
	AdminLogin login = new AdminLogin();
	LoginP loginp = new LoginP();

	@BeforeEach
	void setup() throws Exception {
		book.setDateP(null);
		book.setFile(null);
		book.setDoctor("varinder");
		book.setId(5);
		book.setLast("kaur");
		book.setName("akwinder");
		book.setTimeP("5:16");

	}

	@BeforeEach
	void setup1() throws Exception {
		bookOrder.getProductName();
		bookOrder.getSubtotal();
		bookOrder.getTax();
		bookOrder.getTotal();
		bookOrder = new BookingOrder("booking", "100", "15", "115");

	}

	@BeforeEach
	void setup2() throws Exception {
		doct.setFirstName("Akwinder");
		doct.setLastName("kaur");
		doct.setEmail("punia6@gmail.com");
		doct.setId(0);
		doct.setPassword("vk@4567");
		doct.setSex("female");
		doct.setSpecialization("heart");

	}

	@BeforeEach
	void setup3() throws Exception {
		treat.setMedicinedoses(3);
		treat.setPatientAlleries("nuts");
		treat.setPatientFirstName("varinder");
		treat.setPatientLastName("kaur");
		treat.setPatientLastName("kaur");
		treat.setPatientMedicine("tyelonol");
		treat.setSpecialNote("take rest");
	}

	@BeforeEach
	void setup4() throws Exception {
		feed.setDoctor("akwinder");
		feed.setExperience("good");
		feed.setGoodPoint("communication");
		feed.setLast("kaur");
		feed.setName("varinder");
		feed.setRating(2);
		feed.setSuggestions("imporove time slots");
	}

	@BeforeEach
	void setup5() throws Exception {
		register.setFirstname("varinder");
		register.setLastname("kaur");
		register.setId(1);
		register.setPassword("vk@2265");
		register.setSex("female");
		register.setTelephone("2363332546");
		register.setEmail("vk@gmail.com");
		register.setBirthDay(null);

	}

	@BeforeEach
	void setup6() throws Exception {
		file = new FileUpload();
		file.setFileDescription("Booking");
		file.setFileName("Medical History");
		file.setData(null);
		file.setId(5);

	}
	@BeforeEach
	  void setup7() throws Exception{
	  	login = new AdminLogin();
	  	login.setAdminemail("varinderkaur671@gmail.com");
	  	login.setAdminPaddword("2356&Hs");
	  }
	  @BeforeEach
	  void setup8() throws Exception{
	  	loginp = new LoginP();
	  	loginp.setUserName("@kwinder");
	  	loginp.setPassword("akPunia6");
	  }


	@Test
	public void getDateP() {
		assertEquals(null, book.getDateP());

	}

	@Test
	public void getFileDescription() {
		assertEquals(null, book.getFile());

	}

	@Test
	public void getDoctor() {
		assertEquals("varinder", book.getDoctor());

	}

	@Test
	public void getId11() {
		assertEquals(5, book.getId());

	}

	@Test
	public void getLast() {
		assertEquals("kaur", book.getLast());

	}

	@Test
	public void getName() {
		assertEquals("akwinder", book.getName());

	}

	@Test
	public void getTimeP() {
		assertEquals("5:16", book.getTimeP());

	}

	@Test
	public void getProductName() {
		assertEquals("booking", bookOrder.getProductName());

	}

	@Test
	public void getId() {
		assertEquals(0, doct.getId());

	}

	@Test
	public void getFirstName() {
		assertEquals("Akwinder", doct.getFirstName());

	}

	@Test
	public void getLastName() {
		assertEquals("kaur", doct.getLastName());

	}

	@Test
	public void getEmail() {
		assertEquals("punia6@gmail.com", doct.getEmail());

	}

	@Test
	public void getSpecialization() {
		assertEquals("heart", doct.getSpecialization());

	}

	@Test
	public void getSex() {
		assertEquals("female", doct.getSex());

	}

	@Test
	public void getPassword() {
		assertEquals("vk@4567", doct.getPassword());

	}

	@Test
	public void getMedicinedoses() {
		assertEquals(3, treat.getMedicinedoses());

	}

	@Test
	public void getPatientAlleries() {
		assertEquals("nuts", treat.getPatientAlleries());

	}

	@Test
	public void getPatientFirstName() {
		assertEquals("varinder", treat.getPatientFirstName());

	}

	@Test
	public void getPatientLastName() {
		assertEquals("kaur", treat.getPatientLastName());

	}

	@Test
	public void getPatientMedicine() {
		assertEquals("tyelonol", treat.getPatientMedicine());

	}

	@Test
	public void getSpecialNote() {
		assertEquals("take rest", treat.getSpecialNote());

	}

	@Test
	public void getDoctor1() {
		assertEquals("akwinder", feed.getDoctor());

	}

	@Test
	public void getExperience() {
		assertEquals("good", feed.getExperience());

	}

	@Test
	public void getGoodPoint() {
		assertEquals("communication", feed.getGoodPoint());

	}

	@Test
	public void getLast1() {
		assertEquals("kaur", feed.getLast());

	}

	@Test
	public void getName1() {
		assertEquals("varinder", feed.getName());

	}

	@Test
	public void getRating() {
		assertEquals(2, feed.getRating());

	}

	@Test
	public void getSuggestions() {
		assertEquals("imporove time slots", feed.getSuggestions());

	}

	@Test
	public void getId1() {
		assertEquals(1, register.getId());

	}

	@Test
	public void getFirstname() {
		assertEquals("varinder", register.getFirstname());

	}

	@Test
	public void getLastname() {
		assertEquals("kaur", register.getLastname());

	}

	@Test
	public void getBirthDay() {
		assertEquals(null, register.getBirthDay());

	}

	@Test
	public void getPassword1() {
		assertEquals("vk@2265", register.getPassword());

	}

	@Test
	public void getEmail1() {
		assertEquals("vk@gmail.com", register.getEmail());

	}

	@Test
	public void getSex1() {
		assertEquals("female", register.getSex());

	}

	@Test
	public void getTelephone() {
		assertEquals("2363332546", register.getTelephone());

	}

	// File upload model class Testing

	@Test
	public void getFileDescription1() {
		assertEquals("Booking", file.getFileDescription());

	}

	@Test
	public void getData() {
		assertEquals(null, file.getData());

	}
	
	@Test
	public void getId6() {
		assertEquals(5, file.getId());

	}

	@Test
	public void getFileName() {
		assertEquals("Medical History", file.getFileName());

	}
	//admin class
	
	@Test
	  public void getAdminemail() {
	  	assertEquals("varinderkaur671@gmail.com",login.getAdminemail());		
	  }
	  @Test
	  public void getAdminPaddword() {
	  	assertEquals("2356&Hs",login.getAdminPaddword());		
	  }

	//login class
	  @Test
	  public void getUserName() {
	  	assertEquals("@kwinder",loginp.getUserName());		
	  }
	  @Test
	  public void getPassword11() {
	  	assertEquals("akPunia6",loginp.getPassword());		
	  }
	  BookingMapper bookMap=new BookingMapper();
	  DoctorMapper doctor=new DoctorMapper();
	  FeedbackMapper feedback=new FeedbackMapper();
	  RegistrationMapper reg=new RegistrationMapper();
	  TreatmentMapper treatment=new TreatmentMapper();
	  ResultSet rs; int rowNum;
	  @BeforeEach
	  void setup9() throws Exception{
		  
		  bookMap= new BookingMapper();
		
	  }


}
