package com.vishesh.personal.finance.tracker.services.registrationService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vishesh.personal.finance.tracker.model.AccountHolder;
import com.vishesh.personal.finance.tracker.operations.inputValidations.FieldValidation;
import com.vishesh.personal.finance.tracker.operations.networkOperations.OtpOperations;



@Service
public class AccountRegistrationServicesImpl implements  AccountRegistrationServices {
	
	@Autowired
	FieldValidation fieldValidation;  
	@Autowired
	OtpOperations otpOperations; 
	
	@Override
	public String AccountRegistration(AccountHolder accountHolder) {		
		
		fieldValidation.accountHolderValidation(accountHolder);
		otpOperations.validateEmailIdInDb(accountHolder.getHolderEmail());
		
		//connect the registration table and add the data to the table.
		
		// after created the account run this line otpOperations.removeEmailIdOtpRecordInDb(accountHolder.getHolderEmail());
		
		return "Created";
		
	}

	@Override
	public String sendOtpToEmailId(String emailId) {
		fieldValidation.emailIdValidation(emailId);
		otpOperations.sendOtpToEmailId(emailId);
		
		return null;
	}

	@Override
	public String validateEmailIdOtp(String emailId, Integer otp) {
		fieldValidation.emailIdValidation(emailId);
		fieldValidation.genaralFieldValidation(otp, "email Id");
		otpOperations.emailIdOtpValidation(emailId, otp);
		
		return null;
	}

	
	
}
