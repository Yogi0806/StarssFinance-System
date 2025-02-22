package com.starssfinanceapp.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.starssfinanceapp.app.model.Documents;


public interface DocumentService {

	public Documents save(Documents d);

	public List<Documents> getDoc();

}
