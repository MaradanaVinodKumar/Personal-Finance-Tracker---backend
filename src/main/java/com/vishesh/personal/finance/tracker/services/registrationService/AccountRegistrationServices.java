package com.vishesh.personal.finance.tracker.services.registrationService;

import com.vishesh.personal.finance.tracker.model.AccountHolder;

public interface AccountRegistrationServices {
	public String AccountRegistration(AccountHolder accountHolder);
	public String sendOtpToEmailId(String emailId);
	public String validateEmailIdOtp(String emailId,Integer otp);
}