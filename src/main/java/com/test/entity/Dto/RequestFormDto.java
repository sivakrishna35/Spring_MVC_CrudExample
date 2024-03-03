package com.test.entity.Dto;

import java.time.LocalDate;

public class RequestFormDto {

	private Integer custId;

	private String firstName;
	private String lastName;
	private String companyName;
	private String email;
	private String projDesc;
	private LocalDate timeLine;
	private double price;
	
	
	public Integer getCustId() {
		return custId;
	}
	public void setCustId(Integer custId) {
		this.custId = custId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getProjDesc() {
		return projDesc;
	}
	public void setProjDesc(String projDesc) {
		this.projDesc = projDesc;
	}
	public LocalDate getTimeLine() {
		return timeLine;
	}
	public void setTimeLine(LocalDate timeLine) {
		this.timeLine = timeLine;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	

}
