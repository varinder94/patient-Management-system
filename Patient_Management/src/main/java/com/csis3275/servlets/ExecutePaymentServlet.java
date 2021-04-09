package com.csis3275.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.paypal.api.payments.PayerInfo;
import com.paypal.api.payments.Payment;
import com.paypal.api.payments.Transaction;
import com.paypal.base.rest.PayPalRESTException;

@WebServlet("/execute_payment")
public class ExecutePaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 
    public ExecutePaymentServlet() {
    }
 
    protected void doPost(HttpServletRequest req, HttpServletResponse responseHTTP)
            throws ServletException, IOException {
        String paymentId = req.getParameter("paymentId");
        String payerId = req.getParameter("PayerID");
 
        try {
            PaymentServices payServices = new PaymentServices();
            Payment paymentService = payServices.executePayment(paymentId, payerId);
             
            PayerInfo patientPaymentInfo = paymentService.getPayer().getPayerInfo();
            Transaction transactionInfo = paymentService.getTransactions().get(0);
             
            req.setAttribute("payer", patientPaymentInfo);
            req.setAttribute("transaction", transactionInfo);          
 
            req.getRequestDispatcher("receipt.jsp").forward(req, responseHTTP);
             
        } catch (PayPalRESTException ex) {
        	req.setAttribute("errorMessage", ex.getMessage());
            ex.printStackTrace();
            req.getRequestDispatcher("error.jsp").forward(req, responseHTTP);
        }
    }

}
