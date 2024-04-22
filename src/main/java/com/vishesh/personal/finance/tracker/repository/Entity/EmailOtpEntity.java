package com.vishesh.personal.finance.tracker.repository.Entity;

import java.math.BigDecimal;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="email_id_verification_otps")
public class EmailOtpEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private BigDecimal id;
	@Column(name="otp")
	private Integer otp;
	@Column(name="validity")
	private Boolean validity;
	
	public BigDecimal getId() {
		return id;
	}
	public void setId(BigDecimal id) {
		this.id = id;
	}
	@Column(name="email_id")
	private String emailId;
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public Integer getOtp() {
		return otp;
	}
	public void setOtp(Integer otp) {
		this.otp = otp;
	}
	public Boolean getValidity() {
		return validity;
	}
	public void setValidity(Boolean validity) {
		this.validity = validity;
	}	
	
	
}
