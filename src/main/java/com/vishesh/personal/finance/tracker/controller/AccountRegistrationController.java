package com.vishesh.personal.finance.tracker.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.vishesh.personal.finance.tracker.model.AccountHolder;
import com.vishesh.personal.finance.tracker.services.registrationService.AccountRegistrationServices;

@RestController
@RequestMapping("v1/accountRegistration")
public class AccountRegistrationController {
	
	@Autowired
	AccountRegistrationServices accountRegistrationServices; 
	
	@CrossOrigin
	@PostMapping(value = "/accountRegistration")
	public String accountRegistration(@RequestBody AccountHolder accountHolder ) {
		return accountRegistrationServices.AccountRegistration(accountHolder);
	}
	
	@CrossOrigin
	@PostMapping(value="/sendOtpEmailId")
	public String sendOtpEmailId(@RequestParam("emailId") String emailId) {
		accountRegistrationServices.sendOtpToEmailId(emailId);
		return "SENDED";
	}
	
	@CrossOrigin
	@PostMapping(value="/validateEmailIdOtp")
	public String validateEmailIdOtp(@RequestParam("emailId") String emailId, @RequestParam("otp") Integer otp ) {
		
		accountRegistrationServices.validateEmailIdOtp(emailId, otp);
		return "Valid";
	}
	
}
