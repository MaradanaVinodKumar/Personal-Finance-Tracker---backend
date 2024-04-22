package com.vishesh.personal.finance.tracker.repository;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.vishesh.personal.finance.tracker.repository.Entity.EmailOtpEntity;

public interface EmailOtpRepository extends CrudRepository<EmailOtpEntity, BigDecimal>{
		@Query(nativeQuery = true,value="SELECT * FROM email_id_verification_otps where email_id=:emailId")
		EmailOtpEntity findByEmailId(@Param("emailId") String emailId);
		
		@Query(nativeQuery = true,value="UPDATE email_id_verification_otps SET otp =:otp , validity =:validity WHERE email_id=:emailId ")
		EmailOtpEntity updateByEmailId(@Param("emailId") String emailId, @Param("otp") Integer otp,@Param("validity") Boolean validity);
}
