package com.test.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "request_form")
public class RequestFormEntity {
	
	@Id
	@Column(name = "cust_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	public RequestFormEntity(Integer custId, String firstName, String lastName, String companyName, String email,
			String projDesc, LocalDate timeLine, double price) {
		super();
		this.custId = custId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.companyName = companyName;
		this.email = email;
		this.projDesc = projDesc;
		this.timeLine = timeLine;
		this.price = price;
	}
	public RequestFormEntity() {
		super();
	}
	
	
	
	

}
