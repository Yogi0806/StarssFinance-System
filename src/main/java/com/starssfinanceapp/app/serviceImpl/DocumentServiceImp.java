package com.starssfinanceapp.app.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.starssfinanceapp.app.model.Documents;
import com.starssfinanceapp.app.repository.DocumentRepository;
import com.starssfinanceapp.app.service.DocumentService;

@Service
public class DocumentServiceImp implements DocumentService{

	@Autowired
	DocumentRepository repo;
	
	@Override
	public Documents save(Documents d) {
	
	return	repo.save(d);
		 
	}

	@Override
	public List<Documents> getDoc() {
		
		
		return repo.findAll();
	}

}
