package com.csis3275.model;

public class BookingOrder {
    private String Service;
    private float subtotal;
    private float tax;
    private float total;
 
    public BookingOrder(String service, String subtotal,
             String tax, String total) {
        this.Service = service;
        this.subtotal = Float.parseFloat(subtotal);
        this.tax = Float.parseFloat(tax);
        this.total = Float.parseFloat(total);
    }
 
    public BookingOrder() {
		// default
	}

	public String getProductName() {
        return Service;
    }
 
    public String getSubtotal() {
        return String.format("%.2f", subtotal);
    }
    public String getTax() {
        return String.format("%.2f", tax);
    }
     
    public String getTotal() {
        return String.format("%.2f", total);
    }
}
