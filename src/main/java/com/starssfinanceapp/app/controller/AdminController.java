package com.starssfinanceapp.app.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.starssfinanceapp.app.model.Admin;
import com.starssfinanceapp.app.model.BankDetails;
import com.starssfinanceapp.app.service.AdminService;

@RestController
public class AdminController {

	
	@Autowired
	AdminService aser;
	
	@PostMapping
	("/postAdmin")
	public ResponseEntity<Admin> postBankdata( @RequestBody Admin ad)
	{
		Admin admin= aser.savesbankdata(ad);
		return new ResponseEntity<Admin>(admin,HttpStatus.CREATED);
		
	}

	
	@GetMapping(value="/getAdmin")
	public ResponseEntity<List<Admin>> getdata()
	{
		
		 List<Admin> list=aser.getdata();
		 if(list.isEmpty()) {
			 return new ResponseEntity<List<Admin>>(HttpStatus.NO_CONTENT); 
		 }
		 return new ResponseEntity<List<Admin>>(list,HttpStatus.OK);
		 
	}

//	@DeleteMapping(value="/deleteadmin/{branchid}")
//	public ResponseEntity<String> deleteData(@PathVariable ("branchid") Integer branchid){
//	
//		bs.deleteData(branchid);
//		
//		return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
//	}
//	
//	
//	@GetMapping(value="/getSinglebank/{branchid}")
//	public ResponseEntity<Optional<BankDetails>> getSingleData(@PathVariable ("branchid") Integer branchid){
//		
//		
//		Optional<BankDetails> bank=bs.getSingleData(branchid);
//		
//		
//		return new ResponseEntity<Optional<BankDetails>>(bank,HttpStatus.OK);
//	}
//
//	@PutMapping("/updateBank/{branchid}")
//	public ResponseEntity<BankDetails > updateData(@RequestBody BankDetails detail,@PathVariable ("branchid") int branchid){
//		
//		BankDetails bank=bs.updateData(detail,branchid);
//		
//		return  new ResponseEntity<BankDetails>(bank,HttpStatus.OK);
//	}
//	
//	
	
	
	
	
	
}
