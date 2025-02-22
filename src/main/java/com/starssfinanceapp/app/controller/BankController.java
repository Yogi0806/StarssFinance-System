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

import com.starssfinanceapp.app.model.BankDetails;
import com.starssfinanceapp.app.model.StudentDetails;
import com.starssfinanceapp.app.service.BankService;

@RestController
public class BankController {

	
	@Autowired
	BankService bs;
	
	@PostMapping
	("/postBank")
	public ResponseEntity<BankDetails> postBankdata(@Valid @RequestBody BankDetails bd)
	{
		BankDetails bankdetails= bs.savesbankdata(bd);
		return new ResponseEntity<BankDetails>(bankdetails,HttpStatus.CREATED);
		
	}

	
	@GetMapping(value="/getBank")
	public ResponseEntity<List<BankDetails>> getdata()
	{
		
		 List<BankDetails> list=bs.getdata();
		 if(list.isEmpty()) {
			 return new ResponseEntity<List<BankDetails>>(HttpStatus.NO_CONTENT); 
		 }
		 return new ResponseEntity<List<BankDetails>>(list,HttpStatus.OK);
		 
	}

	@DeleteMapping(value="/deleteBank/{branchid}")
	public ResponseEntity<String> deleteData(@PathVariable ("branchid") Integer branchid){
	
		bs.deleteData(branchid);
		
		return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
	}
	
	
	@GetMapping(value="/getSinglebank/{branchid}")
	public ResponseEntity<Optional<BankDetails>> getSingleData(@PathVariable ("branchid") Integer branchid){
		
		
		Optional<BankDetails> bank=bs.getSingleData(branchid);
		
		
		return new ResponseEntity<Optional<BankDetails>>(bank,HttpStatus.OK);
	}

	@PutMapping("/updateBank/{branchid}")
	public ResponseEntity<BankDetails > updateData(@RequestBody BankDetails detail,@PathVariable ("branchid") int branchid){
		
		BankDetails bank=bs.updateData(detail,branchid);
		
		return  new ResponseEntity<BankDetails>(bank,HttpStatus.OK);
	}
	
	
	
	
	
}
