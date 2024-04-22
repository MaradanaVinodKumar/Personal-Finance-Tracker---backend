package com.vishesh.personal.finance.tracker.operations.inputValidations;

import com.vishesh.personal.finance.tracker.model.AccountHolder;

public interface FieldValidation {
	 public void emailIdValidation(String email);
	 public void ageValidation(Integer age);
	 public void genaralFieldValidation(String value,String typeOfField);
	 public void genaralFieldValidation(Integer value,String typeOfField);
	 public void accountHolderValidation(AccountHolder accountHolder);
}
