package com.starssfinanceapp.app.model;




public class EmailSender {

	private String toEmail;
	private String fromEmail;
	private String subject;
	private String textbody;
	
	public String getToEmail() {
		return toEmail;
	}
	public void setToEmail(String toEmail) {
		this.toEmail = toEmail;
	}
	public String getFromEmail() {
		return fromEmail;
	}
	public void setFromEmail(String fromEmail) {
		this.fromEmail = fromEmail;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getTextbody() {
		return textbody;
	}
	public void setTextbody(String textbody) {
		this.textbody = textbody;
	}
	
	
}
