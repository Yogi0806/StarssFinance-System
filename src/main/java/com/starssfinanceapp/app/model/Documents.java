package com.starssfinanceapp.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


//@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Documents {

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer docid;
	
	@Lob
	private byte[] addressproof;
	@Lob
	private byte[] adharcard;
	@Lob
	private byte[] pancard;
	@Lob
	private byte[] photo;
	@Lob
	private byte[] signature;
	@Lob
	private byte[] thumb;
	@Lob
	private byte[] bankpassbook;
	
		
	public Integer getDocid() {
		return docid;
	}
	public void setDocid(Integer docid) {
		this.docid = docid;
	}
	public byte[] getAddressproof() {
		return addressproof;
	}
	public void setAddressproof(byte[] addressproof) {
		this.addressproof = addressproof;
	}
	public byte[] getAdharcard() {
		return adharcard;
	}
	public void setAdharcard(byte[] adharcard) {
		this.adharcard = adharcard;
	}
	public byte[] getPancard() {
		return pancard;
	}
	public void setPancard(byte[] pancard) {
		this.pancard = pancard;
	}
	public byte[] getPhoto() {
		return photo;
	}
	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
	public byte[] getSigniture() {
		return signature;
	}
	public void setSignature(byte[] signature) {
		this.signature = signature;
	}
	public byte[] getThumb() {
		return thumb;
	}
	public void setThumb(byte[] thumb) {
		this.thumb = thumb;
	}
	public byte[] getBankpassbook() {
		return bankpassbook;
	}
	public void setBankpassbook(byte[] bankpassbook) {
		this.bankpassbook = bankpassbook;
	}
	
	public byte[] getSignature() {
		return signature;
	}
	
	
	
}
