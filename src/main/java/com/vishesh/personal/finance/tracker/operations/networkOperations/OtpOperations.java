package com.vishesh.personal.finance.tracker.operations.networkOperations;

public interface OtpOperations {
	public void sendOtpToEmailId(String emailId);
	public String emailIdOtpValidation(String emailId,Integer otp);
	public String removeEmailIdOtpRecordInDb(String emailId);
	public Boolean validateEmailIdInDb(String emailId);
	public Integer generateOtp();
	public void storeOtpRecordInDb(String emailId,Integer otp,Boolean validity);
}
