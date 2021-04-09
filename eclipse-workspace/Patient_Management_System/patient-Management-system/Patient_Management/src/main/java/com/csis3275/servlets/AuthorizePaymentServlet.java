package com.csis3275.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.csis3275.model.BookingOrder;
import com.paypal.base.rest.PayPalRESTException;


@WebServlet("/authorize_payment")
public class AuthorizePaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 
    public AuthorizePaymentServlet() {
    }
 
    protected void doPost(HttpServletRequest req, HttpServletResponse responseHttp)
            throws ServletException, IOException {
        String product = req.getParameter("product");
        String subtotal = req.getParameter("subtotal");
        
        String tax = req.getParameter("tax");
        String total = req.getParameter("total");
         
        BookingOrder orderDetail = new BookingOrder(product, subtotal, tax, total);
 
        try {
           PaymentServices payServices = new PaymentServices();
            String approvalLink = payServices.authorizePayment(orderDetail);
 
            responseHttp.sendRedirect(approvalLink);
             
        } catch (PayPalRESTException exception) {
        	req.setAttribute("errorMessage", exception.getMessage());
        	exception.printStackTrace();
            req.getRequestDispatcher("error.jsp").forward(req, responseHttp);
        }
    }
}
