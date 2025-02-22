package com.starssfinanceapp.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.starssfinanceapp.app.model.EmailSender;
import com.starssfinanceapp.app.model.StudentDetails;
import com.starssfinanceapp.app.service.EmailService;




@RestController
public class EmailController {
	
	@Autowired
	EmailService es;
	
	@Value("${spring.mail.username}")
	private String fromEmail;

	
	@PostMapping(value="/wel_mail")
	public  String emailSending(@RequestBody EmailSender email, StudentDetails details) {
		
	email.setFromEmail(fromEmail);
	
	return es.sendwelemail(email,details);
		
	}

}






