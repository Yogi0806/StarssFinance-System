package com.starssfinanceapp.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class EnquiryDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer eqid;
	private String fname;
	private String lname;
	private String dob;
	private Integer age;
	private String gender;
	private String email;
	private double mobileno; 
	private double adharcardno;
	private String pancard;
	

}
