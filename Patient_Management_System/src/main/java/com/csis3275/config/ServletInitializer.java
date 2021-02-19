package com.csis3275.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class ServletInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		AnnotationConfigWebApplicationContext configPatient = new AnnotationConfigWebApplicationContext();
		configPatient.register(SpringMVCConfig.class);
		configPatient.setServletContext(servletContext);
		ServletRegistration.Dynamic servletParient = servletContext.addServlet("dispatcher", new DispatcherServlet(configPatient));
		servletParient.setLoadOnStartup(1);
		servletParient.addMapping("/");
	}
	

}
