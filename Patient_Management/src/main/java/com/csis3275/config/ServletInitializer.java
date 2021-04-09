package com.csis3275.config;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.GenericWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class ServletInitializer implements WebApplicationInitializer {
	private String TMP_FOLDER = "/tmp";
	private int MAX_UPLOAD_SIZE = 10 * 1024 * 1024;

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		AnnotationConfigWebApplicationContext configPatient = new AnnotationConfigWebApplicationContext();
		configPatient.register(SpringMVCConfig.class);
		configPatient.setServletContext(servletContext);
		ServletRegistration.Dynamic servletParient = servletContext.addServlet("dispatcher",
				new DispatcherServlet(configPatient));
		servletParient.setLoadOnStartup(1);
		servletParient.addMapping("/");
		
		
		ServletRegistration.Dynamic appServlet = servletContext.addServlet("mvc", new DispatcherServlet(
		          new GenericWebApplicationContext()));

		        appServlet.setLoadOnStartup(1);
		        
		        MultipartConfigElement multipartConfigElement = new MultipartConfigElement(TMP_FOLDER, 
		          MAX_UPLOAD_SIZE, MAX_UPLOAD_SIZE * 2, MAX_UPLOAD_SIZE / 2);
		        
		        appServlet.setMultipartConfig(multipartConfigElement);
	}
	
}
