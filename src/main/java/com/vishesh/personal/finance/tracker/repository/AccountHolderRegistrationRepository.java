package com.vishesh.personal.finance.tracker.repository;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import com.vishesh.personal.finance.tracker.repository.Entity.AccountHolderRegistrationEntity;


public interface AccountHolderRegistrationRepository extends CrudRepository<AccountHolderRegistrationEntity, BigDecimal>{
	@Query(nativeQuery = true,value="SELECT * FROM account_holder_registration WHERE account_number=:accountNumber")
	AccountHolderRegistrationEntity findByAccountNumber(@Param("accountNumber") String accountNumber);
	
	@Query(nativeQuery = true,value="SELECT * FROM account_holder_registration WHERE email_id=:emailId")
	AccountHolderRegistrationEntity findByEmailId(@Param("emailId") String emailId);
}
