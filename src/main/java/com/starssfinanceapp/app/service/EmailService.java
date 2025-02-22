
package com.starssfinanceapp.app.service;

import com.starssfinanceapp.app.model.EmailSender;
import com.starssfinanceapp.app.model.StudentDetails;

public interface EmailService {

//public	String sendwelemail(EmailSender email);



String sendwelemail(EmailSender email, StudentDetails details);

}
