package com.hwsyndrome.helloworld.domain;

import javax.persistence.*;

@Entity
@Table(name = "t_customer")
public class Customer {

	@Id
	@Column
	private String name;
	
	@Column
	private int phoneNumber;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	
	
	
}
