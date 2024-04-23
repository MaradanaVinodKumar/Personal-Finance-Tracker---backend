package com.vishesh.personal.finance.tracker.repository;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.vishesh.personal.finance.tracker.repository.Entity.EmailOtpEntity;

@Transactional
public interface EmailOtpRepository extends CrudRepository<EmailOtpEntity, BigDecimal>{
		@Query(nativeQuery = true,value="SELECT * FROM email_id_verification_otps WHERE email_id=:emailId")
		EmailOtpEntity findByEmailId(@Param("emailId") String emailId);
		
		@Modifying
		@Query(nativeQuery = true,value="UPDATE email_id_verification_otps SET otp =:otp , validity =:validity WHERE email_id=:emailId")
		void updateByEmailId(@Param("emailId") String emailId, @Param("otp") Integer otp,@Param("validity") Boolean validity);
		
		@Modifying
		@Query(nativeQuery = true,value="UPDATE email_id_verification_otps SET validity =:validity WHERE email_id=:emailId")
		void updateOtpValidityByEmailId(@Param("emailId") String emailId, @Param("validity") Boolean validity);
		
		@Modifying
		@Query(nativeQuery = true,value="DELETE FROM email_id_verification_otps WHERE email_id=:emailId")
		void deleteByEmailId(@Param("emailId") String emailId);
}
