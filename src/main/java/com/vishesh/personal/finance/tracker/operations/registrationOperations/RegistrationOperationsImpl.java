package com.vishesh.personal.finance.tracker.operations.registrationOperations;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vishesh.personal.finance.tracker.model.AccountHolder;
import com.vishesh.personal.finance.tracker.repository.AccountHolderRegistrationRepository;
import com.vishesh.personal.finance.tracker.repository.Entity.AccountHolderRegistrationEntity;

@Service
public class RegistrationOperationsImpl implements RegistrationOperations{
	@Autowired
	AccountHolderRegistrationRepository accountHolderRegistrationRepository;
	@Override
	public void storeRegistationDataInDb(AccountHolder accountHolder) {
		accountHolderExist(accountHolder.getHolderEmail());
		LocalDate date= LocalDate.now();
		Date todayDate=Date.valueOf(date);
		AccountHolderRegistrationEntity accountHolderRegistration = new AccountHolderRegistrationEntity();  
		accountHolderRegistration.setAccountNumber(generateAccountNumber());
		accountHolderRegistration.setFirstName(accountHolder.getHolderFirstName());
		accountHolderRegistration.setLast_name(accountHolder.getHolderLastName());
		accountHolderRegistration.setAge(accountHolder.getHolderAge());
		accountHolderRegistration.setOccupation(accountHolder.getHolderOccupation());
		accountHolderRegistration.setEmailId(accountHolder.getHolderEmail());
		accountHolderRegistration.setCreatedDate(todayDate);
		accountHolderRegistrationRepository.save(accountHolderRegistration);
	}
	
	@Override
	public String generateAccountNumber() {
		Random random=new Random();
		int count=1;
		String AccountNumber="";
		while(true)
		{
			AccountNumber+=(random.nextInt(10)+1);
			if(count==8)
			{
				break;
			}
			count++;
		}
		return AccountNumber;
	}

	@Override
	public void accountHolderExist(String emailId) {
		AccountHolderRegistrationEntity accountHolderEmailId=accountHolderRegistrationRepository.findByEmailId(emailId);
		if(accountHolderEmailId != null) {
			throw new Error("holder alredy existed");
		}
	}
	
}
