package com.starssfinanceapp.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
//@Data
public class BankDetails {
	
	@Id 
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Setter @Getter
	//@Size(min=4, max=4)
	private Integer branchid;
	@Setter 
	@Getter
	private String branchname;

	private String branchcode;

	public void setBranchcode(String branchcode) {
		this.branchcode="SFIN"+branchid;
	}
	
	public String getBranchcode() {
		return branchcode ="SFIN"+branchid;
	}
}
