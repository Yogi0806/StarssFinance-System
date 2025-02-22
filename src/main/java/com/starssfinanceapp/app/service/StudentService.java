package com.starssfinanceapp.app.service;

import java.util.List;
import java.util.Optional;

import com.starssfinanceapp.app.model.Documents;
import com.starssfinanceapp.app.model.StudentDetails;

public interface StudentService {

	public StudentDetails save(StudentDetails student);

	public List<StudentDetails> getAllData();

	public void deleteData(int sid);

	public Optional<StudentDetails> getSingleData(int sid);

	public StudentDetails updateData(StudentDetails stu, int sid);

	Documents save(Documents d);

	public List<Documents> getDoc();

	

}
