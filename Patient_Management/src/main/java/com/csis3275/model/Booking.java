package com.csis3275.model;




import java.util.Date;



import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;


public class Booking {
	
	private int id;
	private String name;
	private String last;
	 private Date dateP;
	 private String timeP;
	 private String doctor;

	public MultipartFile file;
	

		public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	public String getDoctor() {
		return doctor;
	}
	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}

	public Date getDateP() {
		return dateP;
	}
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	public void setDateP(Date dateP) {
		this.dateP = dateP;
	}
	
	
	
	public String getLast() {
		return last;
	}
	public void setLast(String last) {
		this.last = last;
	}

	public String getTimeP() {
		return timeP;
	}
	public void setTimeP(String timeP) {
		this.timeP = timeP;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	
	
	

}
