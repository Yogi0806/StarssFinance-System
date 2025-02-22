package com.starssfinanceapp.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.starssfinanceapp.app.model.StudentDetails;

@Repository
public interface StudentRepository extends JpaRepository<StudentDetails, Integer>{
	
	
	  Optional<StudentDetails> findBySid(Integer sid);

}
