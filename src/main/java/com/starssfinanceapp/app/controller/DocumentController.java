package com.starssfinanceapp.app.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import com.starssfinanceapp.app.model.Documents;
import com.starssfinanceapp.app.service.DocumentService;

@RestController
public class DocumentController {

	

	@Autowired
	DocumentService ser;

	@RequestMapping(value = "/docSave",method=RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public Documents docSave(@RequestPart(required = true, value = "adharcard")MultipartFile f1,
			@RequestPart(required = true, value = "pancard")MultipartFile f2,
			@RequestPart(required = true, value = "photo")MultipartFile f3,
			@RequestPart(required = true, value = "addressproof")MultipartFile f4,
			@RequestPart(required = true, value = "thumb")MultipartFile f5,
			@RequestPart(required = true, value = "bankpassbook")MultipartFile f6,
			@RequestPart(required = true, value = "signature")MultipartFile f7,
			
			@RequestPart ("doc") String doc	
			) throws IOException		
	{
		
		Documents d=new Documents();
		d.setAdharcard(f1.getBytes());
		d.setPancard(f2.getBytes());
		d.setPhoto(f3.getBytes());
		d.setAddressproof(f4.getBytes());
		d.setThumb(f5.getBytes());
		d.setBankpassbook(f6.getBytes());
		d.setSignature(f7.getBytes());
		
		Gson g=new Gson();
		
		Documents ds= g.fromJson(doc, Documents.class);
		
		d.setDocid(ds.getDocid());
	
		
		Documents document=ser.save(d);
		
		return document;
	}
	
	@GetMapping("/files")
	public List<Documents> getDoc(){
		
		List<Documents> list = ser.getDoc();
		
		return list;
	}
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
}
