package com.starssfinanceapp.app.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer sid;
	private String fname;
	private String lname;
	private String education;
	private Integer age;
	private double mobileno;
	private String username;
	private String password;
	private String stuemail;
	//private String toEmail;
	//private String fromEmail;
	//private String subject;
	//private String textbody;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	private StudentAddress saddr;
	
	@OneToOne(cascade = CascadeType.ALL)
    private Documents document; 
}
