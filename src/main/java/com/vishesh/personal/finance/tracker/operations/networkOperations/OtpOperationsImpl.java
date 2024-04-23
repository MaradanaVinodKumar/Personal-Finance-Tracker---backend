package com.vishesh.personal.finance.tracker.operations.networkOperations;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.vishesh.personal.finance.tracker.operations.inputValidations.FieldValidation;
import com.vishesh.personal.finance.tracker.operations.registrationOperations.RegistrationOperations;
import com.vishesh.personal.finance.tracker.repository.EmailOtpRepository;
import com.vishesh.personal.finance.tracker.repository.Entity.EmailOtpEntity;

@Service
public class OtpOperationsImpl implements OtpOperations{
	@Autowired
	public EmailOtpRepository emailOtpRepository;
	@Autowired
	public JavaMailSender mailSender;
	@Autowired
	FieldValidation fieldValidation;
	@Autowired
	RegistrationOperations registrationOperations;
	
	@Override
	public void sendOtpToEmailId(String emailId) {
		fieldValidation.emailIdValidation(emailId);
		registrationOperations.accountHolderExist(emailId);
		//call generateOtp method and store the otp in variable
		Integer generatedOtp=generateOtp();
		//send otp to email
		String bodyText="Dear User,\r\n"
				+ "\r\n"
				+ "Thank you for registering with us. To complete the registration process, please use the following one-time password (OTP):\r\n"
				+ "\r\n"
				+ "Your OTP is: "+generatedOtp+"\r\n"
				+ "\r\n"
				+ "Please enter this OTP in the designated field to finalize your registration. For security reasons, please do not share this OTP with anyone.\r\n"
				+ "\r\n"
				+ "If you did not initiate this registration or have any concerns, please contact our support team immediately.\r\n"
				+ "\r\n"
				+ "Thank you for choosing us.\r\n"
				+ "\r\n"
				+ "Best regards,\r\n"
				+ "Personal Finance Tracker\r\n";
		SimpleMailMessage message=new SimpleMailMessage();
		message.setTo(emailId);
		message.setSubject("Your One-Time Password (OTP) for Personal Finance Tracker Access");
		message.setText(bodyText);
		mailSender.send(message);
		//call storeOtpRecordInDb method and pass the parameters.
		storeOtpRecordInDb(emailId, generatedOtp, false);
	}

	@Override
	public void emailIdOtpValidation(String emailId, Integer otp) {
		//connect the otp table and serch the email then validate the otp is currect or not 
		EmailOtpEntity emailOtps = emailOtpRepository.findByEmailId(emailId);
		//if the otp is valid then update record validity id is true;
		if(emailOtps != null)
		{
			if((emailOtps.getOtp()).equals(otp))
			{
				emailOtpRepository.updateOtpValidityByEmailId(emailId, true);
			}else {
				throw new Error("otp not matched");
			}
		}
		else
		{
			throw new Error("email id not found!");	
		}
	}

	@Override
	public void removeEmailIdOtpRecordInDb(String emailId) {
		fieldValidation.emailIdValidation(emailId);
		//conncet the otp table and remove the email id record.
		EmailOtpEntity emailOtps = emailOtpRepository.findByEmailId(emailId);
		if(emailOtps !=null)
		{
			 emailOtpRepository.deleteByEmailId(emailId);
		}
		else {
			throw new Error("email id not found!");
		}
	}

	@Override
	public void validateEmailIdInDb(String emailId) {
		fieldValidation.emailIdValidation(emailId);
		//connect otp table and then check email id status valid or not.
		EmailOtpEntity emailOtps = emailOtpRepository.findByEmailId(emailId);
		if(emailOtps != null)
		{
			if(!emailOtps.getValidity())
			{
				throw new Error("email id not valid!");
			}
		}
		else
		{
			throw new Error("email id not found!");	
		}
	}

	@Override
	public Integer generateOtp() {
		//generate unique 4 digit otp
		Random random=new Random();
		int count=1;
		Integer otp=0;
		while(true)
		{
			otp = otp *10 + (random.nextInt(8)+1);
			
			if(count==4)
			{
				break;
			}
			count++;
		}
		return otp;
	}

	@Override
	public void storeOtpRecordInDb(String emailId,Integer otp,Boolean validity) {
		//check the email in db if email is in the db then update the otp or else add the new record.
		EmailOtpEntity emailOtps = emailOtpRepository.findByEmailId(emailId);
		if(emailOtps == null)
		{
			EmailOtpEntity emailOtpRecord=new EmailOtpEntity();
			emailOtpRecord.setEmailId(emailId);
			emailOtpRecord.setOtp(otp);
			emailOtpRecord.setValidity(validity);
			emailOtpRepository.save(emailOtpRecord);
		}
		else {
			emailOtpRepository.updateByEmailId(emailId, otp, validity);
		}
	}


}
