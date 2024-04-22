package com.vishesh.personal.finance.tracker.model;

public class AccountHolder {
	private String holderFirstName;
	private String holderLastName;
	private String holderOccupation;
	private Integer holderAge;
	private String holderEmail;
	
	public String getHolderFirstName() {
		return this.holderFirstName;
	}
	public void setHolderFirstName(String holderFirstName) {
		this.holderFirstName = holderFirstName;
	}
	public String getHolderLastName() {
		return holderLastName;
	}
	public void setHolderLastName(String holderSecondName) {
		this.holderLastName = holderSecondName;
	}
	public String getHolderOccupation() {
		return holderOccupation;
	}
	public void setHolderOccupation(String holderOccupation) {
		this.holderOccupation = holderOccupation;
	}
	public Integer getHolderAge() {
		return holderAge;
	}
	public void setHolderAge(Integer holderAge) {
		this.holderAge = holderAge;
	}
	public String getHolderEmail() {
		return holderEmail;
	}
	public void setHolderEmail(String holderEmail) {
		this.holderEmail = holderEmail;
	}

}
