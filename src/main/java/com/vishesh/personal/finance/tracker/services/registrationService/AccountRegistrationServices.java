package com.vishesh.personal.finance.tracker.services.registrationService;

import com.vishesh.personal.finance.tracker.model.AccountHolder;

public interface AccountRegistrationServices {
	public void AccountRegistration(AccountHolder accountHolder);
	public void sendOtpToEmailId(String emailId);
	public void validateEmailIdOtp(String emailId,Integer otp);
}