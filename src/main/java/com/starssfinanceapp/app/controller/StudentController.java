package com.starssfinanceapp.app.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import com.starssfinanceapp.app.model.Documents;
import com.starssfinanceapp.app.model.EmailSender;
import com.starssfinanceapp.app.model.StudentDetails;
import com.starssfinanceapp.app.service.EmailService;
import com.starssfinanceapp.app.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	StudentService service;
	
	@Autowired
	EmailService eser;
	
//	@Value("${spring.mail.username}")
//	private String fromEmail;

	
	@PostMapping(value="/poststudent")
	public ResponseEntity<StudentDetails> postData(@RequestBody StudentDetails student,EmailSender email){
		
		StudentDetails student1=service.save(student);
		email.setToEmail(student1.getStuemail());
		eser.sendwelemail(email, student1);
		
		return new ResponseEntity<StudentDetails>(student1,HttpStatus.CREATED);
	}
	
	@GetMapping(value="/getAll")
	public ResponseEntity<List<StudentDetails>> getAll(){
		
		List<StudentDetails> list=service.getAllData();
		
		if(list.isEmpty()) {
			return new ResponseEntity<List<StudentDetails>>(list,HttpStatus.NOT_FOUND);
		}
			
		return new ResponseEntity<List<StudentDetails>>(list,HttpStatus.OK);
	}
	
	@DeleteMapping(value="/deleteData/{sid}")
	public ResponseEntity<String> deleteData(@PathVariable ("sid") int sid){
		
		
		service.deleteData(sid);
		
		return new ResponseEntity<String>("Data Deleted Successfully",HttpStatus.NO_CONTENT);
	}

	@GetMapping(value="/getSinglestu/{sid}")
	public ResponseEntity<Optional<StudentDetails>> getSingleData(@PathVariable ("sid") int sid){
		
		
		Optional<StudentDetails> student=service.getSingleData(sid);
		
		
		return new ResponseEntity<Optional<StudentDetails>>(student,HttpStatus.OK);
	}
	
	@PutMapping("/update/{sid}")
	public ResponseEntity<StudentDetails > updateData(@RequestBody StudentDetails stu,@PathVariable ("sid") int sid){
		
		StudentDetails student=service.updateData(stu,sid);
		
		return  new ResponseEntity<StudentDetails>(student,HttpStatus.OK);
	}
	
//	@PostMapping(value = "/addStudentDoc", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
//	public ResponseEntity<StudentDetails> addApplicantDoc(
//			//@RequestPart("studentdetails") String studentdetails,
//			@RequestPart("adharcard") MultipartFile adharFile,
//			@RequestPart("addressproof") MultipartFile addressproof, 
//			@RequestPart("pancard") MultipartFile pancardFile, 
//			@RequestPart("bankpassbook") MultipartFile passbookFile,
//			@RequestPart("signature") MultipartFile signatureFile,
//			
//			@RequestPart("Photo") MultipartFile photo, 
//			@RequestPart("thumb") MultipartFile thumb,
//			//@RequestPart ("student") String student
//			@RequestPart("studentdetails") String studentdetails
//			) 
//			throws IOException
//	{
//		Documents doc = new Documents();
//		try {
//			doc.setAdharcard(adharFile.getBytes());
//			doc.setAddressproof(addressproof.getBytes());
//			doc.setPancard(pancardFile.getBytes());
//			doc.setBankpassbook(passbookFile.getBytes());
//			doc.setSignature(signatureFile.getBytes());
//			doc.setPhoto(photo.getBytes());
//			doc.setThumb(thumb.getBytes());
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//        Gson g=new Gson();
//		StudentDetails stu=new StudentDetails();
//		StudentDetails ds= g.fromJson(studentdetails, StudentDetails.class);
//		stu.setSid(ds.getSid());
//		stu.setSname(ds.getSname());
//		stu.setAge(ds.getAge());
//		stu.setEducation(ds.getEducation());
//		stu.setStuemail(ds.getStuemail());
//		stu.setToEmail(ds.getToEmail());
//		stu.setFromEmail(ds.getFromEmail());
//		stu.setSubject(ds.getSubject());
//		stu.setTextbody(ds.getTextbody());
//		stu.setUsername(ds.getUsername());
//		stu.setPassword(ds.getPassword());
//		stu.setSaddr(ds.getSaddr());
//		stu.setDocument(doc);
//		//Documents document=service.save(doc);
//		StudentDetails details=service.save(stu);
//		
//		return new ResponseEntity<StudentDetails>(details,HttpStatus.CREATED);
//	}
	
//	
//	@GetMapping("/files")
//	public List<Documents> getDoc(){
//		
//		List<Documents> list = service.getDoc();
//		
//		return list;
//	}
//	
	
	
	
}
