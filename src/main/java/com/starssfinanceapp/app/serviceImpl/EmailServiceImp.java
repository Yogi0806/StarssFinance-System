package com.starssfinanceapp.app.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.starssfinanceapp.app.model.EmailSender;
import com.starssfinanceapp.app.model.StudentDetails;
import com.starssfinanceapp.app.service.EmailService;

@Service
public class EmailServiceImp implements EmailService{

  private String msgbody;
	
	@Autowired
	JavaMailSender javamailsender;

	@Override
	public String sendwelemail(EmailSender email, StudentDetails details) {
	
		SimpleMailMessage msg=new SimpleMailMessage();
		msg.setTo(email.getToEmail());
		msg.setFrom(email.getFromEmail());
		msg.setSubject(email.getSubject());
		msgbody = (" Welcome to STARSS FINANCE !"+"\n"+details.getFname()+" "+details.getLname()
		+"\n"+"your Username is : "+details.getUsername()+"\n"+"Your password is :-"+details.getPassword()+"\n"+" Thanks For Choosing Starss Finance ");
		email.setTextbody(msgbody);  
	
	//	email.setTextbody(null);
		msg.setText(email.getTextbody());
		try {
			javamailsender.send(msg);
			
		 return	"Email send successfully";
		} catch (Exception e) {
		    return "Email cannot be sent";
		}
			
	//}
		
		
		
		
		//return null;
	}

	
	
	
//	
//	public void sendemail(StudentDetails student)
////	{
//		System.out.println("Come in Mail Send Method");
//		try {
//		SimpleMailMessage mail= new SimpleMailMessage();
//		mail.setFrom(fromEmail);
//		mail.setSubject("Education Loan Application Created");
////		mail.setTo();
//		mail.setTo(student.getUsername());
//		mail.setText("Hi "+student.getSname()+","+" Your Application Succesfully Created. "+" This is Your ApplicationId "+student.getSid()+
//				" Refer this ApplicationId for track your application status."
//							);
//		javamailsender.send(mail);
//		}
//		catch (Exception e) {
//			
//			System.out.println("Email not sent ............");
//		}
//		System.out.println("Mail Send Succesfully");
//		
		
	}
	
	
	
	
	

