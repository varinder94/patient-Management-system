package com.csis3275.test;

import static org.junit.jupiter.api.Assertions.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.csis3275.controller.AdminController;
import com.csis3275.controller.BookingController;
import com.csis3275.controller.DoctorController;
import com.csis3275.controller.FeedbackController;
import com.csis3275.controller.PaymentController;
import com.csis3275.model.FileUpload;
import com.csis3275.model.Registration;
import com.csis3275.model.treatment;
import com.csis3275.servlets.AuthorizePaymentServlet;
import com.csis3275.servlets.ExecutePaymentServlet;
import com.csis3275.servlets.PaymentServices;
import com.csis3275.servlets.ReviewPaymentServlet;
import com.paypal.api.payments.Amount;
import com.paypal.api.payments.Payer;
import com.paypal.api.payments.PayerInfo;

class ServletTesting {

	PaymentController payment = new PaymentController();
	AdminController adCon = new AdminController();
	BookingController bookCon = new BookingController();
	DoctorController DocCon = new DoctorController();
	FeedbackController FeedCon = new FeedbackController();
	FileUpload feedUp = new FileUpload();
	Registration reg = new Registration();
	treatment treatCon = new treatment();
	HttpServletRequest request;
	HttpServletResponse response;
	@Autowired
	private MockMvc mockMvc;
	
	
	Payer payer = new Payer();
	PayerInfo payerInfo = new PayerInfo();
	Amount amount = new Amount();
	AuthorizePaymentServlet AuPay = new AuthorizePaymentServlet();
	ExecutePaymentServlet exPay = new ExecutePaymentServlet();
	PaymentServices paySer = new PaymentServices();
	ReviewPaymentServlet rePay = new ReviewPaymentServlet();

	@BeforeEach
	void setup() throws Exception {
		payer.setPaymentMethod("paypal");
		PayerInfo b = payer.getPayerInfo();
		payerInfo.setFirstName(null).setLastName("Peterson").setEmail("william.peterson@company.com");
		amount.setCurrency("USD");

	}

	@Test
	void test()  {
		assertEquals("paypal", payer.getPaymentMethod());
		assertEquals(null,payerInfo.getFirstName());
		assertEquals("USD",amount.getCurrency());
		assertEquals(null,payer.getPayerInfo());
		
//  AuPay.equals(AuPay);
//  exPay.getServletInfo();
		
		  
	
			
	}
	
}
