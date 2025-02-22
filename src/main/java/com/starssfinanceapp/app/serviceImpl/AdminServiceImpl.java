package com.starssfinanceapp.app.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.starssfinanceapp.app.model.Admin;
import com.starssfinanceapp.app.repository.AdminRepository;
import com.starssfinanceapp.app.service.AdminService;


@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	AdminRepository arep;
	
	@Override
	public Admin savesbankdata(Admin ad) {
		
		
		
		return arep.save(ad);
	}

	@Override
	public List<Admin> getdata() {
	
		return arep.findAll();
	}

}
