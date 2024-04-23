package com.vishesh.personal.finance.tracker.operations.registrationOperations;

import com.vishesh.personal.finance.tracker.model.AccountHolder;

public interface RegistrationOperations {
	public void storeRegistationDataInDb(AccountHolder accountHolder);
	public String generateAccountNumber();
	public void accountHolderExist(String emailId);
}
