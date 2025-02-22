package com.starssfinanceapp.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.starssfinanceapp.app.model.BankDetails;

@Repository
public interface BankRepository extends JpaRepository<BankDetails, Integer>{

// public	BankDetails findByBranchid(int branchid);
	
}
