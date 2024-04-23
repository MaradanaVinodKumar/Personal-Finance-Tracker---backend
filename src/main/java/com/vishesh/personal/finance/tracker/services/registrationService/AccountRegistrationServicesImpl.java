package com.vishesh.personal.finance.tracker.services.registrationService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vishesh.personal.finance.tracker.model.AccountHolder;
import com.vishesh.personal.finance.tracker.operations.inputValidations.FieldValidation;
import com.vishesh.personal.finance.tracker.operations.networkOperations.OtpOperations;
import com.vishesh.personal.finance.tracker.operations.registrationOperations.RegistrationOperations;
import com.vishesh.personal.finance.tracker.repository.AccountHolderRegistrationRepository;
import com.vishesh.personal.finance.tracker.repository.Entity.AccountHolderRegistrationEntity;



@Service
public class AccountRegistrationServicesImpl implements  AccountRegistrationServices {
	
	@Autowired
	FieldValidation fieldValidation;  
	@Autowired
	OtpOperations otpOperations;
	@Autowired
	RegistrationOperations registrationOperations;
	
	
	@Override
	public void AccountRegistration(AccountHolder accountHolder) {		
		
		fieldValidation.accountHolderValidation(accountHolder);
		otpOperations.validateEmailIdInDb(accountHolder.getHolderEmail());
		//connect the registration table and add the data to the table.
		registrationOperations.storeRegistationDataInDb(accountHolder);
		//remove otp record by email 
		otpOperations.removeEmailIdOtpRecordInDb(accountHolder.getHolderEmail());
	}

	@Override
	public void sendOtpToEmailId(String emailId) {
		fieldValidation.emailIdValidation(emailId);
		otpOperations.sendOtpToEmailId(emailId);
	}

	@Override
	public void validateEmailIdOtp(String emailId, Integer otp) {
		fieldValidation.emailIdValidation(emailId);
		fieldValidation.genaralFieldValidation(otp, "email Id");
		otpOperations.emailIdOtpValidation(emailId, otp);
		
	}

	
	
}
