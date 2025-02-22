package com.starssfinanceapp.app.service;

import java.util.List;
import java.util.Optional;

import com.starssfinanceapp.app.model.BankDetails;

public interface BankService {

 public	BankDetails savesbankdata(BankDetails bd);

public List<BankDetails> getdata();

public void deleteData(Integer branchid);

public Optional<BankDetails> getSingleData(Integer branchid);

public BankDetails updateData(BankDetails detail, int branchid);

}
