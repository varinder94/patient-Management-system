package com.csis3275.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.csis3275")
@PropertySource("classpath:database.properties")

public class SpringMVCConfig implements WebMvcConfigurer {
	
	 @Autowired
	 Environment environment;
	 private final String URL = "url";
	 private final String USER = "dbuser";
	 private final String DRIVER = "driver";
	 private final String PASSWORD = "dbpassword";
	 
	 @Bean
	 DataSource dataSource() {
	 DriverManagerDataSource driverPatientSource = new DriverManagerDataSource();
	 driverPatientSource.setUrl(environment.getProperty(URL));
	 driverPatientSource.setUsername(environment.getProperty(USER));
     driverPatientSource.setPassword(environment.getProperty(PASSWORD));
    driverPatientSource.setDriverClassName(environment.getProperty(DRIVER));
	 return driverPatientSource;
	 }

	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewPatientResolver = new InternalResourceViewResolver();
		viewPatientResolver.setViewClass(JstlView.class);
		viewPatientResolver.setPrefix("/WEB-INF/views/");
		viewPatientResolver.setSuffix(".jsp");
		return viewPatientResolver;
	}

	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource patientSource = new ResourceBundleMessageSource();
		patientSource.setBasename("messages");
		return patientSource;
	}
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry patientRegister) {

		patientRegister.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
		// Register resource handler for images
		patientRegister.addResourceHandler("/image/**").addResourceLocations("/WEB-INF/image/");
	}


}
