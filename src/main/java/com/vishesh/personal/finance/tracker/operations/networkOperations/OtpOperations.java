package com.vishesh.personal.finance.tracker.operations.networkOperations;

public interface OtpOperations {
	public void sendOtpToEmailId(String emailId);
	public void emailIdOtpValidation(String emailId,Integer otp);
	public void removeEmailIdOtpRecordInDb(String emailId);
	public void validateEmailIdInDb(String emailId);
	public Integer generateOtp();
	public void storeOtpRecordInDb(String emailId,Integer otp,Boolean validity);
}
