package com.starssfinanceapp.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Guarantor {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int guarantorId;
	private String guarantorName;
	private String guarantorMobileno;
	private String guarantorOccupation;
	
	@Lob
	private byte[] adharCardFile;
	
	@Lob
	private byte[] panCardFile;
	
	
	
	
}
