package com.starssfinanceapp.app.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
//@Data
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer adminid;
    @Setter @Getter
	private String adfname;
    @Setter @Getter
	private String adlname;
   
    @JsonProperty("bankid")
	private String bankid;
	
//    @JsonProperty("bankid")
	public void setBankId(String bankid)
	{
	this.bankid="SFIN"+bankdetails.getBranchid();
	}
    
//    @JsonProperty("bankid")
	public String getBankId()
	{
		return bankid;//="SFIN"+bankdetails.getBranchid();
	}

	
	//private String bankname;
	//private String branchname;
	
	@OneToOne(cascade = CascadeType.ALL)
	private  BankDetails bankdetails;
	
	@OneToOne(cascade = CascadeType.ALL)
	private EnquiryDetails enquirydetails;
	
	@OneToOne(cascade = CascadeType.ALL)
	private StudentDetails studentdetails;
   
	
}
