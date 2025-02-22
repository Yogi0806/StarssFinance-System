package com.starssfinanceapp.app.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.starssfinanceapp.app.model.BankDetails;
import com.starssfinanceapp.app.model.StudentDetails;
import com.starssfinanceapp.app.repository.BankRepository;
import com.starssfinanceapp.app.service.BankService;

@Service
public class BankServiceImpl implements BankService{

	@Autowired
	BankRepository brep;
	
	
	@Override
	public BankDetails savesbankdata(BankDetails bd) {
		
		
		return brep.save(bd);
	}


	@Override
	public List<BankDetails> getdata() {
		
		
		return brep.findAll();
	}


	@Override
	public void deleteData(Integer branchid) {
		
		brep.deleteById(branchid);
		
	}


	@Override
	public Optional<BankDetails> getSingleData(Integer branchid) {
		
		Optional<BankDetails> bank=brep.findById(branchid);
		
		return bank;
	}


	@Override
	public BankDetails updateData(BankDetails detail, int branchid) {
		

		Optional<BankDetails> bankd=brep.findById(branchid);
		
		if(bankd.isPresent()) {
			BankDetails bank1=bankd.get();
			bank1.setBranchid(detail.getBranchid());
			bank1.setBranchname(detail.getBranchname());
			bank1.setBranchcode(detail.getBranchcode());
		    return brep.save(detail);
		}
		else {
			System.out.println("Data is not present");
		}
		
		return null;
		
	}
		
		
		
		
	

}
