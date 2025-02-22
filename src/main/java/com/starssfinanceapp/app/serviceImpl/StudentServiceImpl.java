package com.starssfinanceapp.app.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.starssfinanceapp.app.model.Documents;
import com.starssfinanceapp.app.model.EmailSender;
import com.starssfinanceapp.app.model.StudentDetails;
import com.starssfinanceapp.app.repository.DocumentRepository;
import com.starssfinanceapp.app.repository.StudentRepository;
import com.starssfinanceapp.app.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	StudentRepository repo;
	

	@Autowired
	DocumentRepository docrep;
//
//	@Autowired
//	JavaMailSender javamailsender;

	@Override
	public StudentDetails save(StudentDetails student) {
		
		StudentDetails stu=repo.save(student);
		
		return stu;
	}

	@Override
	public List<StudentDetails> getAllData() {
		
		List<StudentDetails> list=repo.findAll();
		return list;
	}

	@Override
	public void deleteData(int sid) {
	
		repo.deleteById(sid);
		
		
	}

	@Override
	public Optional<StudentDetails> getSingleData(int sid) {
		
		Optional<StudentDetails> student=repo.findById(sid);
		return student;
	}

	@Override
	public StudentDetails updateData(StudentDetails stu, int sid) {
	

		Optional<StudentDetails> student=repo.findBySid(sid);
		
		if(student.isPresent()) {
			StudentDetails details = student.get();
			details.setFname(stu.getFname());
			details.setLname(stu.getLname());
			details.setAge(stu.getAge());
			details.setEducation(stu.getEducation());
			details.setUsername(stu.getUsername());
			details.setPassword(stu.getPassword());
			details.setSaddr(stu.getSaddr());
			
		    return repo.save(stu);
		}
		else {
			System.out.println("Data is not present");
		}
		
		return null;
		
	}
		

	@Override
	public Documents save(Documents d) {

        Documents document=docrep.save(d);
        
		return document;
	}
	

	
	
	

	@Override
	public List<Documents> getDoc() {
	
		List<Documents> list=docrep.findAll();
		
		return list;
	}

//	
//	@Value("${spring.mail.username}")
//	private String fromEmail;
//	
//	
//	public void sendCreationEmail(StudentDetails student)
//	{
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
//			//throw new EmailException("Email Not Send Succefully");
//			System.out.println();
//		}
//		System.out.println("Mail Send Succesfully");
//		
//		
//	}
//	
	
}
