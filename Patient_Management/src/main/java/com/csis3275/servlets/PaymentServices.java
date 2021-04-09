package com.csis3275.servlets;


import java.util.*;

import com.csis3275.model.BookingOrder;
import com.paypal.api.payments.*;
import com.paypal.base.rest.*;


public class PaymentServices {
    private static final String CLIENT_ID = "AbJXIQwE1YJ_mjnLp2hwk3XLh_vJqSa1ssGDe4BwK853zCcjCe_Av-NZbYA8MVUZw1aHVU0RC0doQcil";
    private static final String CLIENT_SECRET = "EOyjyyf4X2aG3Vlqz2uu6TwjkVv3r_CadhteQhUxafRfLtcNxD36QSuLMvTfydmLlcMO4Or2Kg5zhfjP";
    private static final String MODE = "sandbox";
 
    public String authorizePayment(BookingOrder orderDetail)        
            throws PayPalRESTException {       
 
        Payer payerDetail = getPayerInformation();
        RedirectUrls redirectUrlInfo = getRedirectURLs();
        List<Transaction> All_listTransaction = getTransactionInformation(orderDetail);
         
        Payment requestPayment_Detail = new Payment();
        requestPayment_Detail.setTransactions(All_listTransaction);
        requestPayment_Detail.setRedirectUrls(redirectUrlInfo);
        requestPayment_Detail.setPayer(payerDetail);
        requestPayment_Detail.setIntent("authorize");
 
        APIContext apiContext = new APIContext(CLIENT_ID, CLIENT_SECRET, MODE);
 
        Payment Payment_Approve = requestPayment_Detail.create(apiContext);
 
        return getApprovalLink(Payment_Approve);
 
    }
     
    private Payer getPayerInformation() {
    	Payer payerDetail = new Payer();
    	payerDetail.setPaymentMethod("paypal");
         
        PayerInfo payerInfo_Default = new PayerInfo();
        payerInfo_Default.setFirstName("Varinder")
                 .setLastName("kaur")
                 .setEmail("varinderkaur671@gmail.com");
         
        payerDetail.setPayerInfo(payerInfo_Default);
         
        return payerDetail;
    }
     
    private RedirectUrls getRedirectURLs() {
    	 RedirectUrls redirectUrls_all = new RedirectUrls();
    	 redirectUrls_all.setCancelUrl("http://localhost:8080/Patient_Management/error");
    	 redirectUrls_all.setReturnUrl("http://localhost:8080/Patient_Management/review_payment");
    	     
    	    return redirectUrls_all;
    }
     
    private List<Transaction> getTransactionInformation(BookingOrder bookingOrder) {
    	Details detailsTransaction = new Details();
        
    	detailsTransaction.setSubtotal(bookingOrder.getSubtotal());
    	detailsTransaction.setTax(bookingOrder.getTax());
     
        Amount amount_BookingFee = new Amount();
        amount_BookingFee.setCurrency("CAD");
        amount_BookingFee.setTotal(bookingOrder.getTotal());
        amount_BookingFee.setDetails(detailsTransaction);
     
        Transaction transaction = new Transaction();
        transaction.setAmount(amount_BookingFee);
        transaction.setDescription(bookingOrder.getProductName());
         
        ItemList AppointmentList = new ItemList();
        List<Item> Appointments = new ArrayList<>();
         
        Item appointment = new Item();
        appointment.setCurrency("CAD");
        appointment.setName(bookingOrder.getProductName());
        appointment.setPrice(bookingOrder.getSubtotal());
        appointment.setTax(bookingOrder.getTax());
        appointment.setQuantity("1");
         
        Appointments.add(appointment);
        AppointmentList.setItems(Appointments);
        transaction.setItemList(AppointmentList);
     
        List<Transaction> listTransaction = new ArrayList<>();
        listTransaction.add(transaction);  
         
        return listTransaction;
    }
     
    private String getApprovalLink(Payment approvedPayment) {
    	 List<Links> links = approvedPayment.getLinks();
    	    String approvalLink = null;
    	     
    	    for (Links link : links) {
    	        if (link.getRel().equalsIgnoreCase("approval_url")) {
    	            approvalLink = link.getHref();
    	            break;
    	        }
    	    }      
    	     
    	    return approvalLink;
    }

	public Payment getPaymentDetails(String paymentId) throws PayPalRESTException {
    APIContext apiContext = new APIContext(CLIENT_ID, CLIENT_SECRET, MODE);
    return Payment.get(apiContext, paymentId);
}

	public Payment executePayment(String paymentId, String payerId)
	        throws PayPalRESTException {
	    PaymentExecution paymentExecution = new PaymentExecution();
	    paymentExecution.setPayerId(payerId);
	 
	    Payment payment = new Payment().setId(paymentId);
	 
	    APIContext PalpalApi = new APIContext(CLIENT_ID, CLIENT_SECRET, MODE);
	 
	    return payment.execute(PalpalApi, paymentExecution);
	}
}