package com.vishesh.personal.finance.tracker.operations.inputValidations;



import org.springframework.stereotype.Component;
import com.vishesh.personal.finance.tracker.model.AccountHolder;

@Component
public class FieldValidationImpl implements FieldValidation{
	private static final String EMAIL_REGEX = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
	
	
	@Override
	public void emailIdValidation(String email) {
		if(!email.matches(EMAIL_REGEX))
		{
			throw new Error("email not valid");
		}
		
	}

	@Override
	public void ageValidation(Integer age) {
		
		if(!((age>=18)&&(age<=90)))
		{
			throw new Error("age not valid");
		}
		
	}

	@Override
	public void genaralFieldValidation(String value,String typeOfField) {
		
		value=value.trim();
		if(value.equals(" ")){
			throw new Error(typeOfField+" field not valid");
		}
		
	}

	@Override
	public void genaralFieldValidation(Integer value,String typeOfField) {
		if(value == null)
		{
			throw new Error(typeOfField+ " not valid");
		}
		
	}

	@Override
	public void accountHolderValidation(AccountHolder accountHolder) {
		
		genaralFieldValidation(accountHolder.getHolderFirstName(),"First name");
		genaralFieldValidation(accountHolder.getHolderLastName(),"last name");
		genaralFieldValidation(accountHolder.getHolderOccupation(),"Occupation");
		ageValidation(accountHolder.getHolderAge());
		emailIdValidation(accountHolder.getHolderEmail());
		
	}

}
